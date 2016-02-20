package cc.isotopestudio.Skilled;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Skilled extends JavaPlugin {

	public static final String prefix = (new StringBuilder()).append(ChatColor.GREEN).append("[")
			.append(ChatColor.ITALIC).append(ChatColor.BOLD).append("ְҵ").append(ChatColor.RESET)
			.append(ChatColor.GREEN).append("]").append(ChatColor.RESET).toString();

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
		getLogger().info("���������ļ���");

		createFile("config");
		// PluginManager pm = this.getServer().getPluginManager();
		// pm.registerEvents(new ReinforceListener(this), this);

		getLogger().info("Skilled �ɹ�����!");
		getLogger().info("Skilled ��ISOTOPE Studio����!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info("Skilled �ɹ�ж��!");
	}

}
