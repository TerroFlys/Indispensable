package be.chenko.indispensable;

import be.chenko.indispensable.commands.*;
import be.chenko.indispensable.listeners.PlayerJoinEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Indispensable extends JavaPlugin {
    public static String PLUGIN_ID = "Indispensable";
    public static Logger LOGGER = LoggerFactory.getLogger(PLUGIN_ID);
    @Override
    public void onEnable() {
        // Plugin startup logic
        LOGGER.info("Starting up");
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("sethome").setExecutor(new SetHomeCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("setspawn").setExecutor(new SetspawnCommand());
        this.getCommand("god").setExecutor(new GodCommand());
        this.getCommand("tpa").setExecutor(new TpaCommand());
        this.getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(),this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
