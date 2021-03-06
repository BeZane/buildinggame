package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatSign;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

public class SignManager {

	private SignManager() {}
	
	private static SignManager instance = new SignManager();
	
	public static SignManager getInstance() {
		return instance;
	}
	
	private List<Sign> leaveSigns = new ArrayList<>();
	private List<StatSign> statSigns = new ArrayList<>();
	
	public void setup() {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			arena.getSigns().clear();
		}
		
		for (String string : signs.getKeys(false)) {
			//location check
			Location location = new Location(Bukkit.getWorld(signs.getString(string + ".world")),
					signs.getInt(string + ".x"),
					signs.getInt(string + ".y"),
					signs.getInt(string + ".z"));
			if (!(location.getBlock().getState() instanceof Sign)) {
				signs.set(string, null);
				continue;
			}
			
			Sign sign = (Sign) location.getBlock().getState();
			
			if (!signs.contains(string + ".type"))
				signs.set(string + ".type", "join");
			
			if (signs.getString(string + ".type").equals("join")) {
				Arena arena = ArenaManager.getInstance().getArena(signs.getString(string + ".arena"));
			
				if (arena == null) {
					signs.set(string, null);
					continue;
				}
			
				arena.addSign(sign);
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found join sign for arena " + arena.getName());
			} else if (signs.getString(string + ".type").equals("leave")) {
				leaveSigns.add(sign);
				
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found leave sign");
			} else if (signs.getString(string + ".type").equals("stat")) {
				statSigns.add(new StatSign(sign, StatType.valueOf(signs.getString(string + ".stat")),
						Integer.parseInt(signs.getString(string + ".number"))));
				
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found stat sign");
			}
		}
		updateSigns();
		
		SettingsManager.getInstance().save();
	}
	
	public void updateSigns() {
		updateStatSigns();
		updateLeaveSigns();
		updateJoinSigns();
	}
	
	public void updateJoinSigns() {
		for (Arena arena : ArenaManager.getInstance().getArenas())
			updateJoinSigns(arena);
	}
	
	public void updateJoinSigns(Arena arena) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Sign sign : arena.getSigns()) {
			//get design
			String line1 = messages.getString("signs.join.line-1");
			String line2 = messages.getString("signs.join.line-2");
			String line3 = messages.getString("signs.join.line-3");
			String line4 = messages.getString("signs.join.line-4");
				
			sign.setLine(0, MessageManager.translate(line1
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", messages.getString("variables.join-sign.status." + arena.getState().toString().toLowerCase()))));
			sign.setLine(1, MessageManager.translate(line2
					.replace("%:a%", "�")
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", messages.getString("variables.join-sign.status." + arena.getState().toString().toLowerCase()))));
			sign.setLine(2, MessageManager.translate(line3
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", messages.getString("variables.join-sign.status." + arena.getState().toString().toLowerCase()))));
			sign.setLine(3, MessageManager.translate(line4
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", messages.getString("variables.join-sign.status." + arena.getState().toString().toLowerCase()))));
			sign.update();	
		}
	}
	
	public void updateLeaveSigns() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Sign sign : leaveSigns) {
			sign.setLine(0, MessageManager.translate(messages.getString("signs.leave.line-1")));
			sign.setLine(1, MessageManager.translate(messages.getString("signs.leave.line-2")));
			sign.setLine(2, MessageManager.translate(messages.getString("signs.leave.line-3")));
			sign.setLine(3, MessageManager.translate(messages.getString("signs.leave.line-4")));
			sign.update();
		}
	}
	
	public void updateStatSigns() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (StatSign sign : statSigns) {
			Sign s = sign.getSign();
			
			if (config.getBoolean("stats.enable")) {
				String line1 = MessageManager.translate(messages.getString("signs.stat." + sign.getType().toString().toLowerCase() + ".line-1"));
				String line2 = MessageManager.translate(messages.getString("signs.stat." + sign.getType().toString().toLowerCase() + ".line-2"));
				String line3 = MessageManager.translate(messages.getString("signs.stat." + sign.getType().toString().toLowerCase() + ".line-3"));
				String line4 = MessageManager.translate(messages.getString("signs.stat." + sign.getType().toString().toLowerCase() + ".line-4"));
			
				Map<OfflinePlayer, Integer> stats = new HashMap<>();
				
				for (Stat stat : StatManager.getInstance().getStats(sign.getType()))
					stats.put(stat.getPlayer(), stat.getValue());
				
				List<Integer> values = new ArrayList<>(stats.values());
				Collections.sort(values);
				Collections.reverse(values);
				
				int value = -1;
				
				if (values.size() >= sign.getNumber())
					value = values.get(sign.getNumber() - 1);
				
				OfflinePlayer player = null;
				
				for (OfflinePlayer op : stats.keySet()) {
					if (stats.get(op) == value)
						player = op;
				}
				
				s.setLine(0, line1
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%", player == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
				s.setLine(1, line2
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%", player == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
				s.setLine(2, line3
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%", player == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
				s.setLine(3, line4
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%", player == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
			} else {
				s.setLine(0, "");
				s.setLine(1, ChatColor.RED + "Stats are");
				s.setLine(2, ChatColor.RED + "disabled");
				s.setLine(3, "");
			}
			
			s.update(true);
		}
	}
	
	public List<Sign> getLeaveSigns() {
		return leaveSigns;
	}
	
	public List<StatSign> getStatSigns() {
		return statSigns;
	}
}