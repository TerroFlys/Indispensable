package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpacceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        Player player = (Player) sender;
        if (!util.playerinTpaMap(player)) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "You currently do not have any requests.");
            return true;
        }

        Player originalReqSender = Bukkit.getPlayer(util.getReceivingTPAPlayer(player));

        originalReqSender.sendMessage(ChatColor.AQUA + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has accepted your TPA request!");
        //tp player
        originalReqSender.teleport(player.getLocation());
        player.sendMessage(ChatColor.LIGHT_PURPLE + "You have accepted " + ChatColor.AQUA + originalReqSender.getDisplayName() + "\'s " +
                ChatColor.LIGHT_PURPLE + "tpa request.");

        // removing the request from the MAP
        //No clue if this works without testing on players
        util.removeTPA(originalReqSender);


        return true;
    }
}
