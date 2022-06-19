package be.chenko.indispensable;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class util {
    public static void sendOnlyPlayerMessage(CommandSender sender){
        sender.sendMessage(ChatColor.RED + "This command is only for players!");
    }

}
