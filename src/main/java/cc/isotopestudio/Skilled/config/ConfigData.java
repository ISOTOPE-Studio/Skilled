package cc.isotopestudio.Skilled.config;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Names;

public class ConfigData {

	private final Skilled plugin;

	public static int magicRefillValue = 0;
	public static int magicRefillRate = 0;
	public static int maxMagic = 200;
	private static int[][] unlock;
	private static int[][] upgrade;

	public ConfigData(Skilled plugin) {
		this.plugin = plugin;
	}

	public int getUpgradeRequiredSkillPoint(String job, int skill) {
		int jobNum = Names.getClassNum(job);
		return upgrade[jobNum][skill];
	}

	public int getUnlockRequiredSkillPoint(String job, int skill) {
		int jobNum = Names.getClassNum(job);
		System.out.println(unlock[jobNum][skill] + job + upgrade[jobNum][skill]);
		return unlock[jobNum][skill];
	}

	public static void updateConfig(Skilled plugin) {
		magicRefillRate = plugin.getConfig().getInt("basic.magic.refillRate");
		magicRefillValue = plugin.getConfig().getInt("basic.magic.refillValue");
		maxMagic = plugin.getConfig().getInt("basic.magic.full");
		unlock = new int[9][5];
		upgrade = new int[9][5];
		for (int job = 1; job <= 8; job++) {
			for (int skill = 1; skill <= 4; skill++) {
				unlock[job][skill] = plugin.getConfig().getInt("c" + job + ".s" + skill + ".skillPoint.unlock");
				upgrade[job][skill] = plugin.getConfig().getInt("c" + job + ".s" + skill + ".skillPoint.upgrade");
				System.out.println(unlock[job][skill] + " " + upgrade[job][skill]);
			}
		}
	}

}
