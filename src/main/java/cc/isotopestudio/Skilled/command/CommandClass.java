package cc.isotopestudio.Skilled.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;

public class CommandClass implements CommandExecutor {
	private final Skilled plugin;

	public CommandClass(Skilled plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("class")) {
			if (!(sender instanceof Player)) {

				return true;
			}
			
			return true;
		}
		return false;
	}
}