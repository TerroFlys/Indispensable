package be.chenko.indispensable.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }
        //TODO allow players to have multiple homes, default home should be called 'home'

        // player obj
        Player player = (Player) sender;

        // Save player and his home location




        return true;
    }
}
