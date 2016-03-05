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

public class Class8 implements Listener {

	// ����

	// ����1��Ӱ�������ƶ��ٶȺ͹������Լ������ָ� //�������
	// ����2���ң������˺������ӵ�ȼ������ //�������
	// ����3������һ��ʱ���ڹ�������������ʧ�� //�������
	// ����4���У���Χ�˺������������͵��� //�������

	public static boolean onClass8Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level)); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass8Skill2(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass8Skill2");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level)); // Revise
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level)); // Revise
		rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass8Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill3");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass8Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass8Skill4");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		if (near.size() < 1) {
			player.sendMessage("��Χ�����");
			return false;
		}
		for (Entity entity : near) {
			if (entity.getLocation().distance(player.getLocation()) <= radius) {
				if (entity.equals(player))
					continue;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffect(
							new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, (int) (1 + level * 0.05)));
					((LivingEntity) entity).addPotionEffect(
							new PotionEffect(PotionEffectType.WITHER, (5 + 3 * level) * 20, (int) (1 + level * 0.05)));
					((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
							(5 + 3 * level) * 20, (int) (1 + level * 0.05)));

				}
			}
		}
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
