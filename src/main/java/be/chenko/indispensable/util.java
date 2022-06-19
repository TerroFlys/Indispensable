package be.chenko.indispensable;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class util {
    public static HashMap<UUID, UUID> tpaFromTo = new HashMap<>();
    public static void sendOnlyPlayerMessage(CommandSender sender){
        sender.sendMessage(ChatColor.RED + "This command is only for players!");
    }
    public static boolean playerinTpaMap(Player player){
        if (tpaFromTo.containsKey(player.getUniqueId())) return true;
        return false;
    }

    public static UUID getReceivingTPAPlayer(Player player){
        UUID uid = null;
        for (UUID uuid: tpaFromTo.values()) {
            if (uuid.equals(player.getUniqueId())) uid = uuid;
        }
        return uid;
    }

    public static void removeTPA(Player player) {
        tpaFromTo.remove(player.getUniqueId());
    }



}
