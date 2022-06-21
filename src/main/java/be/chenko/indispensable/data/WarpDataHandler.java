package be.chenko.indispensable.data;

import be.chenko.indispensable.models.Warp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

import static be.chenko.indispensable.Indispensable.LOGGER;

public class WarpDataHandler implements Listener {
    File warpFile;
    FileConfiguration warpConfig;

    public WarpDataHandler() {
        warpFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Indispensable").getDataFolder(), "warps" + ".yml");
        warpConfig = YamlConfiguration.loadConfiguration(warpFile);
    }

    // check if warp exists
    public Boolean warpExists(String warpName) {
        if (!(warpFile.exists())) return false;
        return warpConfig.get("warps."+warpName) != null;
    }

    public void setWarp(Warp warp) {

        // just to be sure if that the file exists
        if (!(warpFile.exists())) return;
        // home with original name
        YamlConfiguration UserConfig = YamlConfiguration.loadConfiguration(warpFile);
        UserConfig.set("warps." + warp.getName(), warp.getLocation());
        try {
            UserConfig.save(warpFile);
        } catch (IOException e) {
            // error message to specify what/where it happend
            LOGGER.error("Something went wrong ,trying to set the home location in the config");
            throw new RuntimeException(e);
        }


    }

    public Location getWarpLocation(String warpName) {
        YamlConfiguration warpConfig = YamlConfiguration.loadConfiguration(warpFile);
        Location warpLocation = (Location) warpConfig.get("warps."+warpName);
        return warpLocation;
    }

    public void createWarp(final Warp warp) {

        try {
            YamlConfiguration UserConfig = YamlConfiguration.loadConfiguration(warpFile);

            UserConfig.set("warps." + warp.getName() + ".location", warp.getLocation());

            UserConfig.save(warpFile);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public FileConfiguration getWarpFile() {

        return warpConfig;

    }

    public void saveWarpFile() {

        try {

            getWarpFile().save(warpFile);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
