package be.chenko.indispensable.commands;

import be.chenko.indispensable.data.WarpDataHandler;
import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        Player player = (Player) sender;
        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Wrong usage of the warp command!");
            return false;
        }
        WarpDataHandler warp = new WarpDataHandler();
        if (!(warp.warpExists(args[0]))){
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Warp "+ChatColor.AQUA + args[0] + ChatColor.LIGHT_PURPLE + " not found!");
            return true;
        }
        player.teleport(warp.getWarpLocation(args[0]));
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting to "+ChatColor.AQUA+args[0]+ChatColor.LIGHT_PURPLE+"!");



        return true;
    }
}
