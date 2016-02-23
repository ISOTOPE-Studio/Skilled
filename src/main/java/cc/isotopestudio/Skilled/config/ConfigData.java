package cc.isotopestudio.Skilled.config;

import cc.isotopestudio.Skilled.Skilled;

public class ConfigData {

	private final Skilled plugin;

	public static int magicRefillValue = 0;
	public static int magicRefillRate = 0;
	public static int maxMagic = 200;

	public ConfigData(Skilled plugin) {
		this.plugin = plugin;
	}

	public int getUpdateRequiredSkillPoint(String job, int skill) {
		return -1;
	}

	public int getUnlockRequiredSkillPoint(String job, int skill) {
		return -1;
	}

	public static void updateConfig(Skilled plugin) {
		magicRefillRate = plugin.getConfig().getInt("basic.magic.refillRate");
		magicRefillValue = plugin.getConfig().getInt("basic.magic.refillValue");
		maxMagic = plugin.getConfig().getInt("basic.magic.full");
	}

}
