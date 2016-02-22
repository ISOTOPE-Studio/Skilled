package cc.isotopestudio.Skilled.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.gui.SelectClass;
import cc.isotopestudio.Skilled.gui.UpgradeSkill;
import cc.isotopestudio.Skilled.message.Msg;

public class CommandCSkill implements CommandExecutor {
	private final Skilled plugin;

	public CommandCSkill(Skilled plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("CSkill")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Msg.mustBePlayer);
				return true;
			}
			Player player = (Player) sender;
			UpgradeSkill.createMenu(plugin, player).open(player);
			return true;
		}
		return false;
	}
}