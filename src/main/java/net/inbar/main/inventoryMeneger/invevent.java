package net.inbar.main.inventoryMeneger;

import net.inbar.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;
import java.util.UUID;

public class invevent implements Listener {

    Main plugin;

    public invevent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void e(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        UUID UUID = player.getUniqueId();
        if(e.getView().getTitle().equals("Particle Gun Selector")){
            String name = Objects.requireNonNull(Objects.requireNonNull(e.getCurrentItem()).getItemMeta()).getDisplayName();
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("שביל")) {
                    invMeneger.openInventory_trials(player);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("פיצוץ")) {
                    invMeneger.openInventory_explosion(player);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("סגור")) {
                    player.closeInventory();
                }
                e.setCancelled(true);
        } else if(e.getView().getTitle().equals("Particle Gun Selector: trail")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("normal")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_normal.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected normal effect!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("vip")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_VIP.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected VIP effect!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("vip+")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_VIP_.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected VIP+ effect!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("capara")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_capara.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected capara effect!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("capara+")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_capara_.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected capara+ effect!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("i on it")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_ionit.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected i on it effect!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("i on it +")) {
                plugin.removeformallgun(UUID);
                plugin.a_gun_ionit_.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected i on it + effect!");
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("go back")){
                invMeneger.openInventory_selctor(player);

            }
            e.setCancelled(true);
        }else if(e.getView().getTitle().equals("Particle Gun Selector: explosion")){
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("normal")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_normal.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected normal explosion!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("vip")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_VIP.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected VIP explosion!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("vip+")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_VIP_.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected VIP+ explosion!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("capara")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_capara.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected capara explosion!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("capara+")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_capara_.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected capara+ explosion!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("i on it")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_ionit.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected i on it explosion!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("i on it +")) {
                plugin.removeformallgun2(UUID);
                plugin.a_2gun_ionit_.add(UUID);
                player.getOpenInventory().close();
                player.sendMessage("you selected i on it + explosion!");
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("go back")){
                invMeneger.openInventory_selctor(player);

            }
            e.setCancelled(true);
        }
    }


}
