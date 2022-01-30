package net.inbar.main.hideandsik;

import net.inbar.main.Main;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class events implements Listener {

    Main plugin;

    public events(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void event(InventoryClickEvent e){
        if(plugin.seeker.contains(e.getWhoClicked())){
            e.setCancelled(true);
        } else if(plugin.hider.contains(e.getWhoClicked())){
            e.setCancelled(true);
        } else if(plugin.hider_die.contains(e.getWhoClicked())){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void die(PlayerDeathEvent e){
        Player p = e.getEntity();
//        if(plugin.a_event_p_list.contains(p)){
//        plugin.hider.remove(p);
//        plugin.hider_die.add(p);
//        } else {
//            return;
//        }
            if(plugin.hider.contains(p)) {
                plugin.hider.remove(p);
                plugin.hider_die.add(p);
            Bukkit.broadcastMessage("e");
            World world = Bukkit.getWorld("Bayville"); ///execute in minecraft:bayville run tp @s -42.50 14.00 234.50 -179.91 -3.44
            Location location = new Location(world, -42.50, 14.00, 234.50, -179, -3);
            e.getEntity().teleport(location);
            p.setInvisible(true);
            p.setAllowFlight(true);
            p.setFlying(true);

                ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
                SkullMeta meta = (SkullMeta) skull.getItemMeta();
                meta.setOwner(p.getName());
                meta.setDisplayName(p.getDisplayName() + " Skull");
                skull.setItemMeta(meta);
                p.getEquipment().setHelmet(skull);
                Bukkit.broadcastMessage("debug1");
            p.setBedSpawnLocation(location);
            p.setGameMode(GameMode.ADVENTURE);

        }
        if(plugin.hider.isEmpty()) {
            for(Player eventp : Bukkit.getOnlinePlayers()){
                if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                eventp.sendMessage("המחפש מצא את כולם!");
                command_maneger.endgame(plugin.seeker.get(0));

                ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
                SkullMeta meta = (SkullMeta) skull.getItemMeta();
                meta.setOwner(p.getName());
                meta.setDisplayName(p.getDisplayName() + " Skull");
                skull.setItemMeta(meta);
                p.getEquipment().setHelmet(skull);
            }
        }
    }

//
//    @EventHandler
//    public void eventdie(EntityDamageEvent e){
//        if(e.getEntity().getName().equals(ChatColor.translateAlternateColorCodes('&', "&6&lEvents")) || e.getEntity().getName().equals(ChatColor.translateAlternateColorCodes('&',"&7sasda"))) return;
//        if(!e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) return;
//        if(e.getEntity().getType() == EntityType.PLAYER){
//        plugin.hider.remove(e.getEntity().getUniqueId());
//        plugin.hider_die.add(e.getEntity().getUniqueId());
//            Player p = (Player) e.getEntity();
//
//        } }
}
