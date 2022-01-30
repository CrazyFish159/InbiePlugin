package net.inbar.main.Listner;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class netherportal implements Listener {

    @EventHandler
    public void PortalCreateEvent(PortalCreateEvent e){
    e.setCancelled(true);
    Player p = (Player) e.getEntity();
    p.sendMessage("סליחה אבל את/ה לא יכול/ה לעשות את זה!");
    }
}
