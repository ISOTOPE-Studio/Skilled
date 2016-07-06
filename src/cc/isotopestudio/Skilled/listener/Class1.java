package cc.isotopestudio.Skilled.listener;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.player.PlayerData;
import cc.isotopestudio.Skilled.utli.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.List;

class Class1 {
    // ʥ��

    // ����1���������ָ�Ŀ������ֵ //�������
    // ����2���������ָ�Ŀ�귨��ֵ //������
    // ����3����ʥ������ٻ����׹������� //�������
    // ����4������ԴȪ��Ⱥ��ָ� //�������

    static boolean onClass1Skill1(Player player, LivingEntity rightClicked, int level, Skilled plugin) {
        System.out.print("onClass1Skill1");
        double health = rightClicked.getHealth();
        if (rightClicked.getMaxHealth() == health) {
            player.sendMessage(Skilled.prefix + "�Ѿ���Ѫ");
            return false;
        }
        health += 5 * (1 + 2 * level); // Revise
        if (health > rightClicked.getMaxHealth()) {
            health = rightClicked.getMaxHealth();
        }

        rightClicked.setHealth(health);
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

    static boolean onClass1Skill2(Player player, Player rightClicked, int level, Skilled plugin) {
        PlayerData data = new PlayerData(plugin);
        System.out.print("onClass1Skill2");
        int magic = data.getMagic(rightClicked);
        if (ConfigData.maxMagic <= magic) {
            player.sendMessage(Skilled.prefix + "����ֵ����");
            return false;
        }
        magic += (int) (10 * (1 + 0.05 * level)); // Revise
        if (ConfigData.maxMagic <= magic) {
            magic = ConfigData.maxMagic;
        }
        data.setMagic(rightClicked, magic);
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, rightClicked.getLocation(), 20);
        return true;
    }

    public static boolean onClass1Skill3(Player player, int level, Skilled skilled) {
        System.out.print("onClass1Skill3");
        Location[] target = new Location[6];
        target[0] = player.getLocation().clone().add(3, 0, 0);
        target[1] = player.getLocation().clone().add(3, 0, 3);
        target[2] = player.getLocation().clone().add(0, 0, 3);
        target[3] = player.getLocation().clone().add(0, 0, -3);
        target[4] = player.getLocation().clone().add(-3, 0, 0);
        target[5] = player.getLocation().clone().add(-3, 0, 3);
        for (int i = 0; i < 6; i++)
            player.getWorld().strikeLightning(target[i]);
        ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, player.getLocation(), 20);
        return true;
    }

    static boolean onClass1Skill4(Player player, int level, Skilled skilled) {
        System.out.print("onClass1Skill4");
        double radius = 5D;
        List<Entity> near = player.getLocation().getWorld().getEntities();
        int count = 0;
        for (Entity entity : near) {
            if (entity.getLocation().distance(player.getLocation()) <= radius)
                if (entity instanceof LivingEntity) {

                    double health = ((LivingEntity) entity).getHealth();
                    if (((LivingEntity) entity).getMaxHealth() == health) {
                        continue;
                    }
                    health += (int) (Math.random() * 7 * (1 + 2 * level)); // Revise
                    if (health > ((LivingEntity) entity).getMaxHealth()) {
                        health = ((LivingEntity) entity).getMaxHealth();
                    }

                    ((LivingEntity) entity).setHealth(health);
                    ParticleEffect.EXPLOSION_NORMAL.display(0F, 0F, 0F, 1, 20, entity.getLocation(), 20);
                    count++;
                }
        }
        if (count == 0) {
            player.sendMessage(Msg.noLife);
            return false;
        }
        return true;
    }

}
