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

public class Class2 implements Listener {

	// ��Ӱ
	// ����1��Ӱ����˲�Ƶ����������һ�� //������
	// ����2��Ӱ�������� //�������
	// ����3����עһ����Ѫ�����٣����������� //�������
	// ����4��Ӱ�裺�Ӷ�ذ�ף�ʹ��Χ�����ܵ��˺������Ҹ����ж�Ч�� //�������

	public static boolean onClass2Skill1(Player player, Player rightClicked, int level, Skilled plugin) {
		System.out.print("onClass2Skill1");
		return true;
	}

	public static boolean onClass2Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill2");
		return true;
	}

	public static boolean onClass2Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill3");
		return true;
	}

	public static boolean onClass2Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill4");
		return true;
	}

}
