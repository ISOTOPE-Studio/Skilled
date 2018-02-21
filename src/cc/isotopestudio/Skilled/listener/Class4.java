/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.List;

import static cc.isotopestudio.Skilled.Skilled.plugin;

class Class4 implements Listener {

    // 铁卫
    // 技能1：坚定不移：加抗性与血量 //点击空气
    // 技能2：怒吼：发出一个火球，伤害：50 //点击空气
    // 技能3：不屈：获得再生 II //点击空气
    // 技能4：坚不可摧：三秒内无视伤害 //点击空气

    static boolean onClass4Skill1(Player player, int level) {
        plugin.getLogger().info("onClass4Skill1");
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20,
                (int) (1 + level * 0.05), false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass4Skill2(Player player, int level) {
        plugin.getLogger().info("onClass4Skill2");
        Vector v = player.getLocation().getDirection().normalize();
        Fireball fb = player.launchProjectile(Fireball.class, v);
        fb.setYield(0);
        PluginManager pm = plugin.getServer().getPluginManager();
        FireballListener listener = new FireballListener(fb, level);
        pm.registerEvents(listener, plugin);
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    private static class FireballListener implements Listener {
        private final Fireball fireball;
        private final int range;
        private static final int damage = 5; // Reivse

        FireballListener(Fireball fireball, int level) {
            this.fireball = fireball;
            this.range = level * 2 + 5; //Revise
        }

        @EventHandler
        public void onArrow(ProjectileHitEvent event) {
            if (!(event.getEntity().equals(fireball))) return;
            try {
                ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, fireball.getLocation(), 20);
            } catch (Exception ignored) {
            }
            List<Entity> nearby = fireball.getNearbyEntities(range, range, range);
            for (Entity entity : nearby) {
                if (entity.equals(fireball.getShooter())) continue;
                if (entity instanceof LivingEntity) {
                    double percent = 1.0 - entity.getLocation().distance(fireball.getLocation()) / range;
                    ((LivingEntity) entity).damage(percent * damage, fireball);
                }
            }
            HandlerList.unregisterAll(this);
        }
    }

    @EventHandler
    public void fileball(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Fireball) {
            Location loc = event.getEntity().getLocation();
            event.getEntity().getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 10F, false, false);
        }
    }

    static boolean onClass4Skill3(Player player, int level) {
        plugin.getLogger().info("onClass4Skill3");
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (15 + 3 * level) * 20, 2, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass4Skill4(Player player, int level) {// 三秒这个设定是不合理的，因为没有可升级性
        plugin.getLogger().info("onClass4Skill4");
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (5 + 3 * level) * 20, 100, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

}
