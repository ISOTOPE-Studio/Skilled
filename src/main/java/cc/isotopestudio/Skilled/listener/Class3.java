package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;

public class Class3 implements Listener {

	// 鹰眼
	// 技能1：警惕：加移动速度和跳跃 //点击空气
	// 技能2：魔法箭：射出的箭附带随机负面效果 //点击空气
	// 技能3：轻语：增加攻击力 //点击空气
	// 技能4：箭雨：从空中落下一片箭雨 //点击空气

	public static boolean onClass3Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (5 + level) * 20, (int) (1 + level * 0.5))); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + level) * 20, (int) (1 + level * 0.5))); // Revise
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass3Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill2");
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass3Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill3");
		player.addPotionEffect(
				new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (7 + level) * 20, (int) (1.5 + level * 0.5))); // Revise
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass3Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill4");
		player.sendMessage("成功释放！");
		return true;
	}

}
