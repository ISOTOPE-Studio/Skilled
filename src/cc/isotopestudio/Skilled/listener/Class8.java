package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

class Class8 {

    // ����

    // ����1��Ӱ�������ƶ��ٶȺ͹������Լ������ָ� //�������
    // ����2���ң������˺������ӵ�ȼ������ //�������
    // ����3������һ��ʱ���ڹ�������������ʧ�� //�������
    // ����4���У���Χ�˺������������͵��� //�������

    public static boolean onClass8Skill1(Player player, int level, Skilled plugin) {
        System.out.print("onClass8Skill1");
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level, false)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

    public static boolean onClass8Skill2(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        System.out.print("onClass8Skill2");
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level, false)); // Revise
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
        rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

    public static boolean onClass8Skill3(Player player, int level, Skilled plugin) {
        System.out.print("onClass8Skill3");
        return true;
    }

    public static boolean onClass8Skill4(Player player, int level, Skilled plugin) {
        System.out.print("onClass8Skill4");
        double radius = 5D;
        List<Entity> near = player.getLocation().getWorld().getEntities();
        int count = 0;
        for (Entity entity : near) {
            if (entity.getLocation().distance(player.getLocation()) <= radius) {
                if (entity.equals(player))
                    continue;
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.HARM,
                            (5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
                            (5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
                            (5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                    ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, entity.getLocation(), 20);
                    count++;
                }
            }
        }
        if (count == 0) {
            player.sendMessage(Msg.noLife);
            return false;
        }
        return true;
    }

}
