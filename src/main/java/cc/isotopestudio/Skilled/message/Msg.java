package cc.isotopestudio.Skilled.message;

import org.bukkit.ChatColor;

import cc.isotopestudio.Skilled.Skilled;

public class Msg {

	public static final String noPermission = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û��Ȩ��")
			.toString();
	public static final String mustBePlayer = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
			.append("ֻ�������ʹ��").toString();

	public static final String mustBeInt = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
			.append("�ⲻ��һ����Ч���ְ�").toString();

	public static final String playerNotOnline = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
			.append("��ע����Ҳ�����").toString();

	public static final String noSkill = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û���������")
			.toString();
	public static final String noClass = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û�����ְҵ")
			.toString();
	public static final String mustbe1 = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("ֻ�ܰ�һ����Ʒ")
			.toString();

	public static final String commandSkilledAddsp = (new StringBuilder()).append(ChatColor.GOLD)
			.append("/Skilled addsp <�������> <���ܵ���>").append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE)
			.append("�������Ӽ��ܵ���").toString();
	public static final String commandcBind = (new StringBuilder()).append(ChatColor.GOLD).append("/cBind <���ܱ��>")
			.append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE).append("�󶨵��ֳ���Ʒ").toString();

}
