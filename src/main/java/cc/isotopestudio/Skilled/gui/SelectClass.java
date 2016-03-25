package cc.isotopestudio.Skilled.gui;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;

public class SelectClass {

	static String unknownJob = new StringBuilder().append(ChatColor.BLUE).append(ChatColor.ITALIC).append("未知职业")
			.toString();
	static String questionMark = new StringBuilder().append(ChatColor.BLACK).append(ChatColor.ITALIC).append("????")
			.toString();
	static String[] intro = { new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("说明").toString(),
			new StringBuilder().append(ChatColor.GREEN).append(ChatColor.ITALIC).append("这里是可以选择的职业").toString(),
			new StringBuilder().append(ChatColor.AQUA).append(ChatColor.ITALIC).append("单击即可加入一个职业").toString() };
	static String skill = new StringBuilder().append(ChatColor.AQUA).append(ChatColor.ITALIC).append("技能: ").toString();

	public static ClassGUI createMenu(final Skilled plugin, ArrayList<Integer> list) {
		ClassGUI menu = new ClassGUI("职业选择", 9, new ClassGUI.OptionClickEventHandler() {
			@Override
			public void onOptionClick(ClassGUI.OptionClickEvent event) {
				event.setWillClose(true);
				event.getPlayer().sendMessage("你选择了" + event.getName());

				PlayerData data = new PlayerData(plugin);
				data.setClass(event.getPlayer(), event.getName());
				data.setLevel(event.getPlayer(), 1, 0);
				data.setLevel(event.getPlayer(), 2, 0);
				data.setLevel(event.getPlayer(), 3, 0);
				data.setLevel(event.getPlayer(), 4, 0);
				data.setMagic(event.getPlayer(), 200);
				data.setSkillPoint(event.getPlayer(), 10);
				plugin.savePlayersData();
			}
		}, plugin, true)

				.setOption(0, new ItemStack(Material.NETHER_STAR, 1), intro[0], intro[1], intro[2])
				.setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), Names.getClassName(1), skill,
						Names.getSkillColorInfo(1, 1), Names.getSkillColorInfo(1, 2), Names.getSkillColorInfo(1, 3),
						Names.getSkillColorInfo(1, 4))
				.setOption(2, new ItemStack(Material.HOPPER, 1), Names.getClassName(2), skill,
						Names.getSkillColorInfo(2, 1), Names.getSkillColorInfo(2, 2), Names.getSkillColorInfo(2, 3),
						Names.getSkillColorInfo(2, 4))
				.setOption(3, new ItemStack(Material.IRON_FENCE, 1), Names.getClassName(3), skill,
						Names.getSkillColorInfo(3, 1), Names.getSkillColorInfo(3, 2), Names.getSkillColorInfo(3, 3),
						Names.getSkillColorInfo(3, 4))
				.setOption(4, new ItemStack(Material.REDSTONE, 1), Names.getClassName(4), skill,
						Names.getSkillColorInfo(4, 1), Names.getSkillColorInfo(4, 2), Names.getSkillColorInfo(4, 3),
						Names.getSkillColorInfo(4, 4))
				.setOption(5, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), unknownJob, questionMark)
				.setOption(6, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), unknownJob, questionMark)
				.setOption(7, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), unknownJob, questionMark)
				.setOption(8, new ItemStack(Material.NETHER_STAR, 1), intro[0], intro[1], intro[2]);
		for (int job : list) {
			switch (job) {
			case (5): {
				menu.setOption(5, new ItemStack(Material.SOUL_SAND, 1), Names.getClassName(5), skill,
						Names.getSkillColorInfo(5, 1), Names.getSkillColorInfo(5, 2), Names.getSkillColorInfo(5, 3),
						Names.getSkillColorInfo(5, 4));
				break;
			}
			case (6): {
				menu.setOption(6, new ItemStack(Material.DOUBLE_PLANT, 1), Names.getClassName(6), skill,
						Names.getSkillColorInfo(6, 1), Names.getSkillColorInfo(6, 2), Names.getSkillColorInfo(6, 3),
						Names.getSkillColorInfo(6, 4));
				break;
			}
			case (7): {
				menu.setOption(7, new ItemStack(Material.GOLD_HOE, 1), Names.getClassName(7), skill,
						Names.getSkillColorInfo(7, 1), Names.getSkillColorInfo(7, 2), Names.getSkillColorInfo(7, 3),
						Names.getSkillColorInfo(7, 4));
				break;
			}
			}
		}
		menu.setClickList(list);
		return menu;
	}

}
