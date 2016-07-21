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
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

import static cc.isotopestudio.Skilled.Skilled.plugin;

class Class8 {

    // 猎刃

    // 技能1：影：增加移动速度和攻击力以及生命恢复 //点击空气
    // 技能2：烈：单体伤害，附加点燃和虚弱 //点击生物
    // 技能3：暗：一定时间内攻击附带虚弱和失明 //点击空气
    // 技能4：刃：范围伤害，附带虚弱和凋零 //点击空气

    static boolean onClass8Skill1(Player player, int level) {
        plugin.getLogger().info("onClass8Skill1");
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass8Skill2(Player player, LivingEntity rightClicked, int level) {
        plugin.getLogger().info("onClass8Skill2");
        rightClicked.damage(2 + 0.5 * level, player); // Revise
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
        rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass8Skill3(final Player player, int level) {
        plugin.getLogger().info("onClass8Skill3");
        final int ticks = 20 * (level * 2 + 1); // Revise
        PluginManager pm = plugin.getServer().getPluginManager();
        final DamageListener listener = new DamageListener(player, level);
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

    private static class DamageListener implements Listener {
        private final Player player;
        private final int level;

        DamageListener(Player player, int level) {
            this.player = player;
            this.level = level;
        }

        @EventHandler(priority = EventPriority.HIGHEST)
        public void onDamage(EntityDamageByEntityEvent event) {
            if (event.getDamager().equals(player) && event.getEntity() instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) event.getEntity();
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (1 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, (1 + 3 * level) * 20, (int) (1 + level * 0.05), false));
            }
        }
    }

    static boolean onClass8Skill4(Player player, int level) {
        plugin.getLogger().info("onClass8Skill4");
        double radius = 5D;
        List<Entity> near = player.getLocation().getWorld().getEntities();
        int count = 0;
        for (Entity entity : near) {
            if (entity.getLocation().distance(player.getLocation()) <= radius) {
                if (entity.equals(player))
                    continue;
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).damage(2 + 0.3 * level, player);
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
                            (5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
                            (5 + 3 * level) * 20, (int) (1 + level * 0.05), false));
                    try {
                        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
                    } catch (Exception ignored) {
                    }
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
