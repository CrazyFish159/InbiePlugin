package net.inbar.main.commands;

import net.inbar.main.meneger.LocationManeger;
import net.inbar.main.file.config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.ChatColor.*;

public class TutorialCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
            Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("givewither")) {
            ItemStack item = new ItemStack(Material.BAT_SPAWN_EGG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("wither spawn egg");
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
        } else if(cmd.getName().equalsIgnoreCase("tutorial") || cmd.getName().equalsIgnoreCase("ts")) {

            Location lobby =  LocationManeger.getLocation("lobby");
            player.teleport(lobby);

            player.sendMessage("i wes testing lol");


        } else if (cmd.getName().equalsIgnoreCase("set-ts")) {
            LocationManeger.setLocation("lobby", player.getLocation());
            player.sendMessage(BLUE + config.get().getString("Server-Name:") + " " + RED + "|" + " " + DARK_GREEN + "Lobby Been Setup!");
        }
        return true;
    }

}
