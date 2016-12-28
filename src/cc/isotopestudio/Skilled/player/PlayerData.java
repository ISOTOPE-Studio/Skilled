/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.player;

import org.bukkit.entity.Player;

import static cc.isotopestudio.Skilled.Skilled.playerData;

public class PlayerData {

    public static boolean ifHasClass(Player player, String job) {
        return job.equals(playerData.getString(player.getName() + ".class"));
    }

    public static boolean ifHasSkill(Player player, int skill) {
        return getLevel(player, skill) > 0;
    }

    public static int getLevel(Player player, int skill) {
        return playerData.getInt(player.getName() + ".skill" + skill);
    }

    public static void setLevel(Player player, int skill, int level) {
        playerData.set(player.getName() + ".skill" + skill, level);
        playerData.save();
    }

    public static void addLevel(Player player, int skill) {
        int newLevel = getLevel(player, skill) + 1;
        setLevel(player, skill, newLevel);
    }

    public static String getClass(Player player) {
        return playerData.getString(player.getName() + ".class");
    }

    public static void setClass(Player player, String job) {
        playerData.set(player.getName() + ".class", job);
        playerData.save();
    }

    public static int getSkillPoint(Player player) {
        return playerData.getInt(player.getName() + ".skillPoint");
    }

    private static int getSkillPoint(String player) {
        return playerData.getInt(player + ".skillPoint");
    }

    public static void setSkillPoint(Player player, int point) {
        playerData.set(player.getName() + ".skillPoint", point);
        playerData.save();
    }

    private static void setSkillPoint(String player, int point) {
        playerData.set(player + ".skillPoint", point);
        playerData.save();
    }

    public static void addSkillPoint(Player player, int i) {
        int newSkillPoint = getSkillPoint(player) + i;
        setSkillPoint(player, newSkillPoint);
    }

    public static void addSkillPoint(String player, int i) {
        int newSkillPoint = getSkillPoint(player) + i;
        setSkillPoint(player, newSkillPoint);
    }

    public static int getMagic(Player player) {
        return playerData.getInt(player.getName() + ".magic");
    }

    public static void setMagic(Player player, int magic) {
        playerData.set(player.getName() + ".magic", magic);
        playerData.save();
    }

    public static void decreaseMagic(Player player, int magic) {
        int newMagic = getMagic(player) - magic;
        setMagic(player, newMagic);
        playerData.save();
    }

    public static int getMagic(String player) {
        return playerData.getInt(player + ".magic");
    }

    public static void setMagic(String player, int magic) {
        playerData.set(player + ".magic", magic);
        playerData.save();
    }

    public static boolean isCooldown(Player player, int skill) {
        return playerData.getBoolean(player.getName() + ".cooldown." + skill, false);
    }

    public static void setCooldown(Player player, int skill, boolean isCooldown) {
        playerData.set(player.getName() + ".cooldown." + skill, isCooldown);
        playerData.save();
    }

    public static void setCooldown(String player, int skill, boolean isCooldown) {
        playerData.set(player + ".cooldown." + skill, isCooldown);
        playerData.save();

    }
}
