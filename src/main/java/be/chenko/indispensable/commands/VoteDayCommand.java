package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteDayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // this command is only for players, if you are the console you can just type /time set x
        if (!(sender instanceof Player)){
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        //sender is player
        Player player = (Player) sender;
        if (util.uuidInArrayDay(player.getUniqueId())){
            player.sendMessage(ChatColor.DARK_PURPLE + "You have already voted.");
            return true;
        }
        player.sendMessage(ChatColor.LIGHT_PURPLE + "You have voted for "+ChatColor.AQUA+"day"+ChatColor.LIGHT_PURPLE+"!");
        util.addPlayerToVoteDay(player.getUniqueId());
        return true;
    }
}
