package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println("amount of arguments"+args.length);
        //check if sender/receiver is not a player
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
            if (sender instanceof Player) sender.sendMessage(ChatColor.RED + "Cannot find specified user");
            else sender.sendMessage("Cannot find specified user");
            return true;
        }

        // give/remove god
        if (!player.isInvulnerable()) {
            player.setInvulnerable(true);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Enabling god mode.");
        }
        else{
            player.setInvulnerable(false);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Disabling god mode.");
        }


        return true;
    }
}
