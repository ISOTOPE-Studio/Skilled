package cc.isotopestudio.Skilled.listener;

import java.util.List;

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

public class Class7 implements Listener {

	// ����

	// ����1�����У���ɵ����˺�����ȼĿ�� //�������
	// ����2���ػ�����Χ���ӿ��� //�������
	// ����3�������������գ��˺����� //�������
	// ����4�����٣��޵� //�������

	public static boolean onClass7Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass7Skill1");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level)); // Revise
		rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass7Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill2");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		if (near.size() < 1) {
			player.sendMessage("��Χ�����");
			return false;
		}
		for (Entity entity : near) {
			if (entity.getLocation().distance(player.getLocation()) <= radius)
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20, (int) (1+level*0.05)));
				}
		}
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass7Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, (5 + 3 * level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level)); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass7Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass7Skill4");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
