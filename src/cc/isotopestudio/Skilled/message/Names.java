/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.message;

import org.bukkit.ChatColor;

public class Names {

    public static String getClassName(int job) {
        return Msg.className[job];
    }

    public static String getSkillName(String job, int skill) {
        return Msg.skillName[getClassNum(job)][skill];
    }

    private static String getSkillInfo(String job, int skill) {
        return Msg.skillDescription[getClassNum(job)][skill];
    }

    public static String getClassColorName(int job) {
        return String.valueOf(ChatColor.DARK_RED) + ChatColor.BOLD + getClassName(job);
    }

    public static String getSkillColorInfo(int job, int skill) {
        return String.valueOf(ChatColor.GOLD) + ChatColor.BOLD +
                getSkillName(getClassName(job), skill) + ChatColor.RESET + ChatColor.GRAY +
                ": " + ChatColor.LIGHT_PURPLE + getSkillInfo(getClassName(job), skill);
    }

    public static String getSkillColorInfo(String job, int skill) {
        return String.valueOf(ChatColor.GOLD) + ChatColor.BOLD + getSkillName(job, skill) +
                ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.LIGHT_PURPLE +
                getSkillInfo(job, skill);
    }

    public static String getSkillColorName(String job, int skill) {
        return String.valueOf(ChatColor.RED) + ChatColor.BOLD + getSkillName(job, skill);

    }

    public static int getSkillNum(String skill) {
        for (int job = 1; job <= 8; job++) {
            for (int skillNum = 1; skillNum <= 4; skillNum++)
                if (getSkillName(getClassName(job), skillNum).equals(skill)) {
                    return skillNum;
                }
        }
        return -1;
    }

    public static int getClassNum(String job) {
        for (int i = 1; i <= 8; i++) {
            if (getClassName(i).equals(job))
                return i;
        }
        return -1;
    }
}
