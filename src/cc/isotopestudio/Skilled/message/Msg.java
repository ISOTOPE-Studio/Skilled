/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.message;

import org.bukkit.ChatColor;

public class Msg {

    public static String noPermission;
    public static String notNumber;
    public static String mustBePlayer;
    public static String mustBeInt;
    public static String hasClass;
    public static String hasMetaData;
    public static String noItem;
    public static String mustbe1;
    public static String playerNotOnline;
    public static String noSkill;
    public static String noClass;
    public static String noMagic;
    public static String noSkillPoint;
    public static String noLife;
    public static String cooldown;
    public static String release;
    public static String endSkill;
    public static String successJoin;
    public static String successUnlock;
    public static String successUpgrade;

    public static String[][] skillName;
    public static String[][] skillDescription;
    public static String[] className;

    public static final String commandSkilledAddsp = (new StringBuilder()).append(ChatColor.GOLD)
            .append("/Skilled addsp <�������> <���ܵ���>").append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE)
            .append("�������Ӽ��ܵ���").toString();
    public static final String commandcBind = (new StringBuilder()).append(ChatColor.GOLD).append("/cBind <���ܱ��>")
            .append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE).append("�󶨵��ֳ���Ʒ").toString();

    public static String maxLevel;

}
