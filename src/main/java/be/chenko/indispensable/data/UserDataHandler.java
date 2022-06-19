package be.chenko.indispensable.data;

import be.chenko.indispensable.Indispensable;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.util.UUID;

import static be.chenko.indispensable.Indispensable.LOGGER;

public class UserDataHandler implements Listener {
    Indispensable p;
    UUID u;
    File userFile;
    FileConfiguration userConfig;

    public UserDataHandler(UUID uuid) {
        this.u = uuid;
        userFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Indispensable").getDataFolder(), uuid + ".yml");
        userConfig = YamlConfiguration.loadConfiguration(userFile);
    }
    // check if user has home
    public Boolean HasHome(){
        if ( !(userFile.exists()) ) return false;
        return userConfig.get("user.homes") != null;
    }

    public void createUser(final Player player){

        if ( !(userFile.exists()) ) {
            try {


                YamlConfiguration UserConfig = YamlConfiguration.loadConfiguration(userFile);

                UserConfig.set("user.info.lastName", player.getName());
                UserConfig.set("user.info.uniqueID", player.getUniqueId().toString());
                UserConfig.set("user.info.ipAddress", player.getAddress().getAddress().getHostAddress());

                UserConfig.save(userFile);



            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }
    public FileConfiguration getUserFile(){

        return userConfig;

    }
    public void saveUserFile() {

        try {

            getUserFile().save(userFile);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
