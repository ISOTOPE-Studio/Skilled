package cc.isotopestudio.Skilled.message;

import cc.isotopestudio.Skilled.Skilled;
import org.bukkit.ChatColor;

public class Msg {

    public static final String noPermission = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("你没有权限")
            .toString();
    public static final String notNumber = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("这不是一个数字")
            .toString();
    public static final String mustBePlayer = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("只有玩家能使用").toString();

    public static final String mustBeInt = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("这不是一个有效数字吧").toString();

    public static final String mustbe1 = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("只能绑定一个物品")
            .toString();
    public static final String playerNotOnline = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED)
            .append("请注意玩家不在线").toString();

    public static final String noSkill = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("你没有这个技能")
            .toString();
    public static final String noClass = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("你没有这个职业")
            .toString();
    public static final String noMagic = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("法力值不足")
            .toString();
    public static final String noSkillPoint = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("技能点不足")
            .toString();
    public static final String noLife = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("周围无生物")
            .toString();
    public static final String cooldown = (new StringBuilder(Skilled.prefix)).append(ChatColor.RED).append("技能冷却中，还有")
            .toString();

    public static final String release = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD).append("成功释放技能")
            .toString();

    public static final String successJoin = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD).append("成功加入职业")
            .toString();
    public static final String successUnlock = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD).append("成功解锁技能")
            .toString();
    public static final String successUpgrade = (new StringBuilder(Skilled.prefix)).append(ChatColor.GOLD)
            .append("成功升级技能").toString();

    public static final String commandSkilledAddsp = (new StringBuilder()).append(ChatColor.GOLD)
            .append("/Skilled addsp <玩家名字> <技能点数>").append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE)
            .append("给玩家添加技能点数").toString();
    public static final String commandcBind = (new StringBuilder()).append(ChatColor.GOLD).append("/cBind <技能编号>")
            .append(ChatColor.GRAY).append(" - ").append(ChatColor.LIGHT_PURPLE).append("绑定到手持物品").toString();

}
