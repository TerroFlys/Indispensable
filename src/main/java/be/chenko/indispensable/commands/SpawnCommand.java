package be.chenko.indispensable.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static be.chenko.indispensable.Indispensable.LOGGER;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        // convert the sender into a player
        Player player = (Player) sender;
        // text to notify the player
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Going to spawn!");
        // goes to the player spawn location
        //TODO custom spawn location, not the world spawn but something saved in a config
        Location loc = player.getWorld().getSpawnLocation();
        player.teleport(loc);
        return true;
    }

}
