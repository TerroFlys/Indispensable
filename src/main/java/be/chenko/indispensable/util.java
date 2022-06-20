package be.chenko.indispensable;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class util {
    public static HashMap<UUID, UUID> tpaFromTo = new HashMap<>();
    public static ArrayList<UUID> dayVoters = new ArrayList<>();
    public static ArrayList<UUID> nightVoters = new ArrayList<>();

    public static boolean uuidInArrayNight(UUID uuid){
        return nightVoters.contains(uuid);
    }
    public static int amountNightVoters(){
        return nightVoters.size();
    }

    public static void addPlayerToVoteNight(UUID uuid){
        nightVoters.add(uuid);
    }
    public static void cleanNightVoters(){
        nightVoters.clear();
    }

    public static boolean uuidInArrayDay(UUID uuid){
        return dayVoters.contains(uuid);
    }
    public static int amountDayVoters(){
        return dayVoters.size();
    }

    public static void addPlayerToVoteDay(UUID uuid){
        dayVoters.add(uuid);
    }
    public static void cleanDayVoters(){
        dayVoters.clear();
    }
    public static void sendOnlyPlayerMessage(CommandSender sender){
        sender.sendMessage(ChatColor.RED + "This command is only for players!");
    }
    public static boolean playerinTpaMap(Player player){
        if (tpaFromTo.containsValue(player.getUniqueId())) return true;
        return false;
    }
    public static UUID getReceivingTPAPlayer(Player player){
        UUID uid = null;
        for (Map.Entry<UUID, UUID> pair : tpaFromTo.entrySet()) {
            if (pair.getValue().equals(player.getUniqueId())){
                uid = pair.getKey();
            }
        }
        return uid;
    }
    public static void removeTPA(Player player) {
        tpaFromTo.remove(player.getUniqueId());
    }



}
