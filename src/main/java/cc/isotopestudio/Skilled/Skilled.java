package cc.isotopestudio.Skilled;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import cc.isotopestudio.Skilled.command.CommandCSkill;
import cc.isotopestudio.Skilled.command.CommandCbind;
import cc.isotopestudio.Skilled.command.CommandClass;
import cc.isotopestudio.Skilled.command.CommandSkilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.listener.SkilledListener;
import cc.isotopestudio.Skilled.task.CooldownResetTask;
import cc.isotopestudio.Skilled.task.MagicRefillTask;

public class Skilled extends JavaPlugin {

	public static final String prefix = (new StringBuilder()).append(ChatColor.GREEN).append("[")
			.append(ChatColor.ITALIC).append(ChatColor.BOLD).append("职业").append(ChatColor.RESET)
			.append(ChatColor.GREEN).append("]").append(ChatColor.RESET).toString();
	
	public ProtocolManager protocolManager;

	public void createFile(String name) {

		File file;
		file = new File(getDataFolder(), name + ".yml");
		if (!file.exists()) {
			saveDefaultConfig();
		}
	}

	String FileVersion = "1";

	@Override
	public void onEnable() {
		getLogger().info("加载配置文件中");

		createFile("config");

		try {
			getPlayersData().save(dataFile);
		} catch (IOException e) {
			getLogger().info("玩家文件出错！");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		protocolManager = ProtocolLibrary.getProtocolManager();

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new SkilledListener(this), this);

		this.getCommand("class").setExecutor(new CommandClass(this));
		this.getCommand("CSkill").setExecutor(new CommandCSkill(this));
		this.getCommand("Skilled").setExecutor(new CommandSkilled(this));
		this.getCommand("CBind").setExecutor(new CommandCbind(this));

		ConfigData.updateConfig(this);

		BukkitTask task1 = new MagicRefillTask(this).runTaskTimer(this, 20, ConfigData.magicRefillRate * 20);
		BukkitTask task2 = new CooldownResetTask(this).runTaskLater(this, 20);
		getLogger().info("Skilled 成功加载!");
		getLogger().info("Skilled 由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	public void onReload() {
		ConfigData.updateConfig(this);
		BukkitTask task2 = new CooldownResetTask(this).runTaskLater(this, 20);
	}

	@Override
	public void onDisable() {
		getLogger().info("Skilled 成功卸载!");
	}

	private File dataFile = null;
	private FileConfiguration data = null;

	public void reloadPlayersData() {
		if (dataFile == null) {
			dataFile = new File(getDataFolder(), "playersData.yml");
		}
		data = YamlConfiguration.loadConfiguration(dataFile);
	}

	public FileConfiguration getPlayersData() {
		if (data == null) {
			reloadPlayersData();
		}
		return data;
	}

	public void savePlayersData() {
		if (data == null || dataFile == null) {
			return;
		}
		try {
			getPlayersData().save(dataFile);
		} catch (IOException ex) {
			getLogger().info("玩家文件保存失败！");
		}
	}

}
