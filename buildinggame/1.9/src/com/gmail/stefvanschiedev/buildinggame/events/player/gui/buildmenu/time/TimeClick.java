package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.TimeMenu;

public class TimeClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		if (!inventory.getName().equals(messages.getString("gui.options-title")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			return;
		}
		
		if (e.getCurrentItem() == null) {
			return;
		}
		
		ItemStack currentItem = e.getCurrentItem();
		
		if (!IDDecompiler.getInstance().matches(config.getString("gui.time.id"), currentItem))
			return;
		
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(messages.getString("gui.time.name")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			return;
		}
		
		TimeMenu menu = new TimeMenu();
		menu.show(player);
		e.setCancelled(true);
	}
}