package net.inbar.main.commands;

import net.inbar.main.Main;
import net.inbar.main.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.inbar.main.items.ItemManager.*;

public class hglob implements CommandExecutor {

    Main plugin;

    public hglob(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
        }

        if (cmd.getName().equalsIgnoreCase("hunger-lob")) {
            World world = Bukkit.getWorld("hg_lobby");
            Location lobby = new Location(world,210.50 ,6.00,-343.50,-89,0);
            player.teleport(lobby);
            player.getInventory().setItem(7, null);
            player.getInventory().setItem(8 ,beck_to_lob);
            player.sendMessage(ChatColor.AQUA + "[hunger game] " + ChatColor.BLUE + "You been teleported to the " + ChatColor.GREEN + "hunger game lobby");
        }
        return true;

    }
}
