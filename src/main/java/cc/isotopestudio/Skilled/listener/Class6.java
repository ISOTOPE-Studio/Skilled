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

public class Class6 implements Listener {

	// ����
	// ����1���ػ꣺ʹ���˼��� //�������
	// ����2���ջ꣺��ɵ����˺���ʹ���˽��븺��Ч�� //�������
	// ����3���ƻ꣺��ɷ�Χ���˲��������ݵĽ��� //�������
	// ����4����𣺵��幥�����н�С������ɱ���ˣ�ʧ������������˺� //�������

	public static boolean onClass6Skill1(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass6Skill1");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass6Skill2(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass6Skill2");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass6Skill3(Player player, Skilled plugin) {
		System.out.print("onClass6Skill3");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass6Skill4(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass6Skill4");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
