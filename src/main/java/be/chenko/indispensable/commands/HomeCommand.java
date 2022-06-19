package be.chenko.indispensable.commands;

import be.chenko.indispensable.data.UserDataHandler;
import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        Player player = (Player) sender;
        // check if player has a home set
        UserDataHandler user = new UserDataHandler(player.getPlayer().getUniqueId());
        if (user.HasHome()) {
            player.teleport(user.getHomeLocation());
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Going home!");
        } else {
            player.sendMessage(ChatColor.RED + "You do not have a home yet!");
        }

        // if player has a home tp player there

        // otherwise send player a message (You do not have a home set yet)


        return true;
    }
}
