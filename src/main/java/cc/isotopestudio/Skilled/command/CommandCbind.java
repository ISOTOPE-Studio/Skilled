package cc.isotopestudio.Skilled.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;

public class CommandCbind implements CommandExecutor {
	private final Skilled plugin;

	public CommandCbind(Skilled plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("cBind")) {
			if(!(sender instanceof Player)){
				
				return true;
			}
			if (args.length == 1) {

				return true;
			}
			else{
				
				return true;
			}
		}
		return false;
	}
}