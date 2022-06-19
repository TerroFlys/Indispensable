package be.chenko.indispensable;

import be.chenko.indispensable.commands.HomeCommand;
import be.chenko.indispensable.commands.SetspawnCommand;
import be.chenko.indispensable.commands.SpawnCommand;
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
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("setspawn").setExecutor(new SetspawnCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
