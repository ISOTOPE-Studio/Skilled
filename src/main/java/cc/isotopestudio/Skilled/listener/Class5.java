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

public class Class5 implements Listener {

	// Ѫŭ
	//����1��ѹ�ƣ�����ʹĿ������ //�������
	//����2���񻯣�������ȼ��������������͵ȡ //�������
	//����3��ŭ�𣺷�Χʹ�����ܵ��˺���ȼ�� //�������
	//����4��һ�򵱹أ�һ��ʱ���ڹ���������������������Ч�� //�������
	
	public static void onClass5Skill1(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass5Skill1");
	}

	public static void onClass5Skill2(Player player, Skilled plugin) {
		System.out.print("onClass5Skill2");
	}

	public static void onClass5Skill3(Player player, Skilled plugin) {
		System.out.print("onClass5Skill3");
	}

	public static void onClass5Skill4(Player player, Skilled plugin) {
		System.out.print("onClass5Skill4");
	}

}
