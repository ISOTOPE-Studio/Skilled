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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandSkilled implements CommandExecutor {
    private final Skilled plugin;

    public CommandSkilled(Skilled plugin) {
        this.plugin = plugin;
    }

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
                PlayerData data = new PlayerData(plugin);
                data.addSkillPoint(playerName, skillPoint);
                sender.sendMessage(new StringBuilder(Skilled.prefix).append(ChatColor.AQUA)
                        .append("成功给予玩家 " + playerName + " " + skillPoint + " 技能点").toString());
                return true;
            }
            if (args[0].equals("test"))
                ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                        Integer.parseInt(args[1]), Integer.parseInt(args[2])));
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.onReload();
                sender.sendMessage(
                        new StringBuilder(Skilled.prefix).append(ChatColor.AQUA).append("成功重新载入配置文件").toString());

            }
            return true;

        }
        return false;
    }
}