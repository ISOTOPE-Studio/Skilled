package cc.isotopestudio.Skilled.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class Class2 {

	// 暗影
	// 技能1：影击：瞬移到背后给敌人一击 //点击玩家
	// 技能2：影化：隐身 //点击空气
	// 技能3：孤注一掷：血量减少，攻击力上升 //点击空气
	// 技能4：影舞：挥动匕首，使周围敌人受到伤害，并且附带中毒效果 //点击空气

	public static boolean onClass2Skill1(Player player, Player rightClicked, int level, Skilled plugin) {
		System.out.print("onClass2Skill1");
		Location location = rightClicked.getLocation();
		return true;
	}

	public static boolean onClass2Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill2");
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (5 + 3 * level) * 20, 1, true)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass2Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill3");
		double health = player.getHealth() * 0.6;// Revise
		player.setHealth(health);
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass2Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill4");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
		effects.add(new PotionEffect(PotionEffectType.HARM, 1, level, false)); // Revise
		effects.add(new PotionEffect(PotionEffectType.POISON, 3 * level * 20, level, false)); // Revise
		int count = 0;
		for (Entity entity : near) {
			if (entity.equals(player))
				continue;
			if (entity.getLocation().distance(player.getLocation()) <= radius)
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffects(effects);
					ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, entity.getLocation(), 20);
					count++;
				}
		}
		player.sendMessage(Msg.release);
		return true;
	}

}
