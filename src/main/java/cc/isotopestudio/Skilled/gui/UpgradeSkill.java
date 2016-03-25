package cc.isotopestudio.Skilled.gui;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;

public class UpgradeSkill {

	static final String title = new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("技能升级")
			.toString();

	static final String unlock = new StringBuilder().append(ChatColor.BLUE).append(ChatColor.ITALIC).append("未解锁")
			.toString();
	static final String unlockRequire = new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC)
			.append("解锁所需技能点: ").toString();
	static final String upgrade = new StringBuilder().append(ChatColor.BLUE).append(ChatColor.ITALIC).append("当前等级")
			.toString();
	static final String upgradeRequire = new StringBuilder().append(ChatColor.GREEN).append(ChatColor.ITALIC)
			.append("升级所需技能点: ").toString();

	public static ClassGUI createMenu(final Skilled plugin, Player player) {
		PlayerData data = new PlayerData(plugin);
		String job = data.getClass(player);
		String[] skillsName = new String[5];
		String[][] skillsDescription = new String[5][3];
		int[] skillsLevel = new int[5];
		for (int i = 1; i <= 4; i++) {
			skillsLevel[i] = data.getLevel(player, i);
			skillsName[i] = Names.getSkillName(job, i);
			if (skillsLevel[i] == 0) {
				skillsDescription[i][0] = unlock;
				skillsDescription[i][1] = unlockRequire + ConfigData.getUnlockRequiredSkillPoint(job, i);
			} else {
				skillsDescription[i][0] = upgrade + skillsLevel[i];
				skillsDescription[i][1] = upgradeRequire + ConfigData.getUpgradeRequiredSkillPoint(job, i);
			}
		}
		final ClassGUI menu = new ClassGUI(title, 9, new ClassGUI.OptionClickEventHandler() {
			@Override
			public void onOptionClick(ClassGUI.OptionClickEvent event) {
				event.setWillClose(true);
				event.setWillDestroy(true);
				PlayerData data = new PlayerData(plugin);
				int skillPoint = data.getSkillPoint(event.getPlayer());
				String job = data.getClass(event.getPlayer());
				int skill = Names.getSkillNum(event.getName());
				int reqPoint = 0;
				if (skill == 0) {
					reqPoint = ConfigData.getUnlockRequiredSkillPoint(job, skill);
				} else {
					reqPoint = ConfigData.getUpgradeRequiredSkillPoint(job, skill);
				}
				if (skillPoint >= reqPoint) {
					data.addLevel(event.getPlayer(), skill);
					data.addSkillPoint(event.getPlayer(), -reqPoint);
					plugin.savePlayersData();
					event.getPlayer().sendMessage("成功升级!");
				} else {
					event.getPlayer().sendMessage("技能点不足!");
				}
			}
		}, plugin, true)
				.setOption(0, new ItemStack(Material.NETHER_STAR, 1), "升级或解锁！", "你的技能点数: " + data.getSkillPoint(player),
						"单击即可解锁或者升级技能")
				.setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[1], skillsDescription[1][0],
						skillsDescription[1][1])
				.setOption(2, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[2], skillsDescription[2][0],
						skillsDescription[2][1])
				.setOption(3, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[3], skillsDescription[3][0],
						skillsDescription[3][1])
				.setOption(4, new ItemStack(Material.GLOWSTONE_DUST, 1), skillsName[4], skillsDescription[4][0],
						skillsDescription[4][1]);
		return menu;
	}

}
