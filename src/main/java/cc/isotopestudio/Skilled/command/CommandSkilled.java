package cc.isotopestudio.Skilled.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.player.PlayerData;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class CommandSkilled implements CommandExecutor {
	private final Skilled plugin;

	public CommandSkilled(Skilled plugin) {
		this.plugin = plugin;
	}

	ParticleEffect[] effect = { ParticleEffect.BARRIER, ParticleEffect.BLOCK_CRACK, ParticleEffect.BLOCK_DUST,
			ParticleEffect.CLOUD, ParticleEffect.CRIT, ParticleEffect.CRIT_MAGIC, ParticleEffect.DRIP_LAVA,
			ParticleEffect.DRIP_WATER, ParticleEffect.ENCHANTMENT_TABLE, ParticleEffect.EXPLOSION_HUGE,
			ParticleEffect.EXPLOSION_LARGE, ParticleEffect.EXPLOSION_NORMAL, ParticleEffect.FIREWORKS_SPARK,
			ParticleEffect.FLAME, ParticleEffect.FOOTSTEP, ParticleEffect.HEART, ParticleEffect.ITEM_CRACK,
			ParticleEffect.ITEM_TAKE, ParticleEffect.LAVA, ParticleEffect.MOB_APPEARANCE, ParticleEffect.NOTE,
			ParticleEffect.PORTAL, ParticleEffect.REDSTONE, ParticleEffect.SLIME, ParticleEffect.SMOKE_LARGE,
			ParticleEffect.SMOKE_NORMAL, ParticleEffect.SNOW_SHOVEL, ParticleEffect.SNOWBALL, ParticleEffect.SPELL,
			ParticleEffect.SPELL_INSTANT, ParticleEffect.SPELL_MOB, ParticleEffect.SPELL_MOB_AMBIENT,
			ParticleEffect.SPELL_WITCH, ParticleEffect.SUSPENDED, ParticleEffect.SUSPENDED_DEPTH,
			ParticleEffect.TOWN_AURA, ParticleEffect.VILLAGER_ANGRY, ParticleEffect.VILLAGER_HAPPY,
			ParticleEffect.WATER_BUBBLE, ParticleEffect.WATER_DROP, ParticleEffect.WATER_SPLASH,
			ParticleEffect.WATER_WAKE };

	void sendEffect(final Player player, final String[] args, final int i) {
		new BukkitRunnable() {
			public void run() {
				if (i < 41) {
					sendEffect(player, args, i + 1);
				}
				player.sendMessage(effect[i].getName());
				effect[i].display(0F, 5F, 0F, Float.parseFloat(args[0]), Integer.parseInt(args[1]),
						player.getLocation(), 10);
			}
		}.runTaskLater(plugin, 10);

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("Skilled")) {
			if (!sender.hasPermission("Skilled.admin")) {
				sender.sendMessage(Msg.noPermission);
				return true;
			}
			sendEffect((Player) sender, args, 0);
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