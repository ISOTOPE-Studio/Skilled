/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.player;

import org.bukkit.entity.Player;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class PlayerData {

    public static boolean ifHasClass(Player player, String job) {
        return job.equals(plugin.getPlayersData().getString(player.getName() + ".class"));
    }

    public static boolean ifHasSkill(Player player, int skill) {
        return getLevel(player, skill) > 0;
    }

    public static int getLevel(Player player, int skill) {
        return plugin.getPlayersData().getInt(player.getName() + ".skill" + skill);
    }

    public static void setLevel(Player player, int skill, int level) {
        plugin.getPlayersData().set(player.getName() + ".skill" + skill, level);
        plugin.savePlayersData();
    }

    public static void addLevel(Player player, int skill) {
        int newLevel = getLevel(player, skill) + 1;
        setLevel(player, skill, newLevel);
    }

    public static String getClass(Player player) {
        return plugin.getPlayersData().getString(player.getName() + ".class");
    }

    public static void setClass(Player player, String job) {
        plugin.getPlayersData().set(player.getName() + ".class", job);
        plugin.savePlayersData();
    }

    public static int getSkillPoint(Player player) {
        return plugin.getPlayersData().getInt(player.getName() + ".skillPoint");
    }

    private static int getSkillPoint(String player) {
        return plugin.getPlayersData().getInt(player + ".skillPoint");
    }

    public static void setSkillPoint(Player player, int point) {
        plugin.getPlayersData().set(player.getName() + ".skillPoint", point);
        plugin.savePlayersData();
    }

    private static void setSkillPoint(String player, int point) {
        plugin.getPlayersData().set(player + ".skillPoint", point);
        plugin.savePlayersData();
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
        return plugin.getPlayersData().getInt(player.getName() + ".magic");
    }

    public static void setMagic(Player player, int magic) {
        plugin.getPlayersData().set(player.getName() + ".magic", magic);
        plugin.savePlayersData();
    }

    public static void decreaseMagic(Player player, int magic) {
        int newMagic = getMagic(player) - magic;
        setMagic(player, newMagic);
        plugin.savePlayersData();
    }

    public static int getMagic(String player) {
        return plugin.getPlayersData().getInt(player + ".magic");
    }

    public static void setMagic(String player, int magic) {
        plugin.getPlayersData().set(player + ".magic", magic);
        plugin.savePlayersData();
    }

    public static boolean isCooldown(Player player, int skill) {
        return plugin.getPlayersData().getBoolean(player.getName() + ".cooldown." + skill, false);
    }

    public static void setCooldown(Player player, int skill, boolean isCooldown) {
        plugin.getPlayersData().set(player.getName() + ".cooldown." + skill, isCooldown);
        plugin.savePlayersData();
    }

    public static void setCooldown(String player, int skill, boolean isCooldown) {
        plugin.getPlayersData().set(player + ".cooldown." + skill, isCooldown);
        plugin.savePlayersData();
    }
}
