package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class Class5 {

	// Ѫŭ
	// ����1��ѹ�ƣ�����ʹĿ������ //�������
	// ����2���񻯣�������ȼ��������������͵ȡ //�������
	// ����3��ŭ�𣺷�Χʹ�����ܵ��˺���ȼ�� //�������
	// ����4��һ�򵱹أ�һ��ʱ���ڹ���������������������Ч�� //�������

	public static boolean onClass5Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
		System.out.print("onClass5Skill1");
		rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass5Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass5Skill2");
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass5Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass5Skill3");
		player.sendMessage(Msg.release);
		return true;
	}

	public static boolean onClass5Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass5Skill4");
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		player.sendMessage(Msg.release);
		return true;
	}

}
