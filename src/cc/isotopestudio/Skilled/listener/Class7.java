package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

class Class7 {

    // 光骑

    // 技能1：审判：造成单体伤害并点燃目标 //点击生物
    // 技能2：守护：范围增加抗性 //点击空气
    // 技能3：祈祷：生命吸收，伤害增加 //点击空气
    // 技能4：神临：无敌 //点击空气

    static boolean onClass7Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        plugin.getLogger().info("onClass7Skill1");
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, level, false)); // Revise
        rightClicked.setFireTicks((5 + 3 * level) * 20);// Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

    static boolean onClass7Skill2(Player player, int level, Skilled plugin) {
        plugin.getLogger().info("onClass7Skill2");
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
        plugin.getLogger().info("onClass7Skill3");
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

    static boolean onClass7Skill4(Player player, int level, Skilled plugin) {
        plugin.getLogger().info("onClass7Skill4");
        final int ticks = 20 * (level * 2 + 1); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, ticks, 100, false)); // Revise
        PluginManager pm = plugin.getServer().getPluginManager();
        InvincibleListener listener = new InvincibleListener(player, level);
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

    private static class InvincibleListener implements Listener {
        private final Player player;
        private final int level;

        InvincibleListener(Player player, int level) {
            this.player = player;
            this.level = level;
        }

        @EventHandler(priority = EventPriority.HIGHEST)
        public void onDamage(EntityDamageEvent event) {
            if (event.getEntity().equals(player)) {
                event.setCancelled(true);
            }
        }
    }

}
