package net.inbar.main.Listner;

import net.inbar.main.Main;
import net.inbar.main.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class worlde implements Listener {

    Main plugin;

    public worlde(Main plugin) {
        this.plugin = plugin;
    }

    public void worlde(PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        p.sendMessage(p.getWorld().getName());
        if(event.getPlayer().getWorld().getName().equals("Survival")){
            p.getInventory().removeItem(ItemManager.gun);
        }else if(event.getFrom().getName().equals("Events")){
            plugin.a_event_p_list.remove(p.getDisplayName());
        }
    }
}