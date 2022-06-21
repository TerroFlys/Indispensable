package be.chenko.indispensable.commands;

import be.chenko.indispensable.data.WarpDataHandler;
import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //this command could be used by console as no location is needed
        if (args.length != 1){
            sender.sendMessage(ChatColor.RED + "Wrong usage of this command.");
            return false;
        }
        //remove warp
        WarpDataHandler warpDataHandler = new WarpDataHandler();
        warpDataHandler.removeWarp(args[0]);

        //remove message
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Warp " + ChatColor.AQUA + args[0] + ChatColor.LIGHT_PURPLE + " removed.");


        return true;
    }
}
