package cc.isotopestudio.Skilled.message;

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

	public static int getSkillNum(String skill) {
		for (int job = 1; job <= 8; job++) {
			for (int skillNum = 1; skillNum <= 4; skillNum++)
				if (getSkillName(getClassName(job), skillNum).equals(skill)) {
					return skillNum;
				}
		}
		return -1;
	}
}
