package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //check if receiver is not a player
        if (!(sender instanceof Player) && args.length == 0) {
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        //init player var
        Player player = null;
        ////check if user wants to make himself or someone else god
        if (args.length == 0) player = (Player) sender;
        else{
            player = Bukkit.getServer().getPlayerExact(args[0]);
        }
        if (player == null){
            sender.sendMessage(ChatColor.RED + "Cannot find specified user");
            return true;
        }

        // give/remove fly
        if (!player.getAllowFlight()) {
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Enabling fly mode.");
        }
        else{
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Disabling fly mode.");
        }


        return true;
    }
}
