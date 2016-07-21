/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.command;

import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.gui.ClassGUI;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class CommandClass implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("class")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Msg.mustBePlayer);
                return true;
            }
            Player player = (Player) sender;
            if (args.length > 0) {
                if (!player.isOp() && ConfigData.onlyOnce && PlayerData.getClass(player) != null) {
                    player.sendMessage(Msg.hasClass);
                    return true;
                }
                int job;
                try {
                    job = Integer.parseInt(args[0]);
                } catch (Exception e) {
                    player.sendMessage(Msg.notNumber);
                    return true;
                }
                if (job < 1 || job > 8) {
                    player.sendMessage(Msg.notNumber);
                    return true;
                }
                if (!(player.hasPermission("Skilled.class." + job) || player.hasPermission("Skilled.class.*"))) {
                    player.sendMessage(Msg.noPermission);
                    return true;
                }
                String jobName = Names.getClassName(job);
                player.sendMessage(Msg.successJoin + Names.getClassColorName(job));
                PlayerData.setClass(player, jobName);
                PlayerData.setLevel(player, 1, 0);
                PlayerData.setLevel(player, 2, 0);
                PlayerData.setLevel(player, 3, 0);
                PlayerData.setLevel(player, 4, 0);
                PlayerData.setMagic(player, ConfigData.maxMagic);
                PlayerData.setSkillPoint(player, ConfigData.initialSkillPoint);
                plugin.savePlayersData();
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 1; i <= 8; i++) {
                    if (player.hasPermission("Skilled.class." + i) || player.hasPermission("Skilled.class.*")) {
                        list.add(i);
                    }
                }

                new ClassGUI(list).open(player);
            }
            return true;
        }
        return false;
    }
}