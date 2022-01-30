package net.inbar.main.Listner;

import net.inbar.main.Main;
import net.inbar.main.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;

public class joine implements Listener {

    Main plugin;

    public joine(Main plugin) {
        this.plugin = plugin;
    }

        @EventHandler
        public void onJoinServer(PlayerJoinEvent join) {
        Player player = join.getPlayer();
        player.setMaxHealth(20);
        double hlath = player.getMaxHealth();
        player.setHealth(hlath);
        player.setGlowing(false);
            player.setInvisible(false);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setGlowing(false);
        if(!player.hasPermission("inbar.rank.default")){

            player.setFlying(true);

        }

//        World world = Bukkit.getWorld("TrestiaMap");
//        Location lobby = new Location(world,1,1,1);
//        player.teleport(lobby);
        player.getInventory().setItem(7, ItemManager.gun);
    }

    @EventHandler
    public void onQuitServer(PlayerQuitEvent quit) {
        plugin.a_event_p_list.remove(quit.getPlayer().getDisplayName());
    }
}
