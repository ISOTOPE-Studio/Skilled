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

public class Class1 implements Listener {
	// ʥ��

	// ����1���������ָ�Ŀ������ֵ //�������
	// ����2���������ָ�Ŀ�귨��ֵ //������
	// ����3����ʥ������ٻ����׹������� //�������
	// ����4������ԴȪ��Ⱥ��ָ� //�������

	public static boolean onClass1Skill1(Player player, LivingEntity rightClicked, Skilled plugin) {
		System.out.print("onClass1Skill1");
		double health = rightClicked.getHealth();
		if (rightClicked.getMaxHealth() == health) {
			player.sendMessage(Skilled.prefix + "�Ѿ���Ѫ");
			return false;
		}
		health += 5; // Revise
		if (health > rightClicked.getMaxHealth()) {
			health = rightClicked.getMaxHealth();
		}

		rightClicked.setHealth(rightClicked.getHealth());
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass1Skill2(Player player, Player rightClicked, Skilled plugin) {
		PlayerData data = new PlayerData(plugin);
		System.out.print("onClass1Skill2");
		int magic = data.getMagic(rightClicked);
		if (ConfigData.maxMagic <= magic) {
			player.sendMessage(Skilled.prefix + "����ֵ����");
			return false;
		}
		magic += 10;
		if (ConfigData.maxMagic <= magic) {
			magic = ConfigData.maxMagic;
		}
		data.setMagic(rightClicked, magic);
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass1Skill3(Player player, Skilled skilled) {
		System.out.print("onClass1Skill3");
		return true;
	}

	public static boolean onClass1Skill4(Player player, Skilled skilled) {
		System.out.print("onClass1Skill4");
		return true;
	}

}
