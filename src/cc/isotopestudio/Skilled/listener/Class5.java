/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

import static cc.isotopestudio.Skilled.Skilled.plugin;

class Class5 {

    // Ѫŭ
    // ����1��ѹ�ƣ�����ʹĿ������ //�������
    // ����2���񻯣�������ȼ��������������͵ȡ //�������
    // ����3��ŭ�𣺷�Χʹ�����ܵ��˺���ȼ�� //�������
    // ����4��һ�򵱹أ�һ��ʱ���ڹ���������������������Ч�� //�������

    static boolean onClass5Skill1(final Player player, int level) {
        plugin.getLogger().info("onClass5Skill1");
        final int ticks = (1 + level * 2) * 20; //Revise
        PluginManager pm = plugin.getServer().getPluginManager();
        final WeaknessListener listener = new WeaknessListener(player, level);
        pm.registerEvents(listener, plugin);
        new BukkitRunnable() {
            @Override
            public void run() {
                HandlerList.unregisterAll(listener);
                player.sendMessage(Msg.endSkill);
            }
        }.runTaskLater(plugin, ticks);
        return true;
    }

    private static class WeaknessListener implements Listener {
        private final Player player;
        private final int level;

        WeaknessListener(Player player, int level) {
            this.player = player;
            this.level = level;
        }

        @EventHandler
        public void onDamaged(EntityDamageByEntityEvent event) {
            if (event.getEntity() instanceof LivingEntity && event.getDamager().equals(player)) {
                ((LivingEntity) event.getEntity()).addPotionEffect(
                        new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
                try {
                    ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
                } catch (Exception ignored) {
                }
            }
        }
    }

    static boolean onClass5Skill2(final Player player, int level) {
        plugin.getLogger().info("onClass5Skill2");
        final int ticks = (1 + level * 2) * 20; //Revise
        player.setFireTicks(ticks);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, ticks, 1, false)); // Revise
        PluginManager pm = plugin.getServer().getPluginManager();
        final LifeListener listener = new LifeListener(player, level);
        pm.registerEvents(listener, plugin);
        new BukkitRunnable() {
            @Override
            public void run() {
                HandlerList.unregisterAll(listener);
                player.sendMessage(Msg.endSkill);
            }
        }.runTaskLater(plugin, ticks);
        return true;
    }

    private static class LifeListener implements Listener {
        private final Player player;
        private final int level;
        private static final double percent = 0.9; // Reivse

        LifeListener(Player player, int level) {
            this.player = player;
            this.level = level; //Revise
        }

        @EventHandler
        public void onDamaged(EntityDamageByEntityEvent event) {
            if (event.getEntity() instanceof LivingEntity && event.getDamager().equals(player)) {
                double max = player.getMaxHealth();
                double health = player.getHealth() + event.getDamage();
                // double health = player.getHealth() + event.getFinalDamage();
                if (health > max) {
                    health = max;
                }
                player.setHealth(health);
            }
        }
    }


    static boolean onClass5Skill3(Player player, int level) {
        plugin.getLogger().info("onClass5Skill3");
        final double range = 5 + level * 2; // Reivse
        List<Entity> nearby = player.getNearbyEntities(range, range, range);
        for (Entity entity : nearby) {
            if (entity.equals(player)) continue;
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.setFireTicks(40); // Reivse
                livingEntity.damage(4, player);
            }
        }
        return true;
    }

    static boolean onClass5Skill4(Player player, int level) {
        plugin.getLogger().info("onClass5Skill4");
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

}
