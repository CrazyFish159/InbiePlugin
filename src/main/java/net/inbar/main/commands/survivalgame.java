package net.inbar.main.commands;

import net.inbar.main.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class survivalgame implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label,  String[] args) {
        if(command.getName().equalsIgnoreCase("survivalgame")){
            Player p = (Player) sender;
            World world = Bukkit.getWorld("survival");
            //-9.50, 66.00, -1406.50, 90, -3
            Location loc = new Location(world ,-9.50, 66.00, -1406.50, 90, -3);
            p.teleport(loc);
            Inventory inv = p.getInventory();
            p.setGameMode(GameMode.SURVIVAL);
            if(inv.contains(ItemManager.gun)){
                inv.removeItem(ItemManager.gun);
            }
        }
        return false;
    }
}
