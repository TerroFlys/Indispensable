package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        // sender is a player if we get here
        Player sendingPlayer = (Player) sender;
        if (args.length != 1){
            sendingPlayer.sendMessage(ChatColor.DARK_PURPLE+ "You need to specify the player you want to teleport to.");
            return true;
        }
        Player receivingPlayer = null;
        //check if receiving player exists
        // I wonder what the difference is between getPlayer and getPlayerExact
        // getPlayer returns the closest player to the name you give, more resource consuming.
        // getPlayerExact returns the exact player by the name you give, less resource consuming, and CAN return null.
        // Interesting

        receivingPlayer = Bukkit.getPlayerExact(args[0]);
        if (receivingPlayer == null){
            sendingPlayer.sendMessage(ChatColor.RED+ "Specified player does not exist.");
            return true;
        }



        // Add tpa to the arraylist
        // This should overwrite any other outgoing tpa's
        util.tpaFromTo.put(sendingPlayer.getUniqueId(),receivingPlayer.getUniqueId());
        System.out.println(util.tpaFromTo);
        // text send to the players
        // sending the tpa
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Teleport request sent to " + ChatColor.AQUA + args[0]);
        //receiving tpa
        receivingPlayer.sendMessage(ChatColor.AQUA + sendingPlayer.getDisplayName() + ChatColor.LIGHT_PURPLE + " has wants to teleport to you.");
        receivingPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "Type " + ChatColor.GOLD + "/tpaccept" + ChatColor.LIGHT_PURPLE + " to accept!");




        return true;
    }
}
