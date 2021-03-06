package com.gmail.stefvanschiedev.buildinggame.api.events;

import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.gmail.stefvanschiedev.buildinggame.api.Win;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;

public class PlayerWinEvent extends Event {

	private Arena arena;
	private static final HandlerList HANDLERS = new HandlerList();
	private List<GamePlayer> players;
	private Win win;
	
	public PlayerWinEvent(Arena arena, List<GamePlayer> players, Win win) {
		this.arena = arena;
		this.players = players;
		this.win = win;
	}

	public Arena getArena() {
		return arena;
	}
	
	public List<GamePlayer> getPlayers() {
		return players;
	}
	
	public Win getWin() {
		return win;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}