package be.chenko.indispensable.listeners;

import be.chenko.indispensable.util;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TickListener implements Listener {
    //I wanted to do per tick but this will do for now
    @EventHandler
    public void perTickHandler(PlayerMoveEvent e){
        //Check to change day/night

        if (e.getPlayer().getServer().getOnlinePlayers().size() > 0 ) {
            //dayvote
            if (util.amountDayVoters() > Math.floor(e.getPlayer().getServer().getOnlinePlayers().size()/3)){
                e.getPlayer().getWorld().setTime(0);
                e.getPlayer().getServer().broadcastMessage(( ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Time set to day!"));
                util.cleanDayVoters();
            }
            //nightvote
            if (util.amountNightVoters() > Math.floor(e.getPlayer().getServer().getOnlinePlayers().size()/3)){
                e.getPlayer().getWorld().setTime(13000);
                e.getPlayer().getServer().broadcastMessage(( ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Time set to night!"));
                util.cleanNightVoters();
            }


        }
    }
}
