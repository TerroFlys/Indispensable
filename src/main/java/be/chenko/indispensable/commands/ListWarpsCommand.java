package be.chenko.indispensable.commands;

import be.chenko.indispensable.data.WarpDataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListWarpsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        WarpDataHandler warp = new WarpDataHandler();
        warp.getWarpList();
        return true;
    }
}
