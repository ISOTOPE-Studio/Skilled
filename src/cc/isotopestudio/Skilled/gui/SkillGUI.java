package cc.isotopestudio.Skilled.gui;

import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.ItemUti;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class SkillGUI extends GUI {

    public SkillGUI(Player player) {
        super(title);
        String job = PlayerData.getClass(player);
        String[] skillsName = new String[5];
        String[][] skillsDescription = new String[5][4];
        int[] skillsLevel = new int[5];
        for (int i = 1; i <= 4; i++) {
            skillsLevel[i] = PlayerData.getLevel(player, i);
            skillsName[i] = Names.getSkillColorName(job, i);
            skillsDescription[i][0] = Names.getSkillColorInfo(job, i).split(": ")[1];
            if (skillsLevel[i] == 0) {
                skillsDescription[i][1] = unlock;
                skillsDescription[i][2] = unlockRequire + ConfigData.getUnlockRequiredSkillPoint(job, i);
            } else {
                skillsDescription[i][1] = upgrade + skillsLevel[i];
                skillsDescription[i][2] = upgradeRequire + ConfigData.getUpgradeRequiredSkillPoint(job, i);
            }
            skillsDescription[i][3] = magicRequired + ConfigData.getRequiredMagic(job, i);
        }
        setOption(0, new ItemStack(Material.NETHER_STAR, 1), intro[0], intro[1] + PlayerData.getSkillPoint(player),
                intro[2]);
        setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[1], skillsDescription[1][0],
                skillsDescription[1][1], skillsDescription[1][2], skillsDescription[1][3]);
        setOption(2, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[2], skillsDescription[2][0],
                skillsDescription[2][1], skillsDescription[2][2], skillsDescription[2][3]);
        setOption(3, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[3], skillsDescription[3][0],
                skillsDescription[3][1], skillsDescription[3][2], skillsDescription[3][3]);
        setOption(4, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[4], skillsDescription[4][0],
                skillsDescription[4][1], skillsDescription[4][2], skillsDescription[4][3]);
    }

    private static final String title = String.valueOf(ChatColor.GOLD) + ChatColor.BOLD + "技能升级";

    private static final String[] intro = {
            String.valueOf(ChatColor.GOLD) + ChatColor.BOLD + "升级或解锁技能！",
            String.valueOf(ChatColor.GREEN) + ChatColor.ITALIC + "你的技能点数: ",
            String.valueOf(ChatColor.AQUA) + ChatColor.ITALIC + "单击即可解锁或者升级技能"};

    private static final String unlock = String.valueOf(ChatColor.BLUE) + ChatColor.ITALIC + "未解锁";
    private static final String unlockRequire = String.valueOf(ChatColor.RED) + ChatColor.ITALIC +
            "解锁所需技能点: ";
    private static final String upgrade = String.valueOf(ChatColor.BLUE) + ChatColor.ITALIC + "当前等级: ";
    private static final String upgradeRequire = String.valueOf(ChatColor.GREEN) + ChatColor.ITALIC +
            "升级所需技能点: ";
    private static final String magicRequired = String.valueOf(ChatColor.YELLOW) + ChatColor.ITALIC +
            "使用所需法力值: ";

    @Override
    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getName().equals(name)) {
            event.setCancelled(true);
            int slot = event.getRawSlot();
            if (slot < 0 || slot >= size) {
                return;
            }
            if (optionIcons[slot] == null) {
                return;
            }
            Player player = (Player) event.getWhoClicked();
            int skillPoint = PlayerData.getSkillPoint(player);
            String jobString = PlayerData.getClass(player);
            int skill = event.getSlot();
            int level = PlayerData.getLevel(player, skill);
            int reqPoint;
            boolean unlock1 = false;
            if (level == 0) {
                reqPoint = ConfigData.getUnlockRequiredSkillPoint(jobString, skill);
                unlock1 = true;
            } else {
                reqPoint = ConfigData.getUpgradeRequiredSkillPoint(jobString, skill);
            }
            if (skillPoint >= reqPoint) {
                PlayerData.addLevel(player, skill);
                PlayerData.addSkillPoint(player, -reqPoint);
                plugin.savePlayersData();
                if (unlock1) {
                    int i = (int) (Math.random() * DyeColor.values().length);
                    ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) i);
                    player.getInventory().addItem(ItemUti.addLore(item, jobString, skill));
                    player.sendMessage(Msg.successUnlock + Names.getSkillColorName(jobString, skill));
                } else
                    player.sendMessage(Msg.successUpgrade + Names.getSkillColorName(jobString, skill));
            } else {
                player.sendMessage(Msg.noSkillPoint);
            }
            player.closeInventory();
        }
    }
}
