package cc.isotopestudio.Skilled.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;

public class UpgradeSkill {

	public static ClassGUI createMenu(final Skilled plugin, Player player) {
		PlayerData data = new PlayerData(plugin);
		ConfigData config = new ConfigData(plugin);
		String job = data.getClass(player);
		String[] skillsName = new String[5];
		String[][] skillsDescription = new String[5][3];
		int[] skillsLevel = new int[5];
		for (int i = 1; i <= 4; i++) {
			skillsLevel[i] = data.getLevel(player, i);
			skillsName[i] = Names.getSkillName(job, i);
			if (skillsLevel[i] == 0) {
				skillsDescription[i][0] = "δ����";
				skillsDescription[i][1] = "�������輼�ܵ�" + config.getUnlockRequiredSkillPoint(job, i);
			} else {
				skillsDescription[i][0] = "��ǰ�ȼ�" + skillsLevel[i];
				skillsDescription[i][1] = "�������輼�ܵ�" + config.getUpdateRequiredSkillPoint(job, i);
			}
		}
		final ClassGUI menu = new ClassGUI("��������", 9, new ClassGUI.OptionClickEventHandler() {
			@Override
			public void onOptionClick(ClassGUI.OptionClickEvent event) {
				event.setWillClose(true);
				event.setWillDestroy(true);
				PlayerData data = new PlayerData(plugin);
				int skillPoint = data.getSkillPoint(event.getPlayer());
				ConfigData config = new ConfigData(plugin);
				String job = data.getClass(event.getPlayer());
				int skill = Names.getSkillNum(event.getName());
				int reqPoint = 0;
				if (skill == 0) {
					reqPoint = config.getUnlockRequiredSkillPoint(job, skill);
				} else {
					reqPoint = config.getUpdateRequiredSkillPoint(job, skill);
				}
				if (skillPoint >= reqPoint) {
					data.addLevel(event.getPlayer(), skill);
					data.removeSkillPoint(event.getPlayer(), reqPoint);
					plugin.savePlayersData();
					event.getPlayer().sendMessage("�ɹ�����!");
				}
			}
		}, plugin)
				.setOption(0, new ItemStack(Material.NETHER_STAR, 1), "�����������", "��ļ��ܵ���: " + data.getSkillPoint(player),
						"�������ɽ���������������")
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
