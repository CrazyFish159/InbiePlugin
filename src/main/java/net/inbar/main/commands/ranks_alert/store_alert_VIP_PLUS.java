package net.inbar.main.commands.ranks_alert;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class store_alert_VIP_PLUS implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
        }
        Player player = (Player) sender;



        if (cmd.getName().equalsIgnoreCase("store_alert_VIP")) {
            if(player.hasPermission("inbar.store_alert")) {
                if (args.length > 0) {
                    String message = "";

                    for (int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }

                    Bukkit.broadcastMessage(GOLD + "" + BOLD + "[" + DARK_RED + "" + BOLD + "התראה!" + GOLD + "" + BOLD + "] " + WHITE + "> " + RED + message);

                    for (Player player1 : Bukkit.getOnlinePlayers()) {
                        Location loc = player1.getLocation();
                        player1.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1 , 1);
                    }

                } else {
                    player.sendMessage(RED + "ERROR");
                }

            } else {
                player.sendMessage("no lol");
            }
        }
        return false;
    }

}