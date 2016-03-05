package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.ItemUti;
import cc.isotopestudio.Skilled.player.PlayerData;

public class Class4 implements Listener {

	//����
	//����1���ᶨ���ƣ��ӿ�����Ѫ�� //�������
	//����2��ŭ�𣺷���һ�������˺���50 //�������
	//����3��������������� II //�������
	//����4���᲻�ɴݣ������������˺� //�������
	
	public static boolean onClass4Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, ( 5+3*level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3*level) * 20, (int) (1+level*0.05))); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass4Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill2");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass4Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (15+3*level) * 20, 2)); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass4Skill4(Player player, int level, Skilled plugin) {// ��������趨�ǲ�����ģ���Ϊû�п�������
		System.out.print("onClass4Skill4");
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, ( 5+3*level) * 20, 100)); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
