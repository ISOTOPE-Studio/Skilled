/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.task;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class MagicRefillTask extends BukkitRunnable {

    @Override
    public void run() {
        boardcast();
        final int value = ConfigData.magicRefillValue;
        final int max = ConfigData.maxMagic;
        for (String playerName : plugin.getPlayersData().getKeys(false)) {
            Player player = Bukkit.getServer().getPlayer(playerName);
            if (player != null) {
                int newMagic = PlayerData.getMagic(player) + value;
                if (!(newMagic == max + value)) {
                    if (newMagic > ConfigData.maxMagic) {
                        newMagic = ConfigData.maxMagic;
                    }
                    PlayerData.setMagic(player, newMagic);
                    player.sendMessage(Skilled.prefix + ChatColor.GOLD +
                            "恢复魔法值" + newMagic + " / " + ConfigData.maxMagic);
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
