package be.chenko.indispensable.commands;

import be.chenko.indispensable.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class HealEffectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //check if sender/receiver is not a player
        if (!(sender instanceof Player) && args.length == 0) {
            util.sendOnlyPlayerMessage(sender);
            return true;
        }
        Player player = null;
        ////check if user wants to heal himself or others
        if (args.length == 0) player = (Player) sender;
        else{
            player = Bukkit.getServer().getPlayerExact(args[0]);
        }

        if (player == null){
            sender.sendMessage(ChatColor.RED + "Cannot find specified user");
            return true;
        }

        //heal
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        if (args.length > 0) sender.sendMessage(ChatColor.LIGHT_PURPLE + "You have healed " + ChatColor.AQUA + player.getDisplayName());
        //check every potion effect
        // and remove it
        // TODO remove only bad effects
        for (PotionEffect effect: player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }

        player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed, all effects are gone!");



        return true;
    }
}
