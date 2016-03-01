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

public class Class6 implements Listener {

	// 引魂
	// 技能1：控魂：使敌人减速 //点击生物
	// 技能2：诱魂：造成单体伤害并使敌人进入负面效果 //点击生物
	// 技能3：破魂：造成范围击退并产生短暂的禁锢 //点击空气
	// 技能4：灭火：单体攻击，有较小几率秒杀敌人，失败则造成少量伤害 //点击生物

	public static void onClass6Skill1(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass6Skill1");
	}

	public static void onClass6Skill2(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass6Skill2");
	}

	public static void onClass6Skill3(Player player, Skilled plugin) {
		System.out.print("onClass6Skill3");
	}

	public static void onClass6Skill4(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass6Skill4");
	}

}
