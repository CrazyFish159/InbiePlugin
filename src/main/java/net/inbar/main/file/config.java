package net.inbar.main.file;

import net.inbar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class config {

    Main plugin;
    public config(Main plugin) {
        this.plugin = plugin;
    }


    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("inbar-server").getDataFolder(), "Config.yml");

        if(!file.exists()) {
            try{
                file.createNewFile();
            }catch(IOException e){

            }

        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            System.out.printf("Savingtp to %s content of:\n%s%n", file, customFile.saveToString());
            customFile.save(file);
        }catch(IOException e){
            System.out.println("[inbar_server]" + " " +  "config file been not saved!" + e);
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
