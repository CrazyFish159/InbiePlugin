package net.inbar.main.commands;

import net.inbar.main.file.config;
import net.inbar.main.meneger.LocationManeger;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class setts implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {

            sender.sendMessage("Only players can use that command!");
        }
        if(player.hasPermission("Survival.settutorial")){

        }
        if (cmd.getName().equalsIgnoreCase("set-tutorial")) {
            if(!player.hasPermission("inbar.set-tutorial")){

                player.sendMessage("למה שתנסה?");
            } else {
                LocationManeger.setLocation("tutorial", player.getLocation());
                player.sendMessage(AQUA + "[Survival] " + GREEN+ "ok you set the " + DARK_GREEN + "tutorial");
            }

        }
        return true;
    }

}
