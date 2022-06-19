package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
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
        Player player = (Player) sender;

        return true;
    }
}
