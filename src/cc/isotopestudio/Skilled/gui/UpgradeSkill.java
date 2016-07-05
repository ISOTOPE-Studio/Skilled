package cc.isotopestudio.Skilled.gui;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class UpgradeSkill {

    private static final String title = new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("��������")
            .toString();

    private static final String[] intro = {
            new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("������������ܣ�").toString(),
            new StringBuilder().append(ChatColor.GREEN).append(ChatColor.ITALIC).append("��ļ��ܵ���: ").toString(),
            new StringBuilder().append(ChatColor.AQUA).append(ChatColor.ITALIC).append("�������ɽ���������������").toString()};

    private static final String unlock = new StringBuilder().append(ChatColor.BLUE).append(ChatColor.ITALIC).append("δ����")
            .toString();
    private static final String unlockRequire = new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC)
            .append("�������輼�ܵ�: ").toString();
    private static final String upgrade = new StringBuilder().append(ChatColor.BLUE).append(ChatColor.ITALIC).append("��ǰ�ȼ�: ")
            .toString();
    private static final String upgradeRequire = new StringBuilder().append(ChatColor.GREEN).append(ChatColor.ITALIC)
            .append("�������輼�ܵ�: ").toString();
    private static final String magicRequired = new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.ITALIC)
            .append("ʹ�����跨��ֵ: ").toString();

    public static ClassGUI createMenu(final Skilled plugin, Player player) {
        PlayerData data = new PlayerData(plugin);
        String job = data.getClass(player);
        String[] skillsName = new String[5];
        String[][] skillsDescription = new String[5][4];
        int[] skillsLevel = new int[5];
        for (int i = 1; i <= 4; i++) {
            skillsLevel[i] = data.getLevel(player, i);
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
        return new ClassGUI(title, 9, new ClassGUI.OptionClickEventHandler() {
            @Override
            public void onOptionClick(ClassGUI.OptionClickEvent event) {
                event.setWillClose(true);
                event.setWillDestroy(true);
                PlayerData data1 = new PlayerData(plugin);
                int skillPoint = data1.getSkillPoint(event.getPlayer());
                String job1 = data1.getClass(event.getPlayer());
                int skill = Names.getSkillNum(event.getName().substring(4));
                int reqPoint = 0;
                boolean unlock1 = false;
                if (skill == 0) {
                    reqPoint = ConfigData.getUnlockRequiredSkillPoint(job1, skill);
                    unlock1 = true;
                } else {
                    reqPoint = ConfigData.getUpgradeRequiredSkillPoint(job1, skill);
                }
                if (skillPoint >= reqPoint) {
                    data1.addLevel(event.getPlayer(), skill);
                    data1.addSkillPoint(event.getPlayer(), -reqPoint);
                    plugin.savePlayersData();
                    if (unlock1)
                        event.getPlayer().sendMessage(Msg.successUnlock + event.getName());
                    else
                        event.getPlayer().sendMessage(Msg.successUpgrade + event.getName());
                } else {
                    event.getPlayer().sendMessage(Msg.noSkillPoint);
                }
            }
        }, plugin, true)
                .setOption(0, new ItemStack(Material.NETHER_STAR, 1), intro[0], intro[1] + data.getSkillPoint(player),
                        intro[2])
                .setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[1], skillsDescription[1][0],
                        skillsDescription[1][1], skillsDescription[1][2], skillsDescription[1][3])
                .setOption(2, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[2], skillsDescription[2][0],
                        skillsDescription[2][1], skillsDescription[2][2], skillsDescription[2][3])
                .setOption(3, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[3], skillsDescription[3][0],
                        skillsDescription[3][1], skillsDescription[3][2], skillsDescription[3][3])
                .setOption(4, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[4], skillsDescription[4][0],
                        skillsDescription[4][1], skillsDescription[4][2], skillsDescription[4][3]);
    }

}
