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

class Class7 {

    // ����

    // ����1�����У���ɵ����˺�����ȼĿ�� //�������
    // ����2���ػ�����Χ���ӿ��� //�������
    // ����3�������������գ��˺����� //�������
    // ����4�����٣��޵� //�������

    static boolean onClass7Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        System.out.print("onClass7Skill1");
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level, false)); // Revise
        rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

    static boolean onClass7Skill2(Player player, int level, Skilled plugin) {
        System.out.print("onClass7Skill2");
        double radius = 5D;
        List<Entity> near = player.getLocation().getWorld().getEntities();
        int count = 0;
        for (Entity entity : near) {
            if (entity.getLocation().distance(player.getLocation()) <= radius)
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                            (5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                    ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, entity.getLocation(), 20);
                    count++;
                }
        }
        if (count <= 1) {
            player.sendMessage(Msg.noLife);
            return false;
        }
        return true;
    }

    static boolean onClass7Skill3(Player player, int level, Skilled plugin) {
        System.out.print("onClass7Skill3");
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

    public static boolean onClass7Skill4(Player player, int level, Skilled plugin) {
        System.out.print("onClass7Skill4");
        return true;
    }

}
