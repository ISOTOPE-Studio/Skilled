package cc.isotopestudio.Skilled.message;

import org.bukkit.ChatColor;

import cc.isotopestudio.Skilled.Skilled;

public class Msg {

	public static final String noPermission = 
			(new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("��û��Ȩ��").toString();
	public static final String mustBePlayer = 
			(new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("ֻ�������ʹ��").toString();

}
