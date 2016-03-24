package cc.isotopestudio.Skilled.listener;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class Class8 {

	// 猎刃

	// 技能1：影：增加移动速度和攻击力以及生命恢复 //点击空气
	// 技能2：烈：单体伤害，附加点燃和虚弱 //点击生物
	// 技能3：暗：一定时间内攻击附带虚弱和失明 //点击空气
	// 技能4：刃：范围伤害，附带虚弱和凋零 //点击空气

	public static boolean onClass8Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass8Skill2(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass8Skill2");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level, false)); // Revise
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
		rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass8Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill3");
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass8Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill4");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		int count = 0;
		for (Entity entity : near) {
			if (entity.getLocation().distance(player.getLocation()) <= radius) {
				if (entity.equals(player))
					continue;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.HARM,
							(5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
							(5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
							(5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
					ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, entity.getLocation(), 20);
					count++;
				}
			}
		}
		if (count == 0) {
			player.sendMessage("周围无生物！");
			return false;
		}
		player.sendMessage(Msg.release);
		return true;
	}

}
