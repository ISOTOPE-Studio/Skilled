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

public class Class3 implements Listener {

	// 鹰眼
	// 技能1：警惕：加移动速度和跳跃 //点击空气
	// 技能2：魔法箭：射出的箭附带随机负面效果 //点击空气
	// 技能3：轻语：一定时间增加攻击力 //点击空气
	// 技能4：箭雨：从空中落下一片箭雨 //点击空气

	public static boolean onClass3Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill1");
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
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass3Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill4");
		player.sendMessage("成功释放！");
		return true;
	}

}
