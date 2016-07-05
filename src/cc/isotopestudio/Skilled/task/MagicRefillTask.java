package cc.isotopestudio.Skilled.task;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.player.PlayerData;

public class MagicRefillTask extends BukkitRunnable {

	private Skilled plugin;

	public MagicRefillTask(Skilled plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		Set<String> players = plugin.getPlayersData().getKeys(false);
		if (players.size() != 0) {
			PlayerData data = new PlayerData(plugin);
			int value = ConfigData.magicRefillValue;
			int max = ConfigData.maxMagic;
			Iterator<String> it = players.iterator();
			while (it.hasNext()) {
				Player player = Bukkit.getServer().getPlayer(it.next());
				if (player != null) {
					int newMagic = data.getMagic(player) + value;
					if (!(newMagic == max + value)) {
						if (newMagic > ConfigData.maxMagic) {
							newMagic = ConfigData.maxMagic;
						}
						data.setMagic(player, newMagic);
						player.sendMessage(new StringBuilder(Skilled.prefix).append(ChatColor.GOLD)
								.append("»Ö¸´Ä§·¨Öµ" + newMagic).toString());
					}
				}
			}
		}
	}

}
