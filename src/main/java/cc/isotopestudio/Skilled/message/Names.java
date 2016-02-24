package cc.isotopestudio.Skilled.message;

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
