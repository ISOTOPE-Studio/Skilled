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

public class Class2 implements Listener {

	// 暗影
	// 技能1：影击：瞬移到背后给敌人一击 //点击玩家
	// 技能2：影化：隐身 //点击空气
	// 技能3：孤注一掷：血量减少，攻击力上升 //点击空气
	// 技能4：影舞：挥动匕首，使周围敌人受到伤害，并且附带中毒效果 //点击空气

	public static boolean onClass2Skill1(Player player, Player rightClicked, Skilled plugin) {
		System.out.print("onClass2Skill1");
		return true;
	}

	public static boolean onClass2Skill2(Player player, Skilled plugin) {
		System.out.print("onClass2Skill2");
		return true;
	}

	public static boolean onClass2Skill3(Player player, Skilled plugin) {
		System.out.print("onClass2Skill3");
		return true;
	}

	public static boolean onClass2Skill4(Player player, Skilled plugin) {
		System.out.print("onClass2Skill4");
		return true;
	}

}
