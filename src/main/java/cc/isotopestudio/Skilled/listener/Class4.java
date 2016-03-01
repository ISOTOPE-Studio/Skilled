package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

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
	
	public static void onClass4Skill1(Player player, Skilled plugin) {
		System.out.print("onClass4Skill1");
	}

	public static void onClass4Skill2(Player player, Skilled plugin) {
		System.out.print("onClass4Skill2");
	}

	public static void onClass4Skill3(Player player, Skilled plugin) {
		System.out.print("onClass4Skill3");
	}

	public static void onClass4Skill4(Player player, Skilled plugin) {
		System.out.print("onClass4Skill4");
	}

}
