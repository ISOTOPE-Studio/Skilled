package cc.isotopestudio.Skilled.player;

import cc.isotopestudio.Skilled.message.Names;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUti {

    public static ItemStack addLore(final ItemStack item, String job, final int skill) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Names.getSkillName(job, skill));

        List<String> lore = null;
        try {
            lore = item.getItemMeta().getLore();
        } catch (Exception ignored) {
        }
        if (lore == null) lore = new ArrayList<>();
        lore.add(String.valueOf(ChatColor.GOLD) + ChatColor.BOLD + "职业: " + job);

        lore.add(String.valueOf(ChatColor.YELLOW) + ChatColor.BOLD +
                "释放技能: " + Names.getSkillName(job, skill));
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

    public static String[] getLore(final ItemStack item) {
        String[] classAndSkill = new String[2];
        List<String> lore = item.getItemMeta().getLore();
        for (String temp : lore) {
            if (temp.contains("职业: ")) {
                classAndSkill[0] = temp.split(": ")[1];
            }
            if (temp.contains("释放技能: ")) {
                classAndSkill[1] = temp.split(": ")[1];
            }
        }
        return classAndSkill;
    }

}
