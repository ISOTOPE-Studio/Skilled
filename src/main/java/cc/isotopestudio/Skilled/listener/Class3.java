package cc.isotopestudio.Skilled.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cc.isotopestudio.Skilled.Skilled;

public class Class3 implements Listener {

	// ӥ��
	// ����1�����裺���ƶ��ٶȺ���Ծ //�������
	// ����2��ħ����������ļ������������Ч�� //�������
	// ����3��������ӹ����� //�������
	// ����4�����꣺�ӿ�������һƬ���� //�������

	public static boolean onClass3Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (5 + level) * 20, (int) (1 + level * 0.5))); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + level) * 20, (int) (1 + level * 0.5))); // Revise
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
		player.addPotionEffect(
				new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (7 + level) * 20, (int) (1.5 + level * 0.5))); // Revise
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

	public static boolean onClass3Skill4(Player player, int level, Skilled plugin) {
		System.out.print("onClass3Skill4");
		player.sendMessage("�ɹ��ͷţ�");
		return true;
	}

}
