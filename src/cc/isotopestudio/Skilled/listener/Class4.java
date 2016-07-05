package cc.isotopestudio.Skilled.listener;

import org.bukkit.Location;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.utli.ParticleEffect;

public class Class4 implements Listener {

	// ����
	// ����1���ᶨ���ƣ��ӿ�����Ѫ�� //�������
	// ����2��ŭ�𣺷���һ�������˺���50 //�������
	// ����3��������������� II //�������
	// ����4���᲻�ɴݣ������������˺� //�������

	public static boolean onClass4Skill1(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill1");
		player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, (5 + 3 * level) * 20, level, false)); // Revise
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20,
				(int) (1 + level * 0.05), false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

	public static boolean onClass4Skill2(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill2");
		Vector v = player.getLocation().getDirection().normalize();
		Fireball fb = ((ProjectileSource) player).launchProjectile(Fireball.class, v);
		((Explosive) fb).setYield(0);
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

	@EventHandler
	public void fileball(ProjectileHitEvent event) {
		if (event.getEntity() instanceof Fireball) {
			Location loc = event.getEntity().getLocation();
			event.getEntity().getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 10F, false, false);
		}
	}

	public static boolean onClass4Skill3(Player player, int level, Skilled plugin) {
		System.out.print("onClass4Skill3");
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (15 + 3 * level) * 20, 2, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

	public static boolean onClass4Skill4(Player player, int level, Skilled plugin) {// ��������趨�ǲ�����ģ���Ϊû�п�������
		System.out.print("onClass4Skill4");
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20, 100, false)); // Revise
		ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
		return true;
	}

}
