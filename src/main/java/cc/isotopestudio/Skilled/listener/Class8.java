package cc.isotopestudio.Skilled.listener;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.ItemUti;
import cc.isotopestudio.Skilled.player.PlayerData;

public class Class8 implements Listener {

	// 猎刃

	// 技能1：影：增加移动速度和攻击力以及生命恢复 //点击空气
	// 技能2：烈：单体伤害，附加点燃和虚弱 //点击生物
	// 技能3：暗：一定时间内攻击附带虚弱和失明 //点击空气
	// 技能4：刃：范围伤害，附带虚弱和凋零 //点击空气

	public static boolean onClass8Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level)); // Revise
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass8Skill2(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass8Skill2");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level)); // Revise
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level)); // Revise
		rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass8Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill3");
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass8Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill4");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		if (near.size() < 1) {
			player.sendMessage("周围无生物！");
			return false;
		}
		for (Entity entity : near) {
			if (entity.getLocation().distance(player.getLocation()) <= radius) {
				if (entity.equals(player))
					continue;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffect(
							new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, (int) (1 + level * 0.05)));
					((LivingEntity) entity).addPotionEffect(
							new PotionEffect(PotionEffectType.WITHER, (5 + 3 * level) * 20, (int) (1 + level * 0.05)));
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
							(5 + 3 * level) * 20, (int) (1 + level * 0.05)));

				}
			}
		}
		player.sendMessage("成功释放！");
		return true;
	}

}
