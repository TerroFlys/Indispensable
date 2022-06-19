package be.chenko.indispensable.listeners;

import be.chenko.indispensable.data.UserDataHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEventListener implements Listener {
    @EventHandler
    public void joincreateuser(org.bukkit.event.player.PlayerJoinEvent e)
    {
        UserDataHandler user = new UserDataHandler(e.getPlayer().getUniqueId());

        user.createUser(e.getPlayer());
    }
}
