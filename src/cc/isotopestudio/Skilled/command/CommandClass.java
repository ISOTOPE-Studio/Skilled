package cc.isotopestudio.Skilled.command;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.gui.SelectClass;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;

public class CommandClass implements CommandExecutor {
	private final Skilled plugin;

	public CommandClass(Skilled plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("class")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Msg.mustBePlayer);
				return true;
			}
			Player player = (Player) sender;
			if (args.length > 0) {
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
				PlayerData data = new PlayerData(plugin);
				data.setClass(player, jobName);
				data.setLevel(player, 1, 0);
				data.setLevel(player, 2, 0);
				data.setLevel(player, 3, 0);
				data.setLevel(player, 4, 0);
				data.setMagic(player, 200);
				data.setSkillPoint(player, 10);
				plugin.savePlayersData();
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 6; i <= 8; i++) {
					if (player.hasPermission("Skilled.class." + i) || player.hasPermission("Skilled.class.*")) {
						list.add(i);
					}
				}

				SelectClass.createMenu(plugin, list).open(player);
			}
			return true;
		}
		return false;
	}
}