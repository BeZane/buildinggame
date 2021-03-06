package com.gmail.stefvanschiedev.buildinggame.events.player.voting;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class VoteEvent implements Listener {

	@EventHandler
	public void onVote(PlayerInteractEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getVotingPlot();
		
		if (!player.getInventory().getItemInMainHand().hasItemMeta()) {
			return;
		}
		
		ItemStack item = player.getInventory().getItemInMainHand();

		if (IDDecompiler.getInstance().matches(config.getString("voting.second-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.second-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.second-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (IDDecompiler.getInstance().matches(config.getString("voting.third-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.third-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.third-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (IDDecompiler.getInstance().matches(config.getString("voting.fourth-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.fourth-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.fourth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (IDDecompiler.getInstance().matches(config.getString("voting.fifth-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.fifth-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.fifth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (IDDecompiler.getInstance().matches(config.getString("voting.sixth-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.sixth-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.sixth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (IDDecompiler.getInstance().matches(config.getString("voting.seventh-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.seventh-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.seventh-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (IDDecompiler.getInstance().matches(config.getString("voting.eighth-slot.id"), item) && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.eighth-slot-block")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"))) {
			plot.addVote(new Vote(config.getInt("voting.eighth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else {
			return;
		}
	}
}