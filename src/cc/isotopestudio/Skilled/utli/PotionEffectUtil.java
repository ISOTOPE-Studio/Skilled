package cc.isotopestudio.Skilled.utli;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Mars on 7/5/2016.
 * Copyright ISOTOPE Studio
 */
public class PotionEffectUtil {

    public static PotionEffect getRandomNegativeEffect(int level) {
        int random = (int) (Math.random() * 8);
        switch (random) {
            case (0): {
                return new PotionEffect(PotionEffectType.CONFUSION, (5 + 3 * level) * 20, level, false);
            }
            case (1): {
                return new PotionEffect(PotionEffectType.HUNGER, (5 + 3 * level) * 20, level, false);
            }
            case (2): {
                return new PotionEffect(PotionEffectType.POISON, (5 + 3 * level) * 20, level, false);
            }
            case (3): {
                return new PotionEffect(PotionEffectType.SLOW, (5 + 3 * level) * 20, level, false);
            }
            case (4): {
                return new PotionEffect(PotionEffectType.SLOW_DIGGING, (5 + 3 * level) * 20, level, false);
            }
            case (5): {
                return new PotionEffect(PotionEffectType.WEAKNESS, (5 + 3 * level) * 20, level, false);
            }
            case (6): {
                return new PotionEffect(PotionEffectType.WITHER, (5 + 3 * level) * 20, level, false);
            }
            case (7): {
                return new PotionEffect(PotionEffectType.BLINDNESS, (5 + 3 * level) * 20, level, false);
            } default: {
                return new PotionEffect(PotionEffectType.CONFUSION, (5 + 3 * level) * 20, level, false);
            }
        }
    }
}
