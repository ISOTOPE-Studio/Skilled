package cc.isotopestudio.Skilled;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import cc.isotopestudio.Skilled.command.CommandClass;
import cc.isotopestudio.Skilled.gui.MainGUI;

public class Skilled extends JavaPlugin {

	public static final String prefix = (new StringBuilder()).append(ChatColor.GREEN).append("[")
			.append(ChatColor.ITALIC).append(ChatColor.BOLD).append("职业").append(ChatColor.RESET)
			.append(ChatColor.GREEN).append("]").append(ChatColor.RESET).toString();

	public void createFile(String name) {

		File file;
		file = new File(getDataFolder(), name + ".yml");
		if (!file.exists()) {
			saveDefaultConfig();
		}
	}

	String FileVersion = "1";
	public static MainGUI menu;

	@Override
	public void onEnable() {
		getLogger().info("加载配置文件中");

		createFile("config");
		// PluginManager pm = this.getServer().getPluginManager();
		// pm.registerEvents(new ReinforceListener(this), this);
		this.getCommand("class").setExecutor(new CommandClass(this));

		createMenu();
		getLogger().info("Skilled 成功加载!");
		getLogger().info("Skilled 由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info("Skilled 成功卸载!");
	}

	public void createMenu() {
		menu = new MainGUI("职业选择", 9, new MainGUI.OptionClickEventHandler() {
			@Override
			public void onOptionClick(MainGUI.OptionClickEvent event) {
				event.getPlayer().sendMessage("你选择了" + event.getName());
				event.setWillClose(true);
			}
		}, this).setOption(0, new ItemStack(Material.NETHER_STAR, 1), "说明", "右边是可以选择的职业", "单击即可加入一个职业")
				.setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), "圣谕", "技能1：治愈：恢复目标生命值", "技能2：活力：恢复目标魔法值",
						"技能3：神圣打击：召唤天雷攻击敌人", "技能4：生命源泉：群体恢复")
				.setOption(2, new ItemStack(Material.HOPPER, 1), "暗影", "技能1：警惕：加移动速度和跳跃", "技能2：魔法箭：射出的箭附带随机负面效果",
						"技能3：轻语：一定时间增加攻击力", "技能4：箭雨：从空中落下一片箭雨")
				.setOption(3, new ItemStack(Material.IRON_FENCE, 1), "铁卫", "技能1：坚定不移：加抗性与血量", "技能2：怒吼：发出一个火球，伤害：50",
						"技能3：不屈：获得再生 II", "技能4：坚不可摧：三秒内无视伤害")
				.setOption(4, new ItemStack(Material.REDSTONE, 1), "血怒", "技能1：压制：攻击使目标虚弱", "技能2：狂化：自身被点燃，但攻击带生命偷取",
						"技能3：怒火：范围使敌人受到伤害且燃烧", "技能4：一夫当关：一定时间内攻击力大幅提升，获得再生效果");
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
