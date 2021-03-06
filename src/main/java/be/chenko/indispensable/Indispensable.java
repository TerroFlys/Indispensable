package be.chenko.indispensable;

import be.chenko.indispensable.commands.*;
import be.chenko.indispensable.listeners.PlayerJoinEventListener;
import be.chenko.indispensable.listeners.TickListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Indispensable extends JavaPlugin {
    public static String PLUGIN_ID = "Indispensable";
    public static Logger LOGGER = LoggerFactory.getLogger(PLUGIN_ID);
    @Override
    public void onEnable() {
        // Plugin startup logic
        LOGGER.info(String.format("[%s] " + "Starting up", PLUGIN_ID));
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("sethome").setExecutor(new SetHomeCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("setspawn").setExecutor(new SetspawnCommand());
        this.getCommand("god").setExecutor(new GodCommand());
        this.getCommand("tpa").setExecutor(new TpaCommand());
        this.getCommand("tpaccept").setExecutor(new TpacceptCommand());
        this.getCommand("tpdeny").setExecutor(new TpdenyCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("healeffect").setExecutor(new HealEffectCommand());
        this.getCommand("voteday").setExecutor(new VoteDayCommand());
        this.getCommand("votenight").setExecutor(new VoteNightCommand());
        this.getCommand("sun").setExecutor(new WeatherSunCommand());
        this.getCommand("rain").setExecutor(new WeatherRainCommand());
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("gm").setExecutor(new GameModeCommand());
        this.getCommand("warp").setExecutor(new WarpCommand());
        this.getCommand("setwarp").setExecutor(new SetWarpCommand());
        this.getCommand("delwarp").setExecutor(new DelWarpCommand());
        this.getCommand("warplist").setExecutor(new ListWarpsCommand());
        this.getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(),this);
        this.getServer().getPluginManager().registerEvents(new TickListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
