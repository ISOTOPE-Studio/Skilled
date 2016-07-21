/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.message;

import cc.isotopestudio.Skilled.Skilled;
import org.bukkit.ChatColor;

public class Msg {

    public static final String noPermission = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û��Ȩ��")
            .toString();
    public static final String notNumber = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("�ⲻ��һ������")
            .toString();
    public static final String mustBePlayer = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("ֻ�������ʹ��").toString();

    public static final String mustBeInt = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("�ⲻ��һ����Ч���ְ�").toString();
    public static final String hasClass = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("���Ѿ�ѡ��ְҵ��").toString();

    public static final String hasMetaData = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("����Ʒ���Զ�����Ϣ, �޷���").toString();
    public static final String noItem = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("û����Ʒ, �޷���").toString();

    public static final String mustbe1 = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("ֻ�ܰ�һ����Ʒ")
            .toString();
    public static final String playerNotOnline = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("��ע����Ҳ�����").toString();

    public static final String noSkill = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û���������")
            .toString();
    public static final String noClass = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û�����ְҵ")
            .toString();
    public static final String noMagic = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("����ֵ����")
            .toString();
    public static final String noSkillPoint = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("���ܵ㲻��")
            .toString();
    public static final String noLife = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��Χ������")
            .toString();
    public static final String cooldown = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("������ȴ�У�����")
            .toString();

    public static final String release = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD).append("�ɹ��ͷż���")
            .toString();
    public static final String endSkill = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("����ʱ�����")
            .toString();

    public static final String successJoin = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD).append("�ɹ�����ְҵ")
            .toString();
    public static final String successUnlock = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD).append("�ɹ���������")
            .toString();
    public static final String successUpgrade = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD)
            .append("�ɹ���������").toString();

    public static final String commandSkilledAddsp = (new StringBuilder()).append(ChatColor.GOLD)
            .append("/Skilled addsp <�������> <���ܵ���>").append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE)
            .append("�������Ӽ��ܵ���").toString();
    public static final String commandcBind = (new StringBuilder()).append(ChatColor.GOLD).append("/cBind <���ܱ��>")
            .append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE).append("�󶨵��ֳ���Ʒ").toString();

}
