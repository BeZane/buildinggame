package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.commands.third;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Add extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify a command");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		String command = "";
		for (String arg : args) {
			command += arg + " ";
		}
		command = command.trim();
		
		config.set("commands.third", config.getStringList("commands.third").add(command));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Added " + command + " command!");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "add";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Add a command to the third commands";
	}

	@Override
	public String getPermission() {
		return "bg.setting.commands.third.add";
	}
}