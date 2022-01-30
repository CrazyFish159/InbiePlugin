package net.inbar.main.commands;

import net.inbar.main.meneger.LocationManeger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class set_lobby implements CommandExecutor{

        @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {

            sender.sendMessage("Only players can use that command!");
        }
        if(player.hasPermission("inbar.setlobby")){
            if (cmd.getName().equalsIgnoreCase("setlobby")) {
                LocationManeger.setLocation("lobby", player.getLocation());
                player.sendMessage(AQUA + "[lobby] " + GREEN + "ok you set the " + DARK_GREEN + "lobby");
            }
        }
        return true;
    }

}
