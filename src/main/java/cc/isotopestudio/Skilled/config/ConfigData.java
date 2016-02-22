package cc.isotopestudio.Skilled.config;

import cc.isotopestudio.Skilled.Skilled;

public class ConfigData {

	private final Skilled plugin;

	public ConfigData(Skilled plugin) {
		this.plugin = plugin;
	}

	public int getUpdateRequiredSkillPoint(String job, int skill){
		return -1;
	}
	
	public int getUnlockRequiredSkillPoint(String job, int skill){
		return -1;
	}

}
