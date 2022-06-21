package be.chenko.indispensable.commands;

import be.chenko.indispensable.data.WarpDataHandler;
import be.chenko.indispensable.models.Warp;
import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        //init player
        Player player = (Player) sender;
        //if player has not given correct amount of arguments, currently only the name
        // in the future maybe cooldown
        if (args.length != 1){
            player.sendMessage(ChatColor.RED + "Wrong usage of this command.");
            return false;
        }
        Warp warp = new Warp(player.getLocation(), args[0]);

        WarpDataHandler warpDataHandler = new WarpDataHandler();
        warpDataHandler.createWarp(warp);


        player.sendMessage(ChatColor.LIGHT_PURPLE + "Set warp " + ChatColor.AQUA +args[0]+ ChatColor.LIGHT_PURPLE + ".");
        return true;
    }
}
