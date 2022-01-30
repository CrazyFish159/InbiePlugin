package net.inbar.main.Listner;

import net.inbar.main.Main;
import static net.inbar.main.items.ItemManager.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class teleport implements Listener {
    Main plugin;
    public teleport(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void PlayerTeleportEvent(PlayerTeleportEvent e){
        World world1 = Bukkit.getWorld("TrestiaMap");
        World world2 = Bukkit.getWorld("Survival"); //-9.50 66.00 -1406.50
        Location loc1 = new Location(world1,213.0,40.0,-340.0,0,0);
        Location loc2 = new Location(world2,-9.50, 66.00, -1406.50);
        Inventory inv = e.getPlayer().getInventory();
        if(Objects.requireNonNull(e.getTo()).getBlock().getLocation().equals(loc1)){
            if(plugin.a_event_p_list.contains(e.getPlayer().getDisplayName())){
                plugin.a_event_p_list.remove(e.getPlayer().getDisplayName());
            }
        } else if(e.getFrom().getWorld().getName().equals("TrestiaMap")){
            inv.removeItem(gun);
        } else if(e.getTo().getWorld().getName().equalsIgnoreCase("hg_lobby")){
            inv.setItem(8 ,beck_to_lob);
        } else if(e.getFrom().getWorld().getName().equalsIgnoreCase("hg_lobby")){
            inv.remove(beck_to_lob);
        } else if(e.getTo().getWorld().getName().equals("TrestiaMap")){
            inv.setItem(7,gun);
        }
    }
}
