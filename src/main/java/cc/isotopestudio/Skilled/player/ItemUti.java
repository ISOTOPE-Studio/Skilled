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
		lore.add(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("ְҵ: " + job).toString());

		lore.add(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD)
				.append("�ͷż���: " + Names.getSkillName(job, skill)).toString());
		meta.setLore(lore);

		item.setItemMeta(meta);
	}

	public static String[] getLore(final ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		String[] classAndSkill = new String[2];
		List<String> lore = item.getItemMeta().getLore();
		for (String temp : lore) {
			if (temp.contains("ְҵ: ")) {
				classAndSkill[0] = temp.split(": ")[1];
			}
			if (temp.contains("�ͷż���: ")) {
				classAndSkill[1] = temp.split(": ")[1];
			}
		}
		return classAndSkill;
	}

}
