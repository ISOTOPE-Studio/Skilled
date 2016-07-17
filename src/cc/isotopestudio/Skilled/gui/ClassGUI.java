package cc.isotopestudio.Skilled.gui;

import cc.isotopestudio.Skilled.message.Names;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ClassGUI extends GUI {

    public ClassGUI(ArrayList<Integer> list) {
        super(title);
        setOption(0, new ItemStack(Material.NETHER_STAR, 1), intro[0], intro[1], intro[2]);
        for (int i = 1; i <= 8; i++)
            setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), unknownJob, questionMark);
        for (int job : list) {
            switch (job) {
                case (1): {
                    setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), Names.getClassColorName(1), skill,
                            Names.getSkillColorInfo(1, 1), Names.getSkillColorInfo(1, 2), Names.getSkillColorInfo(1, 3),
                            Names.getSkillColorInfo(1, 4));
                    break;
                }
                case (2): {
                    setOption(2, new ItemStack(Material.HOPPER, 1), Names.getClassColorName(2), skill,
                            Names.getSkillColorInfo(2, 1), Names.getSkillColorInfo(2, 2), Names.getSkillColorInfo(2, 3),
                            Names.getSkillColorInfo(2, 4));
                    break;
                }
                case (3): {
                    setOption(3, new ItemStack(Material.EYE_OF_ENDER, 1), Names.getClassColorName(3), skill,
                            Names.getSkillColorInfo(3, 1), Names.getSkillColorInfo(3, 2), Names.getSkillColorInfo(3, 3),
                            Names.getSkillColorInfo(3, 4));
                    break;
                }
                case (4): {
                    setOption(4, new ItemStack(Material.IRON_FENCE, 1), Names.getClassColorName(4), skill,
                            Names.getSkillColorInfo(4, 1), Names.getSkillColorInfo(4, 2), Names.getSkillColorInfo(4, 3),
                            Names.getSkillColorInfo(4, 4));
                    break;
                }
                case (5): {
                    setOption(5, new ItemStack(Material.REDSTONE, 1), Names.getClassColorName(5), skill,
                            Names.getSkillColorInfo(5, 1), Names.getSkillColorInfo(5, 2), Names.getSkillColorInfo(5, 3),
                            Names.getSkillColorInfo(5, 4));
                    break;
                }
                case (6): {
                    setOption(6, new ItemStack(Material.SOUL_SAND, 1), Names.getClassColorName(6), skill,
                            Names.getSkillColorInfo(6, 1), Names.getSkillColorInfo(6, 2), Names.getSkillColorInfo(6, 3),
                            Names.getSkillColorInfo(6, 4));
                    break;
                }
                case (7): {
                    setOption(7, new ItemStack(Material.DOUBLE_PLANT, 1), Names.getClassColorName(7), skill,
                            Names.getSkillColorInfo(7, 1), Names.getSkillColorInfo(7, 2), Names.getSkillColorInfo(7, 3),
                            Names.getSkillColorInfo(7, 4));
                    break;
                }
                case (8): {
                    setOption(8, new ItemStack(Material.GOLD_HOE, 1), Names.getClassColorName(8), skill,
                            Names.getSkillColorInfo(8, 1), Names.getSkillColorInfo(7, 2), Names.getSkillColorInfo(8, 3),
                            Names.getSkillColorInfo(8, 4));
                    break;
                }
            }
        }
    }

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
            int job = Names.getClassNum(optionNames[slot].substring(4));
            event.getWhoClicked().closeInventory();
            ((Player) event.getWhoClicked()).performCommand("class " + job);
        }
    }

    private static final String title = String.valueOf(ChatColor.GOLD) + ChatColor.BOLD + "职业选择";
    private static final String unknownJob = String.valueOf(ChatColor.BLUE) + ChatColor.ITALIC + "隐藏职业";
    private static final String questionMark = String.valueOf(ChatColor.BLACK) + ChatColor.ITALIC + "????";
    private static final String[] intro = {String.valueOf(ChatColor.GOLD) + ChatColor.BOLD + "说明",
            String.valueOf(ChatColor.GREEN) + ChatColor.ITALIC + "这里是可以选择的职业",
            String.valueOf(ChatColor.AQUA) + ChatColor.ITALIC + "单击即可加入一个职业"};
    private static final String skill = String.valueOf(ChatColor.AQUA) + ChatColor.ITALIC + "技能: ";

}
