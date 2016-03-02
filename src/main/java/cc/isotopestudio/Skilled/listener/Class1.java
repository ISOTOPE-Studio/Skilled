package cc.isotopestudio.Skilled.listener;

import java.util.List;

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

	public static boolean onClass1Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass1Skill1");
		double health = rightClicked.getHealth();
		if (rightClicked.getMaxHealth() == health) {
			player.sendMessage(Skilled.prefix + "已经满血");
			return false;
		}
		health += (int) (5 * (1 + 0.1 * level)); // Revise
		if (health > rightClicked.getMaxHealth()) {
			health = rightClicked.getMaxHealth();
		}

		rightClicked.setHealth(health);
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass1Skill2(Player player, Player rightClicked, int level, Skilled plugin) {
		PlayerData data = new PlayerData(plugin);
		System.out.print("onClass1Skill2");
		int magic = data.getMagic(rightClicked);
		if (ConfigData.maxMagic <= magic) {
			player.sendMessage(Skilled.prefix + "法力值已满");
			return false;
		}
		magic += (int) (10 * (1 + 0.05 * level)); // Revise
		if (ConfigData.maxMagic <= magic) {
			magic = ConfigData.maxMagic;
		}
		data.setMagic(rightClicked, magic);
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass1Skill3(Player player, int level, Skilled skilled) {
		System.out.print("onClass1Skill3");
		return true;
	}

	public static boolean onClass1Skill4(Player player, int level, Skilled skilled) {
		System.out.print("onClass1Skill4");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		if (near.size() < 1) {
			player.sendMessage("周围无生物！");
			return false;
		}
		for (Entity entity : near) {
			if (entity.getLocation().distance(player.getLocation()) <= radius)
				if (entity instanceof LivingEntity) {

					double health = ((LivingEntity) entity).getHealth();
					if (((LivingEntity) entity).getMaxHealth() == health) {
						continue;
					}
					health += (int) (Math.random() * 7 * (1 + 0.05 * level)); // Revise
					if (health > ((LivingEntity) entity).getMaxHealth()) {
						health = ((LivingEntity) entity).getMaxHealth();
					}

					((LivingEntity) entity).setHealth(health);
				}
		}
		return true;
	}

}
