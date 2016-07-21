/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.message;

import org.bukkit.ChatColor;

public class Names {

    public static String getClassName(int job) {
        switch (job) {
            case (1): {
                return "ʥ��";
            }
            case (2): {
                return "��Ӱ";
            }
            case (3): {
                return "ӥ��";
            }
            case (4): {
                return "����";
            }
            case (5): {
                return "Ѫŭ";
            }
            case (6): {
                return "����";
            }
            case (7): {
                return "����";
            }
            case (8): {
                return "����";
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
                    return "����";
                }
                case (2): {
                    return "����";
                }
                case (3): {
                    return "��ʥ���";
                }
                case (4): {
                    return "����ԴȪ";
                }
            }
        } else if (job.equals(getClassName(2))) {
            switch (skill) {
                case (1): {
                    return "Ӱ��";
                }
                case (2): {
                    return "Ӱ��";
                }
                case (3): {
                    return "��עһ��";
                }
                case (4): {
                    return "Ӱ��";
                }
            }
        } else if (job.equals(getClassName(3))) {
            switch (skill) {
                case (1): {
                    return "����";
                }
                case (2): {
                    return "ħ����";
                }
                case (3): {
                    return "����";
                }
                case (4): {
                    return "����";
                }
            }
        } else if (job.equals(getClassName(4))) {
            switch (skill) {
                case (1): {
                    return "�ᶨ����";
                }
                case (2): {
                    return "ŭ��";
                }
                case (3): {
                    return "����";
                }
                case (4): {
                    return "�᲻�ɴ�";
                }
            }
        } else if (job.equals(getClassName(5))) {
            switch (skill) {
                case (1): {
                    return "ѹ��";
                }
                case (2): {
                    return "��";
                }
                case (3): {
                    return "ŭ��";
                }
                case (4): {
                    return "һ�򵱹�";
                }
            }
        } else if (job.equals(getClassName(6))) {
            switch (skill) {
                case (1): {
                    return "�ػ�";
                }
                case (2): {
                    return "�ջ�";
                }
                case (3): {
                    return "�ƻ�";
                }
                case (4): {
                    return "���";
                }
            }
        } else if (job.equals(getClassName(7))) {
            switch (skill) {
                case (1): {
                    return "����";
                }
                case (2): {
                    return "�ػ�";
                }
                case (3): {
                    return "��";
                }
                case (4): {
                    return "����";
                }
            }
        } else if (job.equals(getClassName(8))) {
            switch (skill) {
                case (1): {
                    return "Ӱ";
                }
                case (2): {
                    return "��";
                }
                case (3): {
                    return "��";
                }
                case (4): {
                    return "��";
                }
            }
        }
        return null;
    }

    private static String getSkillInfo(String job, int skill) {
        if (job.equals(getClassName(1))) {
            switch (skill) {
                case (1): {
                    return "�ָ�Ŀ���������ֵ";
                }
                case (2): {
                    return "�ָ�Ŀ����ҷ���ֵ";
                }
                case (3): {
                    return "�ٻ����׹�������";
                }
                case (4): {
                    return "Ⱥ��ָ�";
                }
            }
        } else if (job.equals(getClassName(2))) {
            switch (skill) {
                case (1): {
                    return "˲�Ƶ����������һ��";
                }
                case (2): {
                    return "�������Ч��";
                }
                case (3): {
                    return "Ѫ�����٣�������������";
                }
                case (4): {
                    return "�Ӷ�ذ�ף���ɷ�Χ�˺����ж�";
                }
            }
        } else if (job.equals(getClassName(3))) {
            switch (skill) {
                case (1): {
                    return "�����ƶ��ٶȺ���Ծ��";
                }
                case (2): {
                    return "����ļ������������Ч��";
                }
                case (3): {
                    return "һ��ʱ��������ҹ�����";
                }
                case (4): {
                    return "�ӿ�������һƬ����";
                }
            }
        } else if (job.equals(getClassName(4))) {
            switch (skill) {
                case (1): {
                    return "���ӿ�����Ѫ��";
                }
                case (2): {
                    return "����һ������";
                }
                case (3): {
                    return "�������Ч��";
                }
                case (4): {
                    return "���������������˺�";
                }
            }
        } else if (job.equals(getClassName(5))) {
            switch (skill) {
                case (1): {
                    return "����ʹĿ������";
                }
                case (2): {
                    return "�����յ������˺�����������������͵ȡЧ�� ";
                }
                case (3): {
                    return "��Ŀ�����������Χ�˺���������ȼ��Ч��";
                }
                case (4): {
                    return "һ��ʱ���ڹ�������ô�����������������Ч�� ";
                }
            }
        } else if (job.equals(getClassName(6))) {
            switch (skill) {
                case (1): {
                    return "����ʩ��ʹĿ����˼���";
                }
                case (2): {
                    return "�Ե�����ɵ����˺���ʹ���˽��븺��Ч�� ";
                }
                case (3): {
                    return "����ָλ����ɷ�Χ���˲��������ݵĽ���";
                }
                case (4): {
                    return "�н�С������ɱĿ�꣬�����Ŀ����������˺�";
                }
            }
        } else if (job.equals(getClassName(7))) {
            switch (skill) {
                case (1): {
                    return "��Ŀ����ɵ����˺�����ȼĿ��";
                }
                case (2): {
                    return "��Ŀ��������Χ������ӿ���Ч��";
                }
                case (3): {
                    return "�����������Ч�������������˺�����";
                }
                case (4): {
                    return "�����κ��˺�";
                }
            }
        } else if (job.equals(getClassName(8))) {
            switch (skill) {
                case (1): {
                    return "�����ƶ��ٶȺ͹������Լ������ָ�Ч��";
                }
                case (2): {
                    return "��Ŀ����ɵ����˺������ӵ�ȼ������";
                }
                case (3): {
                    return "��һ��ʱ���ڹ�������������ʧ��Ч��";
                }
                case (4): {
                    return "��ɷ�Χ�˺����Լ������͵���Ч��";
                }
            }
        }
        return null;
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
