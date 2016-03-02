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

public class Class5 implements Listener {

	// 血怒
	//技能1：压制：攻击使目标虚弱 //点击生物
	//技能2：狂化：自身被点燃，但攻击带生命偷取 //点击空气
	//技能3：怒火：范围使敌人受到伤害且燃烧 //点击空气
	//技能4：一夫当关：一定时间内攻击力大幅提升，获得再生效果 //点击空气
	
	public static boolean onClass5Skill1(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass5Skill1");
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass5Skill2(Player player, Skilled plugin) {
		System.out.print("onClass5Skill2");
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass5Skill3(Player player, Skilled plugin) {
		System.out.print("onClass5Skill3");
		player.sendMessage("成功释放！");
		return true;
	}

	public static boolean onClass5Skill4(Player player, Skilled plugin) {
		System.out.print("onClass5Skill4");
		player.sendMessage("成功释放！");
		return true;
	}

}
