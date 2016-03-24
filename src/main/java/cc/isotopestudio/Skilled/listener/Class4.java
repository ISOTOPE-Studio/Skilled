package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class Class4 {

	// 铁卫
	// 技能1：坚定不移：加抗性与血量 //点击空气
	// 技能2：怒吼：发出一个火球，伤害：50 //点击空气
	// 技能3：不屈：获得再生 II //点击空气
	// 技能4：坚不可摧：三秒内无视伤害 //点击空气

	public static boolean onClass4Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20,
				(int) (1 + level * 0.05), false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass4Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill2");
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass4Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (15 + 3 * level) * 20, 2, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass4Skill4(Player player, int level, Skilled plugin) {// 三秒这个设定是不合理的，因为没有可升级性
		System.out.print("onClass4Skill4");
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20, 100, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

}
