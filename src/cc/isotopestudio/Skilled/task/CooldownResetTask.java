package cc.isotopestudio.Skilled.task;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Iterator;
import java.util.Set;

public class CooldownResetTask extends BukkitRunnable {

    private final Skilled plugin;

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