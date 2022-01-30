package net.inbar.main.commands;

import net.inbar.main.meneger.LocationManeger;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tutorial implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) { sender.sendMessage("Only players can use that command!"); }

        if(cmd.getName().equalsIgnoreCase("tutorial") || cmd.getName().equalsIgnoreCase("ts")) {
            Location lobby =  LocationManeger.getLocation("tutorial");
            player.teleport(lobby);
            player.sendMessage(ChatColor.AQUA + "[Survival] " + ChatColor.BLUE + "You been teleported to the " + ChatColor.GREEN + "tutorial");
        }
        return true;
    }
}
