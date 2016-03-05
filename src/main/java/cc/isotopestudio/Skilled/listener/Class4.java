package cc.isotopestudio.Skilled.listener;

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

public class Class4 implements Listener {

	//铁卫
	//技能1：坚定不移：加抗性与血量 //点击空气
	//技能2：怒吼：发出一个火球，伤害：50 //点击空气
	//技能3：不屈：获得再生 II //点击空气
	//技能4：坚不可摧：三秒内无视伤害 //点击空气
	
	public static boolean onClass4Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, ( 5+3*level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3*level) * 20, (int) (1+level*0.05))); // Revise
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass4Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill2");
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass4Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (15+3*level) * 20, 2)); // Revise
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass4Skill4(Player player, int level, Skilled plugin) {// 三秒这个设定是不合理的，因为没有可升级性
		System.out.print("onClass4Skill4");
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, ( 5+3*level) * 20, 100)); // Revise
		player.sendMessage("成功释放！");
		return true;
	}

}
