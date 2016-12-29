/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.player.PlayerData;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

import static cc.isotopestudio.Skilled.Skilled.plugin;

class Class1 {
    // 圣谕

    // 技能1：治愈：恢复目标生命值 //点击生物
    // 技能2：活力：恢复目标法力值 //点击玩家
    // 技能3：神圣打击：召唤天雷攻击敌人 //点击空气
    // 技能4：生命源泉：群体恢复 //点击空气

    static boolean onClass1Skill1(Player player, LivingEntity rightClicked, int level) {
        plugin.getLogger().info("onClass1Skill1");
        if (!isAllowed(rightClicked.getType())) {
            player.sendMessage(Skilled.prefix + "不能给它回血");
            return false;
        }

        double health = rightClicked.getHealth();
        if (rightClicked.getMaxHealth() == health)

        {
            player.sendMessage(Skilled.prefix + "已经满血");
            return false;
        }

        health += 5 * (1 + 2 * level); // Revise
        if (health > rightClicked.getMaxHealth())

        {
            health = rightClicked.getMaxHealth();
        }

        rightClicked.setHealth(health);

        try

        {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        } catch (
                Exception ignored)

        {
        }

        return true;
    }

    static boolean onClass1Skill2(Player player, Player rightClicked, int level) {
        plugin.getLogger().info("onClass1Skill2");
        int magic = PlayerData.getMagic(rightClicked);
        if (ConfigData.maxMagic <= magic) {
            player.sendMessage(Skilled.prefix + "法力值已满");
            return false;
        }
        magic += (int) (10 * (1 + 0.05 * level)); // Revise
        if (ConfigData.maxMagic <= magic) {
            magic = ConfigData.maxMagic;
        }
        PlayerData.setMagic(rightClicked, magic);
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass1Skill3(Player player, int level) {
        plugin.getLogger().info("onClass1Skill3");
        Location[] target = new Location[6];
        target[0] = player.getLocation().clone().add(3, 0, 0);
        target[1] = player.getLocation().clone().add(3, 0, 3);
        target[2] = player.getLocation().clone().add(0, 0, 3);
        target[3] = player.getLocation().clone().add(0, 0, -3);
        target[4] = player.getLocation().clone().add(-3, 0, 0);
        target[5] = player.getLocation().clone().add(-3, 0, 3);
        for (int i = 0; i < 6; i++)
            player.getWorld().strikeLightningEffect(target[i]);
        for (Entity entity : player.getNearbyEntities(3, 3, 3)) {
            if (entity instanceof LivingEntity)
                ((LivingEntity) entity).damage(2 + level * 0.5, player); // Revise
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 100, false)); // Revise
        try {
            ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        } catch (Exception ignored) {
        }
        return true;
    }

    static boolean onClass1Skill4(Player player, int level) {
        plugin.getLogger().info("onClass1Skill4");
        double radius = 5D;
        List<Entity> near = player.getLocation().getWorld().getEntities();
        int count = 0;
        for (Entity entity : near) {
            if (entity.getLocation().distance(player.getLocation()) <= radius)
                if (entity instanceof LivingEntity && isAllowed(entity.getType())) {

                    double health = ((LivingEntity) entity).getHealth();
                    if (((LivingEntity) entity).getMaxHealth() == health) {
                        continue;
                    }
                    health += (int) (Math.random() * 7 * (1 + 2 * level)); // Revise
                    if (health > ((LivingEntity) entity).getMaxHealth()) {
                        health = ((LivingEntity) entity).getMaxHealth();
                    }

                    ((LivingEntity) entity).setHealth(health);
                    try {
                        for (int i = 0; i < 4; i++) {
                            new HeartEffect(entity.getLocation()).runTaskLater(plugin, i);
                        }
                    } catch (Exception ignored) {
                    }
                    count++;
                }
        }
        if (count == 0) {
            player.sendMessage(Msg.noLife);
            return false;
        }
        return true;
    }

    private static boolean isAllowed(EntityType type) {
        return type == EntityType.PLAYER || type == EntityType.CHICKEN
                || type == EntityType.COW || type == EntityType.HORSE
                || type == EntityType.IRON_GOLEM || type == EntityType.MUSHROOM_COW
                || type == EntityType.OCELOT || type == EntityType.PIG
                || type == EntityType.SHEEP || type == EntityType.SNOWMAN
                || type == EntityType.VILLAGER || type == EntityType.WOLF;
    }

    private static class HeartEffect extends BukkitRunnable {
        private final Location location;

        private HeartEffect(Location location) {
            this.location = location;
        }

        @Override
        public void run() {
            ParticleEffect.HEART.display((float) (Math.random() * 3), 2F + (float) (Math.random() * 3), (float) (Math.random() * 3), 1, 20, location, 20);
        }
    }

}