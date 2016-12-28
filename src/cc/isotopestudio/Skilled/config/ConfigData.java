/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.config;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Names;

import static cc.isotopestudio.Skilled.Skilled.config;

public class ConfigData {

    public static int magicRefillValue = 0;
    public static int magicRefillRate = 0;
    public static int maxMagic = 200;
    public static int initialSkillPoint = 10;
    public static boolean onlyOnce = true;
    private static int[][] unlock;
    private static int[][] upgrade;
    private static int[][] magic;
    private static int[][] cooldown;
    public static int[][] maxlevel;

    public static int getUpgradeRequiredSkillPoint(String job, int skill) {
        int jobNum = Names.getClassNum(job);
        return upgrade[jobNum][skill];
    }

    public static int getUnlockRequiredSkillPoint(String job, int skill) {
        int jobNum = Names.getClassNum(job);
        return unlock[jobNum][skill];
    }

    public static int getRequiredMagic(String job, int skill) {
        int jobNum = Names.getClassNum(job);
        return magic[jobNum][skill];
    }

    public static int getCooldown(String job, int skill) {
        int jobNum = Names.getClassNum(job);
        return cooldown[jobNum][skill];
    }

    public static void updateConfig(Skilled plugin) {
        magicRefillRate = config.getInt("basic.magic.refillRate", 5);
        magicRefillValue = config.getInt("basic.magic.refillValue", 10);
        maxMagic = config.getInt("basic.magic.full", 200);
        initialSkillPoint = config.getInt("initial.skillPoint", 10);
        onlyOnce = config.getBoolean("basic.onlyOnce", true);
        unlock = new int[9][5];
        upgrade = new int[9][5];
        magic = new int[9][5];
        cooldown = new int[9][5];
        maxlevel = new int[9][5];
        for (int job = 1; job <= 8; job++) {
            for (int skill = 1; skill <= 4; skill++) {
                unlock[job][skill] = config.getInt("c" + job + ".s" + skill + ".skillPoint.unlock");
                upgrade[job][skill] = config.getInt("c" + job + ".s" + skill + ".skillPoint.upgrade");
                magic[job][skill] = config.getInt("c" + job + ".s" + skill + ".release.magic");
                cooldown[job][skill] = config.getInt("c" + job + ".s" + skill + ".release.cooldown");
                maxlevel[job][skill] = config.getInt("c" + job + ".s" + skill + ".maxlevel");
                System.out.println(unlock[job][skill] + " " + upgrade[job][skill] + " " + magic[job][skill] + " " + maxlevel[job][skill]);
            }
        }

    }

}
