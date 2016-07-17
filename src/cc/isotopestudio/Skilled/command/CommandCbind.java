package cc.isotopestudio.Skilled.command;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.player.ItemUti;
import cc.isotopestudio.Skilled.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandCbind implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cBind")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Msg.commandcBind);
                sender.sendMessage(Msg.mustBePlayer);
                return true;
            }
            Player player = (Player) sender;
            if (args.length != 1) {
                player.sendMessage(Msg.commandcBind);
                return true;
            }
            int skill;
            try {
                skill = Integer.parseInt(args[0]);
            } catch (Exception e) {
                player.sendMessage(Msg.mustBeInt);
                return true;
            }
            if (!(skill >= 1 && skill <= 4)) {
                player.sendMessage(Msg.mustBeInt);
                return true;
            }
            if (!PlayerData.ifHasSkill(player, skill)) {
                player.sendMessage(Msg.noSkill);
                return true;
            }
            ItemStack item = player.getItemInHand();
            if (item == null || item.getType() == Material.AIR) {
                player.sendMessage(Msg.noItem);
                return true;
            }
            if (item.getItemMeta().hasDisplayName() || item.getItemMeta().hasLore()) {
                player.sendMessage(Msg.hasMetaData);
                return true;
            }
            if (item.getAmount() != 1) {
                player.sendMessage(Msg.mustbe1);
                return true;
            }
            ItemUti.addLore(item, PlayerData.getClass(player), skill);
            player.sendMessage(Skilled.prefix + ChatColor.AQUA + "³É¹¦°ó¶¨ ");
            return true;
        }
        return false;
    }
}