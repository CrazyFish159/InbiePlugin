package net.inbar.main.Listner;

import net.inbar.main.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class invmoment implements Listener {

    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(!p.getWorld().getName().equals("TrestiaMap"))
            return;
        if(e.getClickedInventory() == null)
            return;
        if(!e.getClickedInventory().contains(ItemManager.gun))
            return;

        if(Objects.equals(e.getClickedInventory().getItem(7), ItemManager.gun)){
            if(!(p.hasPermission("inbar.inv"))){
                e.setCancelled(true);
            }
        }
    }
}
