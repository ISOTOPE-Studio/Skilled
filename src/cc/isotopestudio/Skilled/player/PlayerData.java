package cc.isotopestudio.Skilled.player;

import cc.isotopestudio.Skilled.Skilled;
import org.bukkit.entity.Player;

public class PlayerData {

    private final Skilled plugin;

    public PlayerData(Skilled plugin) {
        this.plugin = plugin;
    }

    public boolean ifHasClass(Player player, String job) {
        return job.equals(plugin.getPlayersData().getString(player.getName() + ".class"));
    }

    public boolean ifHasSkill(Player player, int skill) {
        return getLevel(player, skill) > 0;
    }

    public int getLevel(Player player, int skill) {
        return plugin.getPlayersData().getInt(player.getName() + ".skill" + skill);
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
        return plugin.getPlayersData().getString(player.getName() + ".class");
    }

    public void setClass(Player player, String job) {
        plugin.getPlayersData().set(player.getName() + ".class", job);
        plugin.savePlayersData();
    }

    public int getSkillPoint(Player player) {
        return plugin.getPlayersData().getInt(player.getName() + ".skillPoint");
    }

    private int getSkillPoint(String player) {
        return plugin.getPlayersData().getInt(player + ".skillPoint");
    }

    public void setSkillPoint(Player player, int point) {
        plugin.getPlayersData().set(player.getName() + ".skillPoint", point);
        plugin.savePlayersData();
    }

    private void setSkillPoint(String player, int point) {
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
        return plugin.getPlayersData().getInt(player.getName() + ".magic");
    }

    public void setMagic(Player player, int magic) {
        plugin.getPlayersData().set(player.getName() + ".magic", magic);
        plugin.savePlayersData();
    }

    public void decreaseMagic(Player player, int magic) {
        int newMagic = getMagic(player) - magic;
        setMagic(player, newMagic);
        plugin.savePlayersData();
    }

    public int getMagic(String player) {
        return plugin.getPlayersData().getInt(player + ".magic");
    }

    public void setMagic(String player, int magic) {
        plugin.getPlayersData().set(player + ".magic", magic);
        plugin.savePlayersData();
    }

    public boolean isCooldown(Player player, int skill) {
        return plugin.getPlayersData().getBoolean(player.getName() + ".cooldown." + skill, false);
    }

    public void setCooldown(Player player, int skill, boolean isCooldown) {
        plugin.getPlayersData().set(player.getName() + ".cooldown." + skill, isCooldown);
        plugin.savePlayersData();
    }

    public void setCooldown(String player, int skill, boolean isCooldown) {
        plugin.getPlayersData().set(player + ".cooldown." + skill, isCooldown);
        plugin.savePlayersData();
    }
}
