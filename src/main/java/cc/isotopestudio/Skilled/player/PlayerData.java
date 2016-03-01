package cc.isotopestudio.Skilled.player;

import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;

public class PlayerData {

	private final Skilled plugin;

	public PlayerData(Skilled plugin) {
		this.plugin = plugin;
	}

	public boolean ifHasClass(Player player, String job) {
		if (job.equals(plugin.getPlayersData().getString(player.getName() + ".class")))
			return true;
		return false;
	}

	public boolean ifHasSkill(Player player, int skill) {
		if (getLevel(player, skill) <= 0)
			return false;
		return true;
	}

	public int getLevel(Player player, int skill) {
		int level = plugin.getPlayersData().getInt(player.getName() + ".skill" + skill);
		return level;
		// return -1;
	}

	public void setLevel(Player player, int skill, int level) {
		plugin.getPlayersData().set(player.getName() + ".skill" + skill, level);
		plugin.savePlayersData();
	}

	public void addLevel(Player player, int skill) {
		int newLevel = getLevel(player, skill) + 1;
		setLevel(player, skill, newLevel);
	}

	public String getClass(Player player) {
		String job = plugin.getPlayersData().getString(player.getName() + ".class");
		return job;
	}

	public void setClass(Player player, String job) {
		plugin.getPlayersData().set(player.getName() + ".class", job);
		plugin.savePlayersData();
	}

	public int getSkillPoint(Player player) {
		int skillPoint = plugin.getPlayersData().getInt(player.getName() + ".skillPoint");
		return skillPoint;
	}

	public int getSkillPoint(String player) {
		int skillPoint = plugin.getPlayersData().getInt(player + ".skillPoint");
		return skillPoint;
	}

	public void setSkillPoint(Player player, int point) {
		plugin.getPlayersData().set(player.getName() + ".skillPoint", point);
		plugin.savePlayersData();
	}

	public void setSkillPoint(String player, int point) {
		plugin.getPlayersData().set(player + ".skillPoint", point);
		plugin.savePlayersData();
	}

	public void addSkillPoint(Player player, int i) {
		int newSkillPoint = getSkillPoint(player) + i;
		setSkillPoint(player, newSkillPoint);
	}

	public void addSkillPoint(String player, int i) {
		int newSkillPoint = getSkillPoint(player) + i;
		setSkillPoint(player, newSkillPoint);
	}

	public int getMagic(Player player) {
		int magic = plugin.getPlayersData().getInt(player.getName() + ".magic");
		return magic;
	}

	public void setMagic(Player player, int magic) {
		plugin.getPlayersData().set(player.getName() + ".magic", magic);
		plugin.savePlayersData();
	}

	public int getMagic(String player) {
		int magic = plugin.getPlayersData().getInt(player + ".magic");
		return magic;
	}

	public void setMagic(String player, int magic) {
		plugin.getPlayersData().set(player + ".magic", magic);
		plugin.savePlayersData();
	}
}
