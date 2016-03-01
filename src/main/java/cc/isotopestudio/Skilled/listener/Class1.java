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

public class Class1 implements Listener {
	// 圣谕

	// 技能1：治愈：恢复目标生命值 //点击生物
	// 技能2：活力：恢复目标法力值 //点击玩家
	// 技能3：神圣打击：召唤天雷攻击敌人 //点击空气
	// 技能4：生命源泉：群体恢复 //点击空气

	public static void onClass1Skill1(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass1Skill1");
		double health = rightClicked.getHealth();
		if (rightClicked.getMaxHealth() == health) {
			player.sendMessage(Skilled.prefix + "已经满血");
			return;
		}
		PlayerData data = new PlayerData(plugin);
		if (data.getMagic(player) < ConfigData.getRequiredMagic(Names.getClassName(1), 1)) {
			return;
		}
		health += 5;
		if (health > rightClicked.getMaxHealth()) {
			health = rightClicked.getMaxHealth();
		}

		rightClicked.setHealth(rightClicked.getHealth());
		player.sendMessage("成功释放！");
	}

	public static void onClass1Skill2(Player player, Player rightClicked, Skilled plugin) {
		System.out.print("onClass1Skill2");
	}

	public static void onClass1Skill3(Player player, Skilled skilled) {
		System.out.print("onClass1Skill3");
	}

	public static void onClass1Skill4(Player player, Skilled skilled) {
		System.out.print("onClass1Skill4");
	}

}
