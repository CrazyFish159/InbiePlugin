package net.inbar.main.commands;

import net.inbar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class starte implements CommandExecutor {

    Main plugin;

    public starte(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("start")){
            if(!plugin.b_event_open){
                sender.sendMessage("event is not open yeet!E");
                return false;
            } else {
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(plugin.a_event_p_list.contains(player.getDisplayName())){
                        World world = Bukkit.getWorld("Events");
                        Block block1 = world.getBlockAt(-176, 69, -39);
                        block1.setType(Material.AIR);

                        Block block2 = world.getBlockAt(-176, 68, -39);
                        block2.setType(Material.AIR);

                        Block block3 = world.getBlockAt(-176, 67, -39);
                        block3.setType(Material.AIR);


                        Block block4 = world.getBlockAt(-175, 69, -39);
                        block4.setType(Material.AIR);

                        Block block5 = world.getBlockAt(-175, 68, -39);
                        block5.setType(Material.AIR);

                        Block block6 = world.getBlockAt(-175, 67, -39);
                        block6.setType(Material.AIR);


                        Block block7 = world.getBlockAt(-174, 69, -39);
                        block7.setType(Material.AIR);

                        Block block8 = world.getBlockAt(-174, 68, -39);
                        block8.setType(Material.AIR);

                        Block block9 = world.getBlockAt(-174, 67, -39);
                        block9.setType(Material.AIR);


                        sender.sendMessage("game started!");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,999999,999999));
                        player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                    }
                }
            }
        }
        return false;
    }
}
