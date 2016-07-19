package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import cc.isotopestudio.Skilled.utli.PotionEffectUtil;
import cc.isotopestudio.Skilled.utli.SkilledMetaData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static cc.isotopestudio.Skilled.Skilled.plugin;

class Class3 {

    // 鹰眼
    // 技能1：警惕：加移动速度和跳跃 //点击空气
    // 技能2：魔法箭：射出的箭附带随机负面效果 //点击空气
    // 技能3：轻语：增加攻击力 //点击空气
    // 技能4：箭雨：从空中落下一片箭雨 //点击空气

    static boolean onClass3Skill1(Player player, int level) {
        plugin.getLogger().info("onClass3Skill1");
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (5 + 3 * level) * 20, level, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass3Skill2(final Player player, int level) {
        plugin.getLogger().info("onClass3Skill2");
        PluginManager pm = plugin.getServer().getPluginManager();
        final ArrowListener listener = new ArrowListener(player, level);
        pm.registerEvents(listener, plugin);
        //player.sendMessage("to-do");
        new BukkitRunnable() {
            @Override
            public void run() {
                HandlerList.unregisterAll(listener);
                player.sendMessage(Msg.endSkill);
            }
        }.runTaskLater(plugin, 5 * 20);
        return true;
    }

    private static class ArrowListener implements Listener {
        private final Player player;
        private final int level;

        ArrowListener(Player player, int level) {
            this.player = player;
            this.level = level;
        }

        @EventHandler
        public void onArrow(EntityDamageByEntityEvent event) {
            if (!(event.getDamager() instanceof Arrow)) return;
            if (((Arrow) event.getDamager()).getShooter().equals(player) && event.getEntity() instanceof LivingEntity) {
                ((LivingEntity) event.getEntity()).addPotionEffect(PotionEffectUtil.getRandomNegativeEffect(level));
            }
        }
    }

    static boolean onClass3Skill3(Player player, int level) {
        plugin.getLogger().info("onClass3Skill3");
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (7 + 3 * level) * 20, level, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass3Skill4(Player player, int level) {
        plugin.getLogger().info("onClass3Skill4");
        Bat bat = (Bat) player.getWorld().spawnEntity(player.getLocation().add(0, 5, 0), EntityType.BAT);
        bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (5 + 3 * level) * 20, 1, true));
        Vector[] v = new Vector[10];
        v[0] = new Vector(2, -2, 0);
        v[1] = new Vector(1, -2, 0);
        v[2] = new Vector(1, -2, 0.2);
        v[3] = new Vector(1, -2, -0.2);
        v[4] = new Vector(2, -2, 1);
        v[5] = new Vector(1, -2, -1);
        v[6] = new Vector(1, -2, 1);
        v[7] = new Vector(1, -2, 1);
        v[8] = new Vector(1, -2, -1);
        v[9] = new Vector(-2, -2, 0);
        byte b = 0;
        SkilledMetaData data = new SkilledMetaData(plugin, b);
        for (int i = 0; i < 10; i++) {
            Arrow arrow = bat.launchProjectile(Arrow.class, v[i].normalize());
            arrow.setShooter(player);
            arrow.setMetadata("pickup", data);
            // arrow.
        }
        bat.remove();
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

}
