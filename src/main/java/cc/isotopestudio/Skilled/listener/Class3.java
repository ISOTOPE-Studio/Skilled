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

public class Class3 implements Listener {

	// ӥ��
	// ����1�����裺���ƶ��ٶȺ���Ծ //�������
	// ����2��ħ����������ļ������������Ч�� //�������
	// ����3�����һ��ʱ�����ӹ����� //�������
	// ����4�����꣺�ӿ�������һƬ���� //�������

	public static boolean onClass3Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill1");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass3Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill2");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass3Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill3");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass3Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill4");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
