package cc.isotopestudio.Skilled.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import cc.isotopestudio.Skilled.Skilled;

public class Skill2 implements Listener {
	// 职业名字：圣谕

	private final Skilled plugin;

	public Skill2(Skilled instance) {
		plugin = instance;
	}

	// 技能1：治愈：恢复目标生命值
	// 技能2：活力：恢复目标魔法值
	// 技能3：神圣打击：召唤天雷攻击敌人
	// 技能4：生命源泉：群体恢复
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
	}

}
