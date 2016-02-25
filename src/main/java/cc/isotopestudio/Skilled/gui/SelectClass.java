package cc.isotopestudio.Skilled.gui;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.player.PlayerData;

public class SelectClass {

	public static ClassGUI createMenu(final Skilled plugin, ArrayList<Integer> list) {
		ClassGUI menu = new ClassGUI("ְҵѡ��", 9, new ClassGUI.OptionClickEventHandler() {
			@Override
			public void onOptionClick(ClassGUI.OptionClickEvent event) {
				event.setWillClose(true);
				event.getPlayer().sendMessage("��ѡ����" + event.getName());

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
		}, plugin, true).setOption(0, new ItemStack(Material.NETHER_STAR, 1), "˵��", "�ұ��ǿ���ѡ���ְҵ", "�������ɼ���һ��ְҵ")
				.setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), "ʥ��", "����1���������ָ�Ŀ������ֵ", "����2���������ָ�Ŀ��ħ��ֵ",
						"����3����ʥ������ٻ����׹�������", "����4������ԴȪ��Ⱥ��ָ�")
				.setOption(2, new ItemStack(Material.HOPPER, 1), "��Ӱ", "����1�����裺���ƶ��ٶȺ���Ծ", "����2��ħ����������ļ������������Ч��",
						"����3�����һ��ʱ�����ӹ�����", "����4�����꣺�ӿ�������һƬ����")
				.setOption(3, new ItemStack(Material.IRON_FENCE, 1), "����", "����1���ᶨ���ƣ��ӿ�����Ѫ��", "����2��ŭ�𣺷���һ�������˺���50",
						"����3��������������� II", "����4���᲻�ɴݣ������������˺�")
				.setOption(4, new ItemStack(Material.REDSTONE, 1), "Ѫŭ", "����1��ѹ�ƣ�����ʹĿ������", "����2���񻯣�������ȼ��������������͵ȡ",
						"����3��ŭ�𣺷�Χʹ�����ܵ��˺���ȼ��", "����4��һ�򵱹أ�һ��ʱ���ڹ���������������������Ч��")
				.setOption(5, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "δְ֪ҵ", "????")
				.setOption(6, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "δְ֪ҵ", "????")
				.setOption(7, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "δְ֪ҵ", "????")
				.setOption(8, new ItemStack(Material.NETHER_STAR, 1), "˵��", "����ǿ���ѡ���ְҵ", "�������ɼ���һ��ְҵ");

		for (int job : list) {
			switch (job) {
			case (5): {
				menu.setOption(5, new ItemStack(Material.SOUL_SAND, 1), "����", "����1���ػ꣺ʹ���˼���", "����2���ջ꣺��ɵ����˺���ʹ���˽��븺��Ч��",
						"����3���ƻ꣺��ɷ�Χ���˲��������ݵĽ���", "����4����𣺵��幥�����н�С������ɱ���ˣ�ʧ������������˺�");
			}
			case (6): {
				menu.setOption(6, new ItemStack(Material.DOUBLE_PLANT, 1), "����", "����1�����У���ɵ����˺�����ȼĿ��", "����2���ػ�����Χ���ӿ���",
						"����3�������������գ��˺�����", "����4�����٣��޵�");
			}
			case (7): {
				menu.setOption(7, new ItemStack(Material.GOLD_HOE, 1), "����", "����1��Ӱ�������ƶ��ٶȺ͹������Լ������ָ�",
						"����2���ң������˺������ӵ�ȼ������", "����3������һ��ʱ���ڹ�������������ʧ��", "����4���У���Χ�˺������������͵���");
			}
			}
		}
		menu.setClickList(list);
		return menu;
	}

}
