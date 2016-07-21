/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled;

import cc.isotopestudio.Skilled.command.CommandCSkill;
import cc.isotopestudio.Skilled.command.CommandCbind;
import cc.isotopestudio.Skilled.command.CommandClass;
import cc.isotopestudio.Skilled.command.CommandSkilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.listener.SkilledListener;
import cc.isotopestudio.Skilled.metrics.Metrics;
import cc.isotopestudio.Skilled.task.CooldownResetTask;
import cc.isotopestudio.Skilled.task.MagicRefillTask;
import cc.isotopestudio.Skilled.task.Updater;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Skilled extends JavaPlugin {

    public static final String prefix = (new StringBuilder()).append(ChatColor.GREEN).append("[")
            .append(ChatColor.ITALIC).append(ChatColor.BOLD).append("职业").append(ChatColor.RESET)
            .append(ChatColor.GREEN).append("]").append(ChatColor.RESET).toString();

    public static final String version = "1.1.3a";
    public static Skilled plugin;
    private ProtocolManager protocolManager;

    private void createFile(String name) {
        File file;
        file = new File(getDataFolder(), name + ".yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }
    }

    final static String FileVersion = "1";

    @Override
    public void onEnable() {
        plugin = this;
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
        pm.registerEvents(new SkilledListener(), this);

        this.getCommand("class").setExecutor(new CommandClass());
        this.getCommand("CSkill").setExecutor(new CommandCSkill());
        this.getCommand("Skilled").setExecutor(new CommandSkilled());
        this.getCommand("CBind").setExecutor(new CommandCbind());

        ConfigData.updateConfig(this);

        new MagicRefillTask().runTaskTimer(this, 20, ConfigData.magicRefillRate * 20);
        new Updater().runTaskTimer(this, 20, 60 * 60 * 20);
        new CooldownResetTask().runTaskLater(this, 20);

        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLogger().info("Skilled 成功加载! Version: " + version);
        getLogger().info("Skilled 由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

    public void onReload() {
        ConfigData.updateConfig(this);
        new CooldownResetTask().runTaskLater(this, 20);
    }

    @Override
    public void onDisable() {
        getLogger().info("Skilled 成功卸载!");
    }

    private File dataFile = null;
    private FileConfiguration data = null;

    private void reloadPlayersData() {
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
