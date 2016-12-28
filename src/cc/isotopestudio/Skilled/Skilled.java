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
import cc.isotopestudio.Skilled.utli.PluginFile;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Skilled extends JavaPlugin {

    public static final String prefix = (new StringBuilder()).append(ChatColor.GREEN).append("[")
            .append(ChatColor.ITALIC).append(ChatColor.BOLD).append("职业").append(ChatColor.RESET)
            .append(ChatColor.GREEN).append("]").append(ChatColor.RESET).toString();

    public static final String version = "1.1.3a";
    public static Skilled plugin;
    private ProtocolManager protocolManager;

    final static String FileVersion = "2";
    public static PluginFile config;
    public static PluginFile playerData;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("加载配置文件中");

        config = new PluginFile(this, "config.yml", "config.yml");
        config.setEditable(false);
        playerData = new PluginFile(this, "playersData.yml");

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


}
