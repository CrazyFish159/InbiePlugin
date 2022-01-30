package net.inbar.main.Listner;

import net.inbar.main.items.ItemManager;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class TutorialEvents implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world1 = player.getWorld();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.wither.getItemMeta())){
                    event.setCancelled(true);
                    if(!world1.getName().equals("Survival")){
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "you cant do this in that world!");
                    }else{

                        Bukkit.getWorld("Survival").spawnEntity(loc, EntityType.WITHER);
                        if(player.getGameMode().equals(GameMode.CREATIVE)){

                        }else{
                            player.getInventory().remove(Material.BAT_SPAWN_EGG);
                        }
                    }

                }
            }
        }
    }




        @EventHandler
        public void onDeath(EntityDeathEvent e){
            Location loc = e.getEntity().getLocation();
            if(e.getEntityType().equals(EntityType.WITHER)){
                if(!loc.getWorld().getName().equals("Survival"))
                    return;
                ItemStack item = new ItemStack(Material.NETHER_STAR);
                Bukkit.getWorld("Survival").dropItem(loc, item);
//                if((int) (Math.random() * 100) <= 20){ // 20%
//                    ItemStack item2 = new ItemStack(Material.WITHER_SKELETON_SKULL);
//                    Bukkit.getWorld("Survival").dropItem(loc, item2);
//                }
                ItemStack item1 = new ItemStack(Material.WITHER_SKELETON_SKULL);
                int random = (int)(Math.random() * 11);  // 10 | 3% u will get wither skull
                switch (random) {
                    case 1:
                        break;
                    case 2:
                        Objects.requireNonNull(Bukkit.getWorld("Survival")).dropItem(loc, item1);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        Objects.requireNonNull(Bukkit.getWorld("Survival")).dropItem(loc, item1);
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        Objects.requireNonNull(Bukkit.getWorld("Survival")).dropItem(loc, item1);
                        break;
                }

            }
    }
}
//                if (event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
//                        event.setCancelled(true);
//                        Player player = event.getPlayer();
//                        player.getWorld().createExplosion(player.getLocation(), 2.0f);
//                        player.sendMessage("§6You dare use the stick of truth?!");