package net.inbar.main.meneger;

import net.inbar.main.Main;
import net.inbar.main.file.config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LocationManeger {

    Main plugin;

    public LocationManeger(Main plugin) {
        this.plugin = plugin;
    }

    private static File file = new File("plugins/inbar_server/data/Location.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void savecfg(){
        try{
            cfg.save(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    String world = plugin.getConfig().getString("lobby-name-world");


    public static void setLocation(String name, Location loc){
        cfg.set(name+"world", loc.getWorld().getName());
        cfg.set(name+".x", loc.getX());
        cfg.set(name+".y", loc.getY());
        cfg.set(name+".Z", loc.getZ());
        cfg.set(name+".yaw", loc.getYaw());
        cfg.set(name+".Pitch", loc.getPitch());
        try{
            cfg.save(file);
        } catch (IOException e){
            e.printStackTrace();
        }
        savecfg();
        if(!file.exists()){
            try {
                file.mkdir();
            }catch(Exception e){
            }
        }
    }
    public static Location getLocation(String name){
        if (name.equals("event")) {
            World world = Bukkit.getWorld(Objects.requireNonNull(config.get().getString("event-name-world")));
            double x = cfg.getDouble(name+".x");
            double y = cfg.getDouble(name+".y");
            double z = cfg.getDouble(name+".Z");
            Location loc = new Location(world, x, y, z);
            loc.setYaw(cfg.getInt(name+".yaw"));
            loc.setPitch(cfg.getInt(name+".Pitch"));
            return loc;
        }
        World world = Bukkit.getWorld(Objects.requireNonNull(config.get().getString("lobby-name-world")));
        double x = cfg.getDouble(name+".x");
        double y = cfg.getDouble(name+".y");
        double z = cfg.getDouble(name+".Z");
        Location loc = new Location(world, x, y, z);
        loc.setYaw(cfg.getInt(name+".yaw"));
        loc.setPitch(cfg.getInt(name+".Pitch"));
        return loc;
    }


}
