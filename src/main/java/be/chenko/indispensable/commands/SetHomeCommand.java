package be.chenko.indispensable.commands;

import be.chenko.indispensable.data.UserDataHandler;
import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        //TODO allow players to have multiple homes, default home should be called 'home'

        // player obj
        Player player = (Player) sender;
        // Save player and his home location

        UserDataHandler user = new UserDataHandler(player.getPlayer().getUniqueId());
        user.setHome(player.getLocation());
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Home set!");

        return true;
    }
}
