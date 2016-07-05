package cc.isotopestudio.Skilled.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Names;

public class ItemUti {

	private final Skilled plugin;

	public ItemUti(Skilled plugin) {
		this.plugin = plugin;
	}

	public static void addLore(final ItemStack item, String job, final int skill) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Names.getSkillName(job, skill));

		List<String> lore = item.getItemMeta().getLore();
		lore = new ArrayList<String>();
		lore.add(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("职业: " + job).toString());

		lore.add(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD)
				.append("释放技能: " + Names.getSkillName(job, skill)).toString());
		meta.setLore(lore);

		item.setItemMeta(meta);
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
