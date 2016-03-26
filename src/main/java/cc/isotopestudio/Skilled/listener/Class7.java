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

public class Class7 {

	// 光骑

	// 技能1：审判：造成单体伤害并点燃目标 //点击生物
	// 技能2：守护：范围增加抗性 //点击空气
	// 技能3：祈祷：生命吸收，伤害增加 //点击空气
	// 技能4：神临：无敌 //点击空气

	public static boolean onClass7Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass7Skill1");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level, false)); // Revise
		rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
		player.sendMessage(Msg.release);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass7Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill2");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		int count = 0;
		for (Entity entity : near) {
			if (entity.getLocation().distance(player.getLocation()) <= radius)
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
							(5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
					ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, entity.getLocation(), 20);
					count++;
				}
		}
		if (count <= 1) {
			player.sendMessage(Msg.noLife);
			return false;
		}
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass7Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass7Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill4");
		player.sendMessage(Msg.release);
		return true;
	}

}
