package cc.isotopestudio.Skilled.player;

import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;

public class PlayerData {

	private final Skilled plugin;

	public PlayerData(Skilled plugin) {
		this.plugin = plugin;
	}

	public boolean ifHasClass(Player player, String job) {
		return false;
	}
	
	public boolean ifHasSkill(Player player, String job, int skill) {
		return false;
	}

	public int getLevel(Player player, String job, int skill) {
		return -1;
	}

	public void setLevel(Player player, String job, int skill, int level) {

	}

	public String getClass(Player player) {
		return "";
	}

	public void setClass(Player player, String job, int level) {

	}

	public int getSkillPoint(Player player) {
		return 0;
	}

	public void setSkillPoint(Player player, int point) {

	}

	public int getMagic(Player player) {
		return -1;
	}

	public void setMagic(Player player, int magic) {

	}
}
