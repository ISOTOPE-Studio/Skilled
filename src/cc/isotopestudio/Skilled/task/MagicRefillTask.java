package cc.isotopestudio.Skilled.task;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

public class MagicRefillTask extends BukkitRunnable {

    private final Skilled plugin;

    public MagicRefillTask(Skilled plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        boardcast();
        Set<String> players = plugin.getPlayersData().getKeys(false);
        if (players.size() != 0) {
            PlayerData data = new PlayerData(plugin);
            int value = ConfigData.magicRefillValue;
            int max = ConfigData.maxMagic;
            for (String player1 : players) {
                Player player = Bukkit.getServer().getPlayer(player1);
                if (player != null) {
                    int newMagic = data.getMagic(player) + value;
                    if (!(newMagic == max + value)) {
                        if (newMagic > ConfigData.maxMagic) {
                            newMagic = ConfigData.maxMagic;
                        }
                        data.setMagic(player, newMagic);
                        player.sendMessage(Skilled.prefix + ChatColor.GOLD +
                                "恢复魔法值" + newMagic + " / " + ConfigData.maxMagic);
                    }
                }
            }
        }
    }

    private static final String link = "http://www.isotopestudio.cc/wiki/doku.php?id=discussion:skilled";

    private static void boardcast() {
        if (Math.random() < 0.01) {
            Bukkit.broadcastMessage(Skilled.prefix + ChatColor.GOLD + "请到这里提供任何建议和BUG  " + ChatColor.GRAY + link);
        }
    }

}
