package net.inbar.main.events_system;

import net.inbar.main.Main;
import net.inbar.main.meneger.LocationManeger;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class close_a_close_events implements CommandExecutor {

    Main plugin;

    public close_a_close_events(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("enable-event")) {
                if (sender.hasPermission("inbar.Enable-event")) {

                        for (Player player1 : Bukkit.getOnlinePlayers()) {
                            if (player1.getWorld().getName().equals("TrestiaMap") || player1.getWorld().getName().equals("Events")) {
                                player1.sendTitle(ChatColor.translateAlternateColorCodes('&', "&b האיוונט פתוח!!") + "", ChatColor.translateAlternateColorCodes('&', "&2&lמוזמנים להכנס :)") + "", 15, 100, 20);
                                Location loc = player1.getLocation();
                                player1.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                                player1.sendMessage(GREEN + "האיוונט פתוח!!");
                            }


                            plugin.b_event_open = true;
                        }

                } else {
                    sender.sendMessage("no lol");
                }

        } else if (cmd.getName().equalsIgnoreCase("disable-event") || sender.hasPermission("inbar.disable-event")) {

                Bukkit.broadcastMessage(RED + "האיוונט סגור!");
                plugin.b_event_open = false;
                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    if(this.plugin.a_event_p_list.contains(player1.getDisplayName())){
                        World world = Bukkit.getWorld("TrestiaMap");
                        //213.50 41.25 -339.50 -90.24 -10.02
                        Location loc = new Location(world,213.50,41.25,-339.50,-90,-10);
                        player1.teleport(loc);
                        plugin.a_event_p_list.remove(player1.getDisplayName());
                        player1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lsending you to&7&l: &6&llobby"));
                    }

                    if(player1.getWorld().getName().equals("TrestiaMap") || player1.getWorld().getName().equals("Events")){
                        player1.sendTitle("האיוונט סגור!", ChatColor.translateAlternateColorCodes('&', "&2&l נתראה בפעם הבאה!") + "", 15, 100, 20);
                    }



            }
        }
        return false;
    }
}