package com.gmail.stefvanschiedev.buildinggame.managers.messages;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class MessageManager {

	private MessageManager() {}
	
	private static MessageManager instance = new MessageManager();
	
	public static MessageManager getInstance() {
		return instance;
	}
	
	public void send(CommandSender sender, String message) {
		if (message.equals("")) {
			return;
		}
		
		sender.sendMessage(SettingsManager.getInstance().getMessages().getString("global.prefix")
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�") + message
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"));
	}
	
	public void send(CommandSender sender, List<String> messages) {
		for (String message : messages) {
			if (message.equals("")) {
				return;
			}
		
			sender.sendMessage(SettingsManager.getInstance().getMessages().getString("global.prefix")
					.replace("%:a%", "�")
					.replace("%:e%", "�")
					.replace("%:i%", "�")
					.replace("%:o%", "�")
					.replace("%:u%", "�")
					.replace("%ss%", "�")
					.replaceAll("&", "�") + message
					.replace("%:a%", "�")
					.replace("%:e%", "�")
					.replace("%:i%", "�")
					.replace("%:o%", "�")
					.replace("%:u%", "�")
					.replace("%ss%", "�")
					.replaceAll("&", "�"));
		}
	}
	
	public void sendWithoutPrefix(CommandSender sender, String message) {
		if (message.equals("")) {
			return;
		}
		
		sender.sendMessage(message
				.replace("%:a%", "�")
				.replace("%:e%", "�")
				.replace("%:i%", "�")
				.replace("%:o%", "�")
				.replace("%:u%", "�")
				.replace("%ss%", "�")
				.replaceAll("&", "�"));
	}
	
	public void sendWithoutPrefix(CommandSender sender, List<String> messages) {
		for (String message : messages) {
			if (message.equals("")) {
				return;
			}
			
			sender.sendMessage(message
					.replace("%:a%", "�")
					.replace("%:e%", "�")
					.replace("%:i%", "�")
					.replace("%:o%", "�")
					.replace("%:u%", "�")
					.replace("%ss%", "�")
					.replaceAll("&", "�"));
		}
	}
}