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

public class Class8 implements Listener {

	// ����

	// ����1��Ӱ�������ƶ��ٶȺ͹������Լ������ָ� //�������
	// ����2���ң������˺������ӵ�ȼ������ //�������
	// ����3������һ��ʱ���ڹ�������������ʧ�� //�������
	// ����4���У���Χ�˺������������͵��� //�������

	public static void onClass8Skill1(Player player, Skilled plugin) {
		System.out.print("onClass8Skill1");
	}

	public static void onClass8Skill2(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass8Skill2");
	}

	public static void onClass8Skill3(Player player, Skilled plugin) {
		System.out.print("onClass8Skill3");
	}

	public static void onClass8Skill4(Player player, Skilled plugin) {
		System.out.print("onClass8Skill4");
	}

}
