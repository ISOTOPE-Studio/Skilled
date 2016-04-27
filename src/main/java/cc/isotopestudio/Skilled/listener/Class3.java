package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import cc.isotopestudio.Skilled.utli.SkilledMetaData;

public class Class3 {

	// 鹰眼
	// 技能1：警惕：加移动速度和跳跃 //点击空气
	// 技能2：魔法箭：射出的箭附带随机负面效果 //点击空气
	// 技能3：轻语：增加攻击力 //点击空气
	// 技能4：箭雨：从空中落下一片箭雨 //点击空气

	public static boolean onClass3Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

	public static boolean onClass3Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill2");
		return true;
	}

	public static boolean onClass3Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (7 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

	public static boolean onClass3Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill4");
		Bat bat = (Bat) player.getWorld().spawnEntity(player.getLocation().add(0, 5, 0), EntityType.BAT);
		bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (5 + 3 * level) * 20, 1, true));
		Vector[] v = new Vector[10];
		v[0] = new Vector(2, -2, 0);
		v[1] = new Vector(1, -2, 0);
		v[2] = new Vector(1, -2, 0.2);
		v[3] = new Vector(1, -2, -0.2);
		v[4] = new Vector(2, -2, 1);
		v[5] = new Vector(1, -2, -1);
		v[6] = new Vector(1, -2, 1);
		v[7] = new Vector(1, -2, 1);
		v[8] = new Vector(1, -2, -1);
		v[9] = new Vector(-2, -2, 0);
		byte b = 0;
		SkilledMetaData data = new SkilledMetaData(plugin, b);
		for (int i = 0; i < 10; i++) {
			Arrow arrow = ((ProjectileSource) bat).launchProjectile(Arrow.class, v[i]);
			// arrow.setShooter(player);
			arrow.setMetadata("pickup", data);
			// arrow.
		}
		bat.remove();
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

}
