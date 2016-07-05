package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class Class6 {

	// ����
	// ����1���ػ꣺ʹ���˼��� //�������
	// ����2���ջ꣺��ɵ����˺���ʹ���˽��븺��Ч�� //�������
	// ����3���ƻ꣺��ɷ�Χ���˲��������ݵĽ��� //�������
	// ����4����𣺵��幥�����н�С������ɱ���ˣ�ʧ������������˺� //�������

	public static boolean onClass6Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass6Skill1");
		player.sendMessage(Msg.release);
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

	public static boolean onClass6Skill2(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass6Skill2");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level, false)); // Revise
		double random = (Math.random() * 8);
		if (random == 0) {
			rightClicked
					.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.POISON, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked.addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW_DIGGING, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked
					.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, (5 + 3 * level) * 20, level, false)); // Revise
			rightClicked
					.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, (5 + 3 * level) * 20, level, false)); // Revise
		} else if (random <= 1)
			rightClicked
					.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, (5 + 3 * level) * 20, level, false)); // Revise
		else if (random <= 2)
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, (5 + 3 * level) * 20, level, false)); // Revise
		else if (random <= 3)
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.POISON, (5 + 3 * level) * 20, level, false)); // Revise
		else if (random <= 4)
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (5 + 3 * level) * 20, level, false)); // Revise
		else if (random <= 5)
			rightClicked.addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW_DIGGING, (5 + 3 * level) * 20, level, false)); // Revise
		else if (random <= 6)
			rightClicked
					.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
		else if (random <= 7)
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, (5 + 3 * level) * 20, level, false)); // Revise
		else
			rightClicked
					.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, (5 + 3 * level) * 20, level, false)); // Revise

		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
		return true;
	}

	public static boolean onClass6Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass6Skill3");
		return true;
	}

	public static boolean onClass6Skill4(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass6Skill4");
		double random = (Math.random() * 100);
		if (random <= 2 + level * 0.1)
			rightClicked.setHealth(0); // Revise
		else
			rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, 1 + level)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
		return true;
	}

}
