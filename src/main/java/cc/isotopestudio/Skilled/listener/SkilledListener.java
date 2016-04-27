package cc.isotopestudio.Skilled.listener;

import java.util.Date;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.ItemUti;
import cc.isotopestudio.Skilled.player.PlayerData;

public class SkilledListener implements Listener {
	private final Skilled plugin;
	private final PlayerData data;
	private final HashMap<String, Long> cooldownMap;

	public SkilledListener(Skilled instance) {
		plugin = instance;
		data = new PlayerData(plugin);
		cooldownMap = new HashMap<String, Long>();
	}

	@EventHandler
	public void onRightClickEntity(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		ItemStack item;
		String[] classAndSkill;
		String job, skillString;
		int skill, level;
		LivingEntity rightClicked;
		try {
			rightClicked = (LivingEntity) event.getRightClicked();
			item = player.getItemInHand();
			classAndSkill = ItemUti.getLore(item);
			job = classAndSkill[0];
			skillString = classAndSkill[1];
			skill = Names.getSkillNum(skillString);
			level = data.getLevel(player, skill);
		} catch (Exception e) {
			return;
		}
		if (job == null || skillString == null)
			return;
		if (!(data.ifHasClass(player, job))) {
			// player.sendMessage(Msg.noClass);
			return;
		}
		if (!(data.ifHasSkill(player, skill))) {
			// player.sendMessage(Msg.noSkill);
			return;
		}
		if (data.getMagic(player) < ConfigData.getRequiredMagic(Names.getClassName(1), 1)) {
			// player.sendMessage(Msg.noMagic);
			return;
		}
		if (data.isCooldown(player, skill)) {
			// player.sendMessage(Msg.cooldown);
			return;
		}
		switch (Names.getClassNum(job)) {
		case (1): {
			switch (skill) {
			case (1): {
				if (Class1.onClass1Skill1(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (2): {
				if (rightClicked instanceof Player) {
					if (Class1.onClass1Skill2(player, (Player) rightClicked, level, plugin))
						afterRelease(player, job, skill, plugin);
				}
				return;
			}
			}
			return;
		}
		case (2): {
			switch (skill) {
			case (1): {
				if (rightClicked instanceof Player) {
					if (Class2.onClass2Skill1(player, (Player) rightClicked, level, plugin))
						afterRelease(player, job, skill, plugin);
					return;
				}
			}
			}
			return;
		}
		case (5): {
			switch (skill) {
			case (1): {
				if (Class5.onClass5Skill1(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (6): {
			switch (skill) {
			case (1): {
				if (Class6.onClass6Skill1(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class6.onClass6Skill2(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class6.onClass6Skill4(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (7): {
			switch (skill) {
			case (1): {
				if (Class7.onClass7Skill1(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (8): {
			switch (skill) {
			case (2): {
				if (Class8.onClass8Skill2(player, rightClicked, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
		}
			return;
		}
	}

	@EventHandler
	public void onRightClickItem(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item;
		String[] classAndSkill;
		String job, skillString;
		int skill, level;
		System.out.println(event.getAction());
		try {
			item = player.getItemInHand();
			classAndSkill = ItemUti.getLore(item);
			job = classAndSkill[0];
			skillString = classAndSkill[1];
			skill = Names.getSkillNum(skillString);
			level = data.getLevel(player, skill);
		} catch (Exception e) {
			return;
		}
		if (job == null || skillString == null)
			return;
		PlayerData data = new PlayerData(plugin);
		if (!(data.ifHasClass(player, job))) {
			player.sendMessage(Msg.noClass);
			return;
		}
		if (!(data.ifHasSkill(player, skill))) {
			player.sendMessage(Msg.noSkill);
			return;
		}
		if (data.getMagic(player) < ConfigData.getRequiredMagic(Names.getClassName(1), 1)) {
			player.sendMessage(Msg.noMagic);
			return;
		}
		if (data.isCooldown(player, skill)) {
			player.sendMessage(Msg.cooldown
					+ ((cooldownMap.get(player.getName() + job + skill) - new Date().getTime()) / 1000.0) + "秒");
			return;
		}
		switch (Names.getClassNum(job)) {
		case (1): {
			switch (skill) {
			case (3): {
				if (Class1.onClass1Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class1.onClass1Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (2): {
			switch (skill) {
			case (2): {
				if (Class2.onClass2Skill2(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class2.onClass2Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class2.onClass2Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (3): {
			switch (skill) {
			case (1): {
				if (Class3.onClass3Skill1(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (2): {
				if (Class3.onClass3Skill2(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class3.onClass3Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class3.onClass3Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (4): {
			switch (skill) {
			case (1): {
				if (Class4.onClass4Skill1(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (2): {
				if (Class4.onClass4Skill2(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class4.onClass4Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class4.onClass4Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (5): {
			switch (skill) {
			case (2): {
				if (Class5.onClass5Skill2(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class5.onClass5Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class5.onClass5Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (6): {
			switch (skill) {
			case (3): {
				if (Class6.onClass6Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (7): {
			switch (skill) {
			case (2): {
				if (Class7.onClass7Skill2(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class7.onClass7Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class7.onClass7Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
			return;
		}
		case (8): {
			switch (skill) {
			case (1): {
				if (Class8.onClass8Skill1(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (3): {
				if (Class8.onClass8Skill3(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			case (4): {
				if (Class8.onClass8Skill4(player, level, plugin))
					afterRelease(player, job, skill, plugin);
				return;
			}
			}
		}
			return;
		}
	}

	private void afterRelease(final Player player, final String job, final int skill, Skilled plugin) {
		int magic = ConfigData.getRequiredMagic(job, skill);
		data.decreaseMagic(player, magic);
		data.setCooldown(player, skill, true);
		int cooldownTime = ConfigData.getCooldown(job, skill);
		final String playerName = player.getName();
		cooldownMap.put(playerName + job + skill, new Date().getTime() + cooldownTime * 1000);
		new BukkitRunnable() {
			@Override
			public void run() {
				data.setCooldown(player, skill, false);
				cooldownMap.remove(playerName + job + skill);
			}
		}.runTaskLater(this.plugin, 20 * cooldownTime);
		player.sendMessage(new StringBuilder(Msg.release + Names.getSkillColorName(job, skill)).append(ChatColor.GOLD)
				.append(", 消耗法力值" + magic).toString());
	}

}