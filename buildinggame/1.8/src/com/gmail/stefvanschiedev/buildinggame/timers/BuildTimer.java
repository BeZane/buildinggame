package com.gmail.stefvanschiedev.buildinggame.timers;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDBarApi;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class BuildTimer extends Timer {

	private boolean running = false;
	private int originalSeconds = 0;
	private int seconds = 0;
	private Arena arena;
	
	private YamlConfiguration config = SettingsManager.getInstance().getConfig();
	private YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public BuildTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		this.arena = arena;
		originalSeconds = seconds;
	}
	
	@Override
	public void run() {	
		running = true;
		if (seconds <= 0) {
			//voten
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					Player player = gamePlayer.getPlayer();
					
					player.setGameMode(GameMode.CREATIVE);
					player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				
					//messages
					MessageManager.getInstance().send(player, messages.getStringList("buildingCountdown.time-up.message"));
					
					gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.time-up.title"),
							messages.getString("buildingCountdown.time-up.subtitle"));
				
					if (SDBarApi.getInstance().isEnabled()) {
						if (BarAPI.hasBar(player))
							BarAPI.removeBar(player);
					}
				}
			}
			arena.setState(GameState.VOTING);
			
			//clear spectaters
			for (Plot plot : arena.getPlots()) {
				for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
					if (gamePlayer.getGamePlayerType() == GamePlayerType.SPECTATOR) {
						plot.removeSpectator(gamePlayer);
						gamePlayer.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
						
						MessageManager.getInstance().send(gamePlayer.getPlayer(), ChatColor.GREEN + "Stopped spectating");
					}
				}
			}
			
			arena.getVoteTimer().runTaskTimer(Main.getInstance(), 20L, 20L);
			running = false;
			this.cancel();
			return;
		} else if (seconds % 60 == 0 || seconds == 30 || seconds == 15 || (seconds <= 10 && seconds >= 1)) {
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					Player player = gamePlayer.getPlayer();
					for (String message : messages.getStringList("buildingCountdown.message"))
						MessageManager.getInstance().send(player, message
								.replace("%seconds%", getSeconds() + "")
								.replace("%minutes%", getMinutes() + "")
								.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
								.replace("%seconds_from_minute%", getSecondsFromMinute() + ""));
					gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.title")
							.replace("%seconds%", getSeconds() + "")
							.replace("%minutes%", getMinutes() + "")
							.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
							.replace("%seconds_from_minute%", getSecondsFromMinute() + ""), messages.getString("buildingCountdown.subtitle")
							.replace("%seconds%", getSeconds() + "")
							.replace("%minutes%", getMinutes() + "")
							.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
							.replace("%seconds_from_minute%", getSecondsFromMinute() + ""));
				}
			}
		}
		for (Plot plot : arena.getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player player = gamePlayer.getPlayer();
				
				player.setLevel(getSeconds());
				if (SDBarApi.getInstance().isEnabled()) {
					if (BarAPI.hasBar(player))
						BarAPI.removeBar(player);
					BarAPI.setMessage(player, MessageManager.translate(messages.getString("global.barHeader")
							.replace("%seconds%", getSeconds() + "")
							.replace("%seconds_from_minutes%", getSecondsFromMinute() + "")
							.replace("%minutes%", getMinutes() + "")
							.replace("%subject%", arena.getSubject())), (float) ((float) getSeconds() / originalSeconds) * 100);
				}
			}
		}
		//timings
		try {
			for (String key : config.getConfigurationSection("timings.build-timer.at").getKeys(false)) {
				try {
					if (seconds == Integer.parseInt(key)) {
						for (String command : config.getStringList("timings.build-timer.at." + Integer.parseInt(key)))
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
					}
				} catch (NumberFormatException e) {}
			}
			for (String key : config.getConfigurationSection("timings.build-timer.every").getKeys(false)) {
				try {
					if (seconds % Integer.parseInt(key) == 0) {
						for (String command : config.getStringList("timings.build-timer.every." + Integer.parseInt(key)))
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
					}
				} catch (NumberFormatException e) {}
			}
		} catch (NullPointerException e) {}
		
		seconds--;
	}
	
	@Override
	public int getSeconds() {
		return seconds;
	}
	
	@Override
	public boolean isActive() {
		return running;
	}

	@Override
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}