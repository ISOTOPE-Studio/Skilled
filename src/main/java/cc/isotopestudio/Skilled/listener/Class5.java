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

public class Class5 implements Listener {

	// Ѫŭ
	//����1��ѹ�ƣ�����ʹĿ������ //�������
	//����2���񻯣�������ȼ��������������͵ȡ //�������
	//����3��ŭ�𣺷�Χʹ�����ܵ��˺���ȼ�� //�������
	//����4��һ�򵱹أ�һ��ʱ���ڹ���������������������Ч�� //�������
	
	public static boolean onClass5Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass5Skill1");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, ( 5+3*level) * 20, level)); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass5Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass5Skill2");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass5Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass5Skill3");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass5Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass5Skill4");
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3*level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3*level) * 20, level)); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
