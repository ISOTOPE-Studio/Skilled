package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import cc.isotopestudio.Skilled.utli.PotionEffectUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

class Class6 {

    // 引魂
    // 技能1：控魂：使敌人减速 //点击生物
    // 技能2：诱魂：造成单体伤害并使敌人进入负面效果 //点击生物
    // 技能3：破魂：造成范围击退并产生短暂的禁锢 //点击空气
    // 技能4：灭火：单体攻击，有较小几率秒杀敌人，失败则造成少量伤害 //点击生物

    static boolean onClass6Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        plugin.getLogger().info("onClass6Skill1");
        player.sendMessage(Msg.release);
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (5 + 3 * level) * 20, level, false)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

    static boolean onClass6Skill2(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        plugin.getLogger().info("onClass6Skill2");
        rightClicked.damage(level, player); // Revise
        rightClicked.addPotionEffect(PotionEffectUtil.getRandomNegativeEffect(level)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

    static boolean onClass6Skill3(Player player, int level, Skilled plugin) {
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

    static boolean onClass6Skill4(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        plugin.getLogger().info("onClass6Skill4");
        double random = (Math.random() * 100);
        if (random <= 2 + level * 0.1)
            rightClicked.setHealth(0); // Revise
        else
            rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.HARM, (5 + 3 * level) * 20, 1 + level)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

}
