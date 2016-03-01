package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.ItemUti;
import cc.isotopestudio.Skilled.player.PlayerData;

public class SkilledListener implements Listener {
	private final Skilled plugin;

	public SkilledListener(Skilled instance) {
		plugin = instance;
	}

	@EventHandler
	public void onRightClickEntity(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		ItemStack item;
		String[] classAndSkill;
		String job, skillString;
		int skill;
		LivingEntity rightClicked;
		try {
			rightClicked = (LivingEntity) event.getRightClicked();
			item = player.getItemInHand();
			classAndSkill = ItemUti.getLore(item);
			job = classAndSkill[0];
			skillString = classAndSkill[1];
			skill = Names.getSkillNum(skillString);
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
		switch (Names.getClassNum(job)) {
		case (1): {
			switch (skill) {
			case (1): {
				Class1.onClass1Skill1(player, rightClicked, plugin);
				return;
			}
			case (2): {
				if (rightClicked instanceof Player) {
					Class1.onClass1Skill2(player, (Player) rightClicked, plugin);
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
					Class2.onClass2Skill1(player, (Player) rightClicked, plugin);
					return;
				}
			}
			}
			return;
		}
		case (5): {
			switch (skill) {
			case (1): {
				Class5.onClass5Skill1(player, rightClicked, plugin);
				return;
			}
			}
			return;
		}
		case (6): {
			switch (skill) {
			case (1): {
				Class6.onClass6Skill1(player, rightClicked, plugin);
				return;
			}
			case (3): {
				Class6.onClass6Skill2(player, rightClicked, plugin);

				return;
			}
			case (4): {
				Class6.onClass6Skill4(player, rightClicked, plugin);
				return;
			}
			}
			return;
		}
		case (7): {
			switch (skill) {
			case (1): {
				Class7.onClass7Skill1(player, rightClicked, plugin);
				return;
			}
			}
			return;
		}
		case (8): {
			switch (skill) {
			case (2): {
				Class8.onClass8Skill2(player, rightClicked, plugin);
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
		int skill;
		try {
			item = player.getItemInHand();
			classAndSkill = ItemUti.getLore(item);
			job = classAndSkill[0];
			skillString = classAndSkill[1];
			skill = Names.getSkillNum(skillString);
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
		switch (Names.getClassNum(job)) {
		case (1): {
			switch (skill) {
			case (3): {
				Class1.onClass1Skill3(player, plugin);
				return;
			}
			case (4): {
				Class1.onClass1Skill4(player, plugin);
				return;
			}
			}
			return;
		}
		case (2): {
			switch (skill) {
			case (2): {
				Class2.onClass2Skill2(player, plugin);
				return;
			}
			case (3): {
				Class2.onClass2Skill3(player, plugin);
				return;
			}
			case (4): {
				Class2.onClass2Skill4(player, plugin);
				return;
			}
			}
			return;
		}
		case (3): {
			switch (skill) {
			case (1): {
				Class3.onClass3Skill1(player, plugin);
				return;
			}
			case (2): {
				Class3.onClass3Skill2(player, plugin);
				return;
			}
			case (3): {
				Class3.onClass3Skill3(player, plugin);
				return;
			}
			case (4): {
				Class3.onClass3Skill4(player, plugin);
				return;
			}
			}
			return;
		}
		case (4): {
			switch (skill) {
			case (1): {
				Class4.onClass4Skill1(player, plugin);
				return;
			}
			case (2): {
				Class4.onClass4Skill2(player, plugin);
				return;
			}
			case (3): {
				Class4.onClass4Skill3(player, plugin);
				return;
			}
			case (4): {
				Class4.onClass4Skill4(player, plugin);
				return;
			}
			}
			return;
		}
		case (5): {
			switch (skill) {
			case (2): {
				Class5.onClass5Skill2(player, plugin);
				return;
			}
			case (3): {
				Class5.onClass5Skill3(player, plugin);
				return;
			}
			case (4): {
				Class5.onClass5Skill4(player, plugin);
				return;
			}
			}
			return;
		}
		case (6): {
			switch (skill) {
			case (3): {
				Class6.onClass6Skill3(player, plugin);
				return;
			}
			}
			return;
		}
		case (7): {
			switch (skill) {
			case (2): {
				Class7.onClass7Skill2(player, plugin);
				return;
			}
			case (3): {
				Class7.onClass7Skill3(player, plugin);
				return;
			}
			case (4): {
				Class7.onClass7Skill4(player, plugin);
				return;
			}
			}
			return;
		}
		case (8): {
			switch (skill) {
			case (1): {
				Class8.onClass8Skill1(player, plugin);
				return;
			}
			case (3): {
				Class8.onClass8Skill3(player, plugin);
				return;
			}
			case (4): {
				Class8.onClass8Skill4(player, plugin);
				return;
			}
			}
		}
			return;
		}
	}
}