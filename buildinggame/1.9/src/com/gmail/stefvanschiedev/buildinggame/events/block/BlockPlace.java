package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class BlockPlace implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getPlot(player);
		
		if (plot.getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Spectators can't build");
			e.setCancelled(true);
			return;
		}
		
		if (arena.getState() != GameState.BUILDING) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can not build right now");
			e.setCancelled(true);
			return;
		}
		
		if (!plot.getBoundary().isInside(e.getBlock().getLocation())) {
			MessageManager.getInstance().send(player, messages.getStringList("in-game.build-out-bounds"));
			e.setCancelled(true);
			return;
		}
		
		for (String material : config.getStringList("blocks.blocked")) {
			if (IDDecompiler.getInstance().matches(material, e.getBlock())) {
				e.setCancelled(true);
				break;
			}
		}
	}
}