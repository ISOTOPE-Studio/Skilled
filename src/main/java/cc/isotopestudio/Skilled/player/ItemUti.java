package cc.isotopestudio.Skilled.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.isotopestudio.Skilled.Skilled;

public class ItemUti {

	private final Skilled plugin;

	public ItemUti(Skilled plugin) {
		this.plugin = plugin;
	}

	public void addLore(final ItemStack item, final int skill) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("道具");

		List<String> lore = item.getItemMeta().getLore();
		lore = new ArrayList<String>();
		lore.add(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("--强化--" + skill)
				.toString());
		meta.setLore(lore);

		item.setItemMeta(meta);
	}

}
