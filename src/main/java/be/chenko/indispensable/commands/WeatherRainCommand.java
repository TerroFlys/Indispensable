package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherRainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // sender can be a player or console
        // but I have no clue how to get the normal worlds id
        // so check if sender is type player
        if (!(sender instanceof Player) && args.length == 0) {
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Weather set to rain :(");
        player.getWorld().setClearWeatherDuration(0);
        return true;
    }
}
