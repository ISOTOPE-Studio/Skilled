package cc.isotopestudio.Skilled.message;

import org.bukkit.ChatColor;

public class Names {

    public static String getClassName(int job) {
        switch (job) {
            case (1): {
                return "圣谕";
            }
            case (2): {
                return "暗影";
            }
            case (3): {
                return "鹰眼";
            }
            case (4): {
                return "铁卫";
            }
            case (5): {
                return "血怒";
            }
            case (6): {
                return "引魂";
            }
            case (7): {
                return "光骑";
            }
            case (8): {
                return "猎刃";
            }
            default: {
                return null;
            }

        }
    }

    public static String getSkillName(String job, int skill) {
        if (job.equals(getClassName(1))) {
            switch (skill) {
                case (1): {
                    return "治愈";
                }
                case (2): {
                    return "活力";
                }
                case (3): {
                    return "神圣打击";
                }
                case (4): {
                    return "生命源泉";
                }
            }
        } else if (job.equals(getClassName(2))) {
            switch (skill) {
                case (1): {
                    return "影击";
                }
                case (2): {
                    return "影化";
                }
                case (3): {
                    return "孤注一掷";
                }
                case (4): {
                    return "影舞";
                }
            }
        } else if (job.equals(getClassName(3))) {
            switch (skill) {
                case (1): {
                    return "警惕";
                }
                case (2): {
                    return "魔法箭";
                }
                case (3): {
                    return "轻语";
                }
                case (4): {
                    return "箭雨";
                }
            }
        } else if (job.equals(getClassName(4))) {
            switch (skill) {
                case (1): {
                    return "坚定不移";
                }
                case (2): {
                    return "怒吼";
                }
                case (3): {
                    return "不屈";
                }
                case (4): {
                    return "坚不可摧";
                }
            }
        } else if (job.equals(getClassName(5))) {
            switch (skill) {
                case (1): {
                    return "压制";
                }
                case (2): {
                    return "狂化";
                }
                case (3): {
                    return "怒火";
                }
                case (4): {
                    return "一夫当关";
                }
            }
        } else if (job.equals(getClassName(6))) {
            switch (skill) {
                case (1): {
                    return "控魂";
                }
                case (2): {
                    return "诱魂";
                }
                case (3): {
                    return "破魂";
                }
                case (4): {
                    return "灭火";
                }
            }
        } else if (job.equals(getClassName(7))) {
            switch (skill) {
                case (1): {
                    return "审判";
                }
                case (2): {
                    return "守护";
                }
                case (3): {
                    return "祈祷";
                }
                case (4): {
                    return "神临";
                }
            }
        } else if (job.equals(getClassName(8))) {
            switch (skill) {
                case (1): {
                    return "影";
                }
                case (2): {
                    return "烈";
                }
                case (3): {
                    return "暗";
                }
                case (4): {
                    return "刃";
                }
            }
        }
        return null;
    }

    private static String getSkillInfo(String job, int skill) {
        if (job.equals(getClassName(1))) {
            switch (skill) {
                case (1): {
                    return "恢复目标玩家生命值";
                }
                case (2): {
                    return "恢复目标玩家法力值";
                }
                case (3): {
                    return "召唤天雷攻击敌人";
                }
                case (4): {
                    return "群体恢复";
                }
            }
        } else if (job.equals(getClassName(2))) {
            switch (skill) {
                case (1): {
                    return "瞬移到背后给敌人一击";
                }
                case (2): {
                    return "获得隐身效果";
                }
                case (3): {
                    return "血量减少，但攻击力上升";
                }
                case (4): {
                    return "挥动匕首，造成范围伤害并中毒";
                }
            }
        } else if (job.equals(getClassName(3))) {
            switch (skill) {
                case (1): {
                    return "增加移动速度和跳跃力";
                }
                case (2): {
                    return "射出的箭附带随机负面效果";
                }
                case (3): {
                    return "一定时间提升玩家攻击力";
                }
                case (4): {
                    return "从空中落下一片箭雨";
                }
            }
        } else if (job.equals(getClassName(4))) {
            switch (skill) {
                case (1): {
                    return "增加抗性与血量";
                }
                case (2): {
                    return "发出一个火球";
                }
                case (3): {
                    return "获得再生效果";
                }
                case (4): {
                    return "可在三秒内无视伤害";
                }
            }
        } else if (job.equals(getClassName(5))) {
            switch (skill) {
                case (1): {
                    return "攻击使目标虚弱";
                }
                case (2): {
                    return "自身收到灼烧伤害，但攻击附加生命偷取效果 ";
                }
                case (3): {
                    return "对目标区域产生范围伤害，并附加燃烧效果";
                }
                case (4): {
                    return "一定时间内攻击力获得大幅提升，并获得再生效果 ";
                }
            }
        } else if (job.equals(getClassName(6))) {
            switch (skill) {
                case (1): {
                    return "进行施法使目标敌人减速";
                }
                case (2): {
                    return "对敌人造成单体伤害并使敌人进入负面效果 ";
                }
                case (3): {
                    return "所所指位置造成范围击退并产生短暂的禁锢";
                }
                case (4): {
                    return "有较小几率秒杀目标，否则对目标造成少量伤害";
                }
            }
        } else if (job.equals(getClassName(7))) {
            switch (skill) {
                case (1): {
                    return "对目标造成单体伤害并点燃目标";
                }
                case (2): {
                    return "对目标所处范围玩家增加抗性效果";
                }
                case (3): {
                    return "获得生命吸收效果，并且自身伤害增加";
                }
                case (4): {
                    return "无视任何伤害";
                }
            }
        } else if (job.equals(getClassName(8))) {
            switch (skill) {
                case (1): {
                    return "增加移动速度和攻击力以及生命恢复效果";
                }
                case (2): {
                    return "对目标造成单体伤害，附加点燃和虚弱";
                }
                case (3): {
                    return "在一定时间内攻击附带虚弱和失明效果";
                }
                case (4): {
                    return "造成范围伤害，以及虚弱和凋零效果";
                }
            }
        }
        return null;
    }

    public static String getClassColorName(int job) {
        return new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append(getClassName(job))
                .toString();
    }

    public static String getSkillColorInfo(int job, int skill) {
        return new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD)
                .append(getSkillName(getClassName(job), skill)).append(ChatColor.RESET).append(ChatColor.GRAY)
                .append(": ").append(ChatColor.LIGHT_PURPLE).append(getSkillInfo(getClassName(job), skill)).toString();
    }

    public static String getSkillColorInfo(String job, int skill) {
        return new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append(getSkillName(job, skill))
                .append(ChatColor.RESET).append(ChatColor.GRAY).append(": ").append(ChatColor.LIGHT_PURPLE)
                .append(getSkillInfo(job, skill)).toString();
    }

    public static String getSkillColorName(String job, int skill) {
        return new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append(getSkillName(job, skill))
                .toString();

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
