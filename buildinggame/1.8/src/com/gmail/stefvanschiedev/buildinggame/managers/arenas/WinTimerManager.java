package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.WinTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.WinTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class WinTimerManager {

	public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".win-timer"))
				arenas.set(arena.getName() + ".win-timer", config.getInt("wintimer"));
			
			arena.setWinTimer(new WinTimer(arenas.getInt(arena.getName() + ".win-timer"), arena));
		}
	}
	
	private WinTimerManager() {}
	private static WinTimerManager instance = new WinTimerManager();
	public static WinTimerManager getInstance() {
		return instance;
	}
}