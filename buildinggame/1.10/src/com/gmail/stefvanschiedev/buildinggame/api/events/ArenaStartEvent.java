package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ArenaStartEvent extends Event implements Cancellable {

	private Arena arena;
	private boolean cancel;
	private static final HandlerList HANDLERS = new HandlerList();
	
	public ArenaStartEvent(Arena arena) {
		this.arena = arena;
		this.cancel = false;
	}
	
	public Arena getArena() {
		return arena;
	}

	@Override
	public boolean isCancelled() {
		return cancel;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}