package cc.isotopestudio.Skilled;

import cc.isotopestudio.Skilled.command.CommandCSkill;
import cc.isotopestudio.Skilled.command.CommandCbind;
import cc.isotopestudio.Skilled.command.CommandClass;
import cc.isotopestudio.Skilled.command.CommandSkilled;
import cc.isotopestudio.Skilled.config.ConfigData;
import cc.isotopestudio.Skilled.listener.SkilledListener;
import cc.isotopestudio.Skilled.task.CooldownResetTask;
import cc.isotopestudio.Skilled.task.MagicRefillTask;
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
            .append(ChatColor.ITALIC).append(ChatColor.BOLD).append("ְҵ").append(ChatColor.RESET)
            .append(ChatColor.GREEN).append("]").append(ChatColor.RESET).toString();

    private static final String version = "1.0.3 beta";

    private ProtocolManager protocolManager;

    private void createFile(String name) {

        File file;
        file = new File(getDataFolder(), name + ".yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }
    }

    String FileVersion = "1";

    @Override
    public void onEnable() {
        getLogger().info("���������ļ���");

        createFile("config");

        try {
            getPlayersData().save(dataFile);
        } catch (IOException e) {
            getLogger().info("����ļ�����");
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

        new MagicRefillTask(this).runTaskTimer(this, 20, ConfigData.magicRefillRate * 20);
        new CooldownResetTask(this).runTaskLater(this, 20);
        getLogger().info("Skilled �ɹ�����! Version: " + version);
        getLogger().info("Skilled ��ISOTOPE Studio����!");
        getLogger().info("http://isotopestudio.cc");
    }

    public void onReload() {
        ConfigData.updateConfig(this);
        new CooldownResetTask(this).runTaskLater(this, 20);
    }

    @Override
    public void onDisable() {
        getLogger().info("Skilled �ɹ�ж��!");
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
            getLogger().info("����ļ�����ʧ�ܣ�");
        }
    }

}
