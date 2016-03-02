package cc.isotopestudio.Skilled.config;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import cc.isotopestudio.Skilled.Skilled;
import cc.isotopestudio.Skilled.message.Names;
import cc.isotopestudio.Skilled.player.PlayerData;

public class ConfigData {

	public static int magicRefillValue = 0;
	public static int magicRefillRate = 0;
	public static int maxMagic = 200;
	private static int[][] unlock;
	private static int[][] upgrade;
	private static int[][] magic;
	private static int[][] cooldown;

	public static int getUpgradeRequiredSkillPoint(String job, int skill) {
		int jobNum = Names.getClassNum(job);
		return upgrade[jobNum][skill];
	}

	public static int getUnlockRequiredSkillPoint(String job, int skill) {
		int jobNum = Names.getClassNum(job);
		return unlock[jobNum][skill];
	}

	public static int getRequiredMagic(String job, int skill) {
		int jobNum = Names.getClassNum(job);
		return magic[jobNum][skill];
	}

	public static int getCooldown(String job, int skill) {
		int jobNum = Names.getClassNum(job);
		return cooldown[jobNum][skill];
	}
	
	public static void updateConfig(Skilled plugin) {
		magicRefillRate = plugin.getConfig().getInt("basic.magic.refillRate");
		magicRefillValue = plugin.getConfig().getInt("basic.magic.refillValue");
		maxMagic = plugin.getConfig().getInt("basic.magic.full");
		unlock = new int[9][5];
		upgrade = new int[9][5];
		magic = new int[9][5];
		cooldown = new int[9][5];
		for (int job = 1; job <= 8; job++) {
			for (int skill = 1; skill <= 4; skill++) {
				unlock[job][skill] = plugin.getConfig().getInt("c" + job + ".s" + skill + ".skillPoint.unlock");
				upgrade[job][skill] = plugin.getConfig().getInt("c" + job + ".s" + skill + ".skillPoint.upgrade");
				magic[job][skill] = plugin.getConfig().getInt("c" + job + ".s" + skill + ".release.magic");
				cooldown[job][skill] = plugin.getConfig().getInt("c" + job + ".s" + skill + ".release.cooldown");
				System.out.println(unlock[job][skill] + " " + upgrade[job][skill] + " " + magic[job][skill]);
			}
		}
		
	}

}
