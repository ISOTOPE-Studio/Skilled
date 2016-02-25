package cc.isotopestudio.Skilled.gui;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.player.PlayerData;

public class SelectClass {

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
		}, plugin, true).setOption(0, new ItemStack(Material.NETHER_STAR, 1), "说明", "右边是可以选择的职业", "单击即可加入一个职业")
				.setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), "圣谕", "技能1：治愈：恢复目标生命值", "技能2：活力：恢复目标魔法值",
						"技能3：神圣打击：召唤天雷攻击敌人", "技能4：生命源泉：群体恢复")
				.setOption(2, new ItemStack(Material.HOPPER, 1), "暗影", "技能1：警惕：加移动速度和跳跃", "技能2：魔法箭：射出的箭附带随机负面效果",
						"技能3：轻语：一定时间增加攻击力", "技能4：箭雨：从空中落下一片箭雨")
				.setOption(3, new ItemStack(Material.IRON_FENCE, 1), "铁卫", "技能1：坚定不移：加抗性与血量", "技能2：怒吼：发出一个火球，伤害：50",
						"技能3：不屈：获得再生 II", "技能4：坚不可摧：三秒内无视伤害")
				.setOption(4, new ItemStack(Material.REDSTONE, 1), "血怒", "技能1：压制：攻击使目标虚弱", "技能2：狂化：自身被点燃，但攻击带生命偷取",
						"技能3：怒火：范围使敌人受到伤害且燃烧", "技能4：一夫当关：一定时间内攻击力大幅提升，获得再生效果")
				.setOption(5, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "未知职业", "????")
				.setOption(6, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "未知职业", "????")
				.setOption(7, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "未知职业", "????")
				.setOption(8, new ItemStack(Material.NETHER_STAR, 1), "说明", "左边是可以选择的职业", "单击即可加入一个职业");

		for (int job : list) {
			switch (job) {
			case (5): {
				menu.setOption(5, new ItemStack(Material.SOUL_SAND, 1), "引魂", "技能1：控魂：使敌人减速", "技能2：诱魂：造成单体伤害并使敌人进入负面效果",
						"技能3：破魂：造成范围击退并产生短暂的禁锢", "技能4：灭火：单体攻击，有较小几率秒杀敌人，失败则造成少量伤害");
			}
			case (6): {
				menu.setOption(6, new ItemStack(Material.DOUBLE_PLANT, 1), "光骑", "技能1：审判：造成单体伤害并点燃目标", "技能2：守护：范围增加抗性",
						"技能3：祈祷：生命吸收，伤害增加", "技能4：神临：无敌");
			}
			case (7): {
				menu.setOption(7, new ItemStack(Material.GOLD_HOE, 1), "猎刃", "技能1：影：增加移动速度和攻击力以及生命恢复",
						"技能2：烈：单体伤害，附加点燃和虚弱", "技能3：暗：一定时间内攻击附带虚弱和失明", "技能4：刃：范围伤害，附带虚弱和凋零");
			}
			}
		}
		menu.setClickList(list);
		return menu;
	}

}
