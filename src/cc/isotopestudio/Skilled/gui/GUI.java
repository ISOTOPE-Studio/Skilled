package cc.isotopestudio.Skilled.gui;

import cc.isotopestudio.Skilled.Skilled;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public abstract class GUI implements Listener {

    // From: https://bukkit.org/threads/icon-menu.108342

    final String name;
    final int size;
    private Plugin plugin;
    String[] optionNames;
    ItemStack[] optionIcons;
    private final boolean willDestory;

    GUI(String name) {
        this.name = name + getPassword();
        this.size = 9;
        this.plugin = Skilled.plugin;
        this.optionNames = new String[9];
        this.optionIcons = new ItemStack[9];
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        willDestory = true;
    }

    GUI setOption(int position, ItemStack icon, String name, String... info) {
        optionNames[position] = name;
        optionIcons[position] = setItemNameAndLore(icon, name, info);
        return this;
    }

    public void open(Player player) {
        Inventory inventory = Bukkit.createInventory(player, size, name);
        for (int i = 0; i < optionIcons.length; i++) {
            if (optionIcons[i] != null) {
                inventory.setItem(i, optionIcons[i]);
            }
        }
        player.openInventory(inventory);
    }

    private void Destory() {
        HandlerList.unregisterAll(this);
        plugin = null;
        optionNames = null;
        optionIcons = null;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent event) {

    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getTitle().equals(name)) {
            if (willDestory) {
                Destory();
            }
        }
    }

    private ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore) {
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        im.setLore(Arrays.asList(lore));
        item.setItemMeta(im);
        return item;
    }

    private static String getPassword() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += ChatColor.values()[(int) (Math.random() * 20)];
        }
        return result;

    }
}