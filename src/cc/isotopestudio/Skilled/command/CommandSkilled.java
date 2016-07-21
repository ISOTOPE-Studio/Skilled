/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.command;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class CommandSkilled implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Skilled")) {
            if (!sender.hasPermission("Skilled.admin")) {
                sender.sendMessage(Msg.noPermission);
                return true;
            }
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(Skilled.prefix);
                sender.sendMessage(Msg.commandSkilledAddsp);
                return true;
            }
            if (args[0].equalsIgnoreCase("info")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.sendMessage("职业：" + PlayerData.getClass(player));
                    player.sendMessage("魔法值：" + PlayerData.getMagic(player));
                    player.sendMessage("技能：" + PlayerData.getLevel(player, 1) + ", " + PlayerData.getLevel(player, 2) + ","
                            + PlayerData.getLevel(player, 3) + ", " + PlayerData.getLevel(player, 4));
                    player.sendMessage("技能点：" + PlayerData.getSkillPoint(player));
                }
            }
            if (args[0].equalsIgnoreCase("addsp")) {
                if (args.length != 3) {
                    sender.sendMessage(Msg.commandSkilledAddsp);
                    return true;
                }
                Player player = Bukkit.getServer().getPlayer(args[1]);
                String playerName = args[1];
                // Check player online
                if (player != null) {
                    playerName = player.getName();
                } else {
                    sender.sendMessage(Msg.playerNotOnline);
                }
                int skillPoint = 0;
                try {
                    skillPoint = Integer.parseInt(args[2]);
                } catch (Exception e) {
                    sender.sendMessage(Msg.mustBeInt);
                    return true;
                }
                PlayerData.addSkillPoint(playerName, skillPoint);
                sender.sendMessage(Skilled.prefix + ChatColor.AQUA + "成功给予玩家 " + playerName + " " + skillPoint + " 技能点");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.onReload();
                sender.sendMessage(
                        Skilled.prefix + ChatColor.AQUA + "成功重新载入配置文件");

            }
            return true;

        }
        return false;
    }
}