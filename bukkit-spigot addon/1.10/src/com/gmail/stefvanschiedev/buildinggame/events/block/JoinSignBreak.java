package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

public class JoinSignBreak implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		Block block = e.getBlock();
		
		if (!(block.getState() instanceof Sign)) {
			return;
		}
		
		Sign sign = (Sign) block.getState();
		
		for (String string : signs.getKeys(false)) {
			if (signs.getString(string + ".world") != sign.getLocation().getWorld().getName())
				continue;
			if (signs.getInt(string + ".x") != sign.getLocation().getBlockX())
				continue;
			if (signs.getInt(string + ".y") != sign.getLocation().getBlockY())
				continue;
			if (signs.getInt(string + ".z") != sign.getLocation().getBlockZ())
				continue;
			SettingsManager.getInstance().save();

			signs.set(string, null);
		}
	}
}