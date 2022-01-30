package net.inbar.main.commands;

import net.inbar.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class holo implements CommandExecutor {

    Main plugin;

    public holo(Main plugin) {
        this.plugin = plugin;
    }

    public void createHolo(Location l, String name){

        ArmorStand holo = (ArmorStand) l.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);
        holo.setVisible(false);
        holo.setArms(false);
        holo.setGravity(false);
        holo.setCustomNameVisible(true);
        holo.setCustomName(name);
    }




    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ArmorStand holo = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            if(cmd.getName().equalsIgnoreCase("holo")){
                if(a.length == 0){
                    player.sendMessage("give me args!");
                    return true;
                }
                String args = "";
                    for(int x =0; x<a.length; x++){
                        String temp = a[x] + " ";
                        args = args + temp;
                    }
                holo.setVisible(false);
                holo.setArms(false);
                holo.setGravity(false);
                holo.setCustomNameVisible(true);
                holo.setCustomName(ChatColor.translateAlternateColorCodes('&', args));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', args));
            } else if(cmd.getName().equalsIgnoreCase("removeholo")){
                holo.remove();
            } else if(cmd.getName().equalsIgnoreCase("holoevent")){
                ArmorStand eventholo = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                while (true){
                    if (this.plugin.b_event_open = false){
                            eventholo.setCustomName(ChatColor.translateAlternateColorCodes('&', "&4האיוונט סגור"));
                        eventholo.setGravity(false);
                        eventholo.setCustomNameVisible(true);
                        eventholo.setInvisible(false);
                    } else {
                        eventholo.setCustomName(ChatColor.translateAlternateColorCodes('&', "&aהאיוונט פתוח"));
                        eventholo.setGravity(false);
                        eventholo.setCustomNameVisible(true);
                        eventholo.setInvisible(false);
                    }
                }


            }


        }

        return false;
    }

}
