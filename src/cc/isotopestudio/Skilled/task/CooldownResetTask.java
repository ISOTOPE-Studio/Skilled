/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.task;

import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.scheduler.BukkitRunnable;

import static cc.isotopestudio.Skilled.Skilled.playerData;

public class CooldownResetTask extends BukkitRunnable {

    @Override
    public void run() {
        for (String player : playerData.getKeys(false)) {
            for (int i = 1; i <= 4; i++)
                PlayerData.setCooldown(player, i, false);
        }
    }

}
