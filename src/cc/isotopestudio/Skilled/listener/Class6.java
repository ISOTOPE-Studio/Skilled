/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import cc.isotopestudio.Skilled.utli.PotionEffectUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

import static cc.isotopestudio.Skilled.Skilled.plugin;

class Class6 {

    // ����
    // ����1���ػ꣺ʹ���˼��� //�������
    // ����2���ջ꣺��ɵ����˺���ʹ���˽��븺��Ч�� //�������
    // ����3���ƻ꣺��ɷ�Χ���˲��������ݵĽ��� //�������
    // ����4����𣺵��幥�����н�С������ɱ���ˣ�ʧ������������˺� //�������

    static boolean onClass6Skill1(Player player, LivingEntity rightClicked, int level) {
        plugin.getLogger().info("onClass6Skill1");
        player.sendMessage(Msg.release);
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (5 + 3 * level) * 20, level, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass6Skill2(Player player, LivingEntity rightClicked, int level) {
        plugin.getLogger().info("onClass6Skill2");
        rightClicked.damage(level, player); // Revise
        rightClicked.addPotionEffect(PotionEffectUtil.getRandomNegativeEffect(level)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass6Skill3(Player player, int level) {
        plugin.getLogger().info("onClass6Skill3");
        final double range = 5 + level * 2; // Reivse
        List<Entity> nearby = player.getNearbyEntities(range, range, range);
        for (Entity entity : nearby) {
            if (entity.equals(player)) continue;
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.setVelocity(
                        livingEntity.getEyeLocation().subtract(player.getEyeLocation()).toVector().normalize().multiply(2));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 255, false));
            }
        }
        return true;
    }

    static boolean onClass6Skill4(Player player, LivingEntity rightClicked, int level) {
        plugin.getLogger().info("onClass6Skill4");
        double random = (Math.random() * 100);
        if (random <= 2 + level * 0.1)
            rightClicked.setHealth(0); // Revise
        else
            rightClicked.damage(5 + level * 0.5, player); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

}
