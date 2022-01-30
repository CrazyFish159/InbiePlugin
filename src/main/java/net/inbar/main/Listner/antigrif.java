package net.inbar.main.Listner;

import net.inbar.main.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import static org.bukkit.ChatColor.*;
import static org.bukkit.ChatColor.DARK_RED;

public class antigrif implements Listener {

        Main plugin;

    public antigrif(Main plugin) {
            this.plugin = plugin;
        }

        public static Material[] pbl = {Material.TNT};
        public static Material[] dbl = {Material.TNT};

        @EventHandler
        public void onBlockPlace(BlockPlaceEvent event) {
            Player P = event.getPlayer();
            if (!P.getWorld().equals("TrestiaMap") || P.getWorld().equals("Block_party") || P.getWorld().equals("hungergames") || P.getWorld().equals("Events")) {

            } else {
               // if (!plugin.build_list.contains(P)) {
                    Material block = event.getBlock().getType();
                    Player p = event.getPlayer();
                    for (Material blocked : pbl) {
                        if (pbl == pbl) {
                            Block eblock = event.getBlock();
                            event.setCancelled(true);
                            p.sendMessage(BLUE + "inbar " + RED + "|" + " " + DARK_RED + "you cent place block in here!");
                       // }
                    }
                }
            }
        }
        @EventHandler
        public void onBlockBreak(BlockBreakEvent event) {
            Player P = event.getPlayer();
            //if (!plugin.build_list.contains(P)) {
                Material block = event.getBlock().getType();
                Player p = event.getPlayer();
                for (Material blocked : dbl) {
                    if (dbl == dbl) {
                        Block eblock = event.getBlock();
                        event.setCancelled(true);
                        p.sendMessage(BLUE + "inbar " + " " + RED + "|" + " " + DARK_RED + "you cent break in here!");
                    //}
                }
            }
        }
}
