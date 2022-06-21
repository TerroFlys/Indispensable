package be.chenko.indispensable.models;

import org.bukkit.Location;

public class Warp {
    private Location location;
    private String name;
    //cooldown
    //private double cooldown;


    public Warp(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
