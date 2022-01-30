package net.inbar.main.Listner;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class plots_gmc implements Listener {

    @EventHandler
    public void PlayerChangedWorldEvent(PlayerChangedWorldEvent event){
        if(event.getPlayer().getWorld().equals("_mister_blue_sky")){
            event.getPlayer().setGameMode(GameMode.CREATIVE);
        } else if(event.getPlayer().getWorld().equals("TrestiaMap")){
            event.getPlayer().setGameMode(GameMode.ADVENTURE);
        }

    }

}
