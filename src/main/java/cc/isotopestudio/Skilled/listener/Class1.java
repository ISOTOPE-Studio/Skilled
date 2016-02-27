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
	// 职业名字：圣谕

	private final Skilled plugin;

	public Class1(Skilled instance) {
		plugin = instance;
	}

	// 技能1：治愈：恢复目标生命值
	// 技能2：活力：恢复目标魔法值
	// 技能3：神圣打击：召唤天雷攻击敌人
	// 技能4：生命源泉：群体恢复
	@EventHandler
	public void onClass1Skill1(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		ItemStack item;
		String[] classAndSkill;
		String job, skill;
		LivingEntity rightClicked;
		try {
			rightClicked = (LivingEntity) event.getRightClicked();
			item = player.getItemInHand();
			classAndSkill = ItemUti.getLore(item);
			job = classAndSkill[0];
			skill = classAndSkill[1];
		} catch (Exception e) {
			return;
		}
		event.getPlayer().sendMessage(job + skill + Names.getSkillNum(skill));
		event.getPlayer().sendMessage(event.getEventName());
		if (!(job.equals(Names.getClassName(1)) && skill.equals(Names.getSkillName(job, 1)))) {
			return;
		}
		double health = rightClicked.getHealth();
		if (rightClicked.getMaxHealth() == health) {
			player.sendMessage(Skilled.prefix + "已经满血");
			return;
		}
		PlayerData data = new PlayerData(plugin);
		if (data.getMagic(player) < ConfigData.getRequiredMagic(job, Names.getSkillNum(skill))) {
			return;
		}
		health += 5;
		if (health > rightClicked.getMaxHealth()) {
			health = rightClicked.getMaxHealth();
		}
		rightClicked.setHealth(rightClicked.getHealth() + 5);
		player.sendMessage("成功释放！");
	}

}
