package be.chenko.indispensable.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            // check if player has a home set

            // if player has a home tp player there

            // otherwise send player a message (You do not have a home set yet)
        }
        return true;
    }
}
