package cc.isotopestudio.Skilled.command;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.gui.SkillGUI;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
            PlayerData data = new PlayerData(plugin);
            if (data.getClass(player) == null) {
                player.sendMessage(Msg.noClass);
                return true;
            }
            new SkillGUI(player).open(player);
            return true;
        }
        return false;
    }
}