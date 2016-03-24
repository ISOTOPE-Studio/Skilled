package cc.isotopestudio.Skilled.task;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.player.PlayerData;

public class CooldownResetTask extends BukkitRunnable {

	private Skilled plugin;

	public CooldownResetTask(Skilled plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		Set<String> players = plugin.getPlayersData().getKeys(false);
		if (players.size() != 0) {
			PlayerData data = new PlayerData(plugin);
			Iterator<String> it = players.iterator();
			String name;
			while (it.hasNext()) {
				name = it.next();
				for (int i = 1; i <= 4; i++)
					data.setCooldown(name, i, false);
			}
		}
	}

}
