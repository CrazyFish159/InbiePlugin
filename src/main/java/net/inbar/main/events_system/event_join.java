package net.inbar.main.events_system;

import net.inbar.main.Main;
import net.inbar.main.file.config;
import net.inbar.main.meneger.LocationManeger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class event_join implements CommandExecutor {

    Main plugin;

    public event_join(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return false;
        }
        Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("events")){
                if(player.hasPermission("inbar.eventbypass")){
                    World world = Bukkit.getWorld("Bayville"); ///execute in minecraft:bayville run tp @s -42.50 14.00 234.50 -179.91 -3.44
                    Location location = new Location(world, -42.50 ,14.00 ,234.50,-179 ,-3);
                    player.teleport(location);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lsending you to&7&l: &6&levents"));
                    return false;
                }
                if(this.plugin.b_event_open){
                    if(plugin.a_event_p_list.size() == plugin.i_event_max){
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c סליחה אבל האיוונט מלא! אנא נסה שוב מאוחר יותר!"));
                    } else {
                        World world = Bukkit.getWorld("Bayville"); ///execute in minecraft:bayville run tp @s -42.50 14.00 234.50 -179.91 -3.44
                        Location location = new Location(world, -42.50 ,14.00 ,234.50,-179 ,-3);
                        player.teleport(location);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lsending you to&7&l: &6&levents"));
                    if(!this.plugin.a_event_p_list.contains(player.getDisplayName())){
                        this.plugin.a_event_p_list.add(player.getDisplayName());
                    } else {
                        this.plugin.a_event_p_list.remove(player.getDisplayName());
                    }

                    return false;
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4האיוונט סגור! בבקשה חכה/י ללייב או לפעילות או לתחרות"));
                }
            }return false;
    }
}
