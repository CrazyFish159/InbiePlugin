//package net.inbar.main.events;
//
//import net.inbar.main.meneger.LocationManeger;
//import org.bukkit.Location;
//import org.bukkit.Material;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.ItemStack;
//
//public class leave_bed_inbepaarty implements Listener{
//
//    @EventHandler
//    public void onRightClick(PlayerInteractEvent e) {
//        Player p = e.getPlayer();
//        p.sendMessage("1");
//        ItemStack bed = new ItemStack(Material.RED_BED);
//        if(e.getItem().equals(bed)){
//            p.sendMessage("2");
//        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR ) {
//            p.sendMessage("3");
//                Location lobby = LocationManeger.getLocation("lobby");
//                p.teleport(lobby);
//                p.sendMessage(p.getWorld() + "");
//                return;
//            }
//
//        }
//
//    }
//
//}