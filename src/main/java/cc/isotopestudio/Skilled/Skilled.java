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
	public static MainGUI menu;

	@Override
	public void onEnable() {
		getLogger().info("���������ļ���");

		createFile("config");
		// PluginManager pm = this.getServer().getPluginManager();
		// pm.registerEvents(new ReinforceListener(this), this);
		this.getCommand("class").setExecutor(new CommandClass(this));

		createMenu();
		getLogger().info("Skilled �ɹ�����!");
		getLogger().info("Skilled ��ISOTOPE Studio����!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info("Skilled �ɹ�ж��!");
	}

	public void createMenu() {
		menu = new MainGUI("ְҵѡ��", 9, new MainGUI.OptionClickEventHandler() {
			@Override
			public void onOptionClick(MainGUI.OptionClickEvent event) {
				event.getPlayer().sendMessage("��ѡ����" + event.getName());
				event.setWillClose(true);
			}
		}, this).setOption(0, new ItemStack(Material.NETHER_STAR, 1), "˵��", "�ұ��ǿ���ѡ���ְҵ", "�������ɼ���һ��ְҵ")
				.setOption(1, new ItemStack(Material.GLOWSTONE_DUST, 1), "ʥ��", "����1���������ָ�Ŀ������ֵ", "����2���������ָ�Ŀ��ħ��ֵ",
						"����3����ʥ������ٻ����׹�������", "����4������ԴȪ��Ⱥ��ָ�")
				.setOption(2, new ItemStack(Material.HOPPER, 1), "��Ӱ", "����1�����裺���ƶ��ٶȺ���Ծ", "����2��ħ����������ļ������������Ч��",
						"����3�����һ��ʱ�����ӹ�����", "����4�����꣺�ӿ�������һƬ����")
				.setOption(3, new ItemStack(Material.IRON_FENCE, 1), "����", "����1���ᶨ���ƣ��ӿ�����Ѫ��", "����2��ŭ�𣺷���һ�������˺���50",
						"����3��������������� II", "����4���᲻�ɴݣ������������˺�")
				.setOption(4, new ItemStack(Material.REDSTONE, 1), "Ѫŭ", "����1��ѹ�ƣ�����ʹĿ������", "����2���񻯣�������ȼ��������������͵ȡ",
						"����3��ŭ�𣺷�Χʹ�����ܵ��˺���ȼ��", "����4��һ�򵱹أ�һ��ʱ���ڹ���������������������Ч��");
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
			getLogger().info("����ļ�����ʧ�ܣ�");
		}
	}

}
