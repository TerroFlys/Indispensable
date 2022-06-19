package be.chenko.indispensable.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetspawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player in order to use this command");
            return true;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Setting the world spawn");
        player.getWorld().setSpawnLocation(player.getLocation());
        return true;
    }
}
