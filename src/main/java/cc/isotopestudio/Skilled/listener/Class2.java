package cc.isotopestudio.Skilled.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;

public class Class2 implements Listener {

	// ��Ӱ
	// ����1��Ӱ����˲�Ƶ����������һ�� //������
	// ����2��Ӱ�������� //�������
	// ����3����עһ����Ѫ�����٣����������� //�������
	// ����4��Ӱ�裺�Ӷ�ذ�ף�ʹ��Χ�����ܵ��˺������Ҹ����ж�Ч�� //�������

	public static boolean onClass2Skill1(Player player, Player rightClicked, int level, Skilled plugin) {
		System.out.print("onClass2Skill1");
		Location location = rightClicked.getLocation();
		return true;
	}

	public static boolean onClass2Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill2");
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (5+level)*20, 1, true)); // Revise

		player.sendMessage("�ɹ��ͷţ�" + ((5+level)*20));
		return true;
	}

	public static boolean onClass2Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill3");
		double health = player.getHealth() * 0.6;// Revise
		player.setHealth(health);
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5+level)*20, (int) (1 + level * 0.5))); // Revise

		player.sendMessage("�ɹ��ͷţ�" + ((5+level)*20) + (int) (1 + level * 0.5));
		return true;
	}

	public static boolean onClass2Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass2Skill4");
		double radius = 5D;
		List<Entity> near = player.getLocation().getWorld().getEntities();
		if (near.size() < 1) {
			player.sendMessage("��Χ�����");
			return false;
		}
		ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
		effects.add(new PotionEffect(PotionEffectType.HARM, 1 * 20, 5 + level)); // Revise
		effects.add(new PotionEffect(PotionEffectType.POISON, level * 15, (int) (1 + level * 0.5))); // Revise

		for (Entity entity : near) {
			if (entity.equals(player))
				continue;
			if (entity.getLocation().distance(player.getLocation()) <= radius)
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addPotionEffects(effects);
				}
		}
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
