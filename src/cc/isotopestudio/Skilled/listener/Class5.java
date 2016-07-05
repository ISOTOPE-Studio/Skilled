package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class Class5 {

    // 血怒
    // 技能1：压制：攻击使目标虚弱 //点击生物
    // 技能2：狂化：自身被点燃，但攻击带生命偷取 //点击空气
    // 技能3：怒火：范围使敌人受到伤害且燃烧 //点击空气
    // 技能4：一夫当关：一定时间内攻击力大幅提升，获得再生效果 //点击空气

    public static boolean onClass5Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        System.out.print("onClass5Skill1");
        rightClicked.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

    public static boolean onClass5Skill2(Player player, int level, Skilled plugin) {
        System.out.print("onClass5Skill2");
        return true;
    }

    public static boolean onClass5Skill3(Player player, int level, Skilled plugin) {
        System.out.print("onClass5Skill3");
        return true;
    }

    public static boolean onClass5Skill4(Player player, int level, Skilled plugin) {
        System.out.print("onClass5Skill4");
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (5 + 3 * level) * 20, level, false)); // Revise
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (5 + 3 * level) * 20, level, false)); // Revise
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

}
