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

public class Class7 implements Listener {

	// ����

	//����1�����У���ɵ����˺�����ȼĿ�� //�������
	//����2���ػ�����Χ���ӿ��� //�������
	//����3�������������գ��˺����� //�������
	//����4�����٣��޵� //�������
	
	public static boolean onClass7Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass7Skill1");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass7Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill2");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass7Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill3");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass7Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill4");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
