package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1 || args.length > 2 ){
            sender.sendMessage(ChatColor.DARK_PURPLE + "Wrong usage of this command!");
            sender.sendMessage(ChatColor.DARK_PURPLE + "Usage: /gm <mode> <player> ");
            return true;
        }
        // Console can use this command on a player, only when specifying a player
        if (!(sender instanceof Player) && args.length < 2) {
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        //create player
        Player player = (Player) sender;
        // check receiving player
        if (args.length == 1) player = (Player) sender;
        else{
            //Player is at pos 1, the second argument
            player = Bukkit.getServer().getPlayerExact(args[1]);
        }
        if (player == null){
            sender.sendMessage(ChatColor.RED + "Cannot find specified user");
            return true;
        }

        //Make player said gamemode
        if (args[0].toLowerCase().matches("0|1|2|3|survival|creative|adventure|spectator|s|c|a|spec")){
            if (args.length > 1) sender.sendMessage(ChatColor.LIGHT_PURPLE + "Changing " + ChatColor.AQUA +
                    args[1] + "\'s" + ChatColor.LIGHT_PURPLE + " gamemode to " + ChatColor.AQUA + args[0] +ChatColor.LIGHT_PURPLE + ".");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Changing Gamemode to " + ChatColor.AQUA + args[0]);
        }else {
            sender.sendMessage(ChatColor.DARK_PURPLE+"Gamemode not recognised.");
            return true;
        }
        if (args[0].toLowerCase().matches("0|s|survival")){
            player.setGameMode(GameMode.SURVIVAL);
        } else if (args[0].toLowerCase().matches("1|c|creative")){
            player.setGameMode(GameMode.CREATIVE);
        }else if (args[0].toLowerCase().matches("3|spec|spectator")){
            player.setGameMode(GameMode.SPECTATOR);
        }else{
            // only Adventure mode left
            //this one stays last, because almost noone uses this
            player.setGameMode(GameMode.ADVENTURE);
        }




        return true;
    }
}
