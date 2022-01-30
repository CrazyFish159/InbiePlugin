package net.inbar.main.commands.ranks_alert;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;
import static org.bukkit.ChatColor.BOLD;

public class store_alert_capara_plus implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("alert")) {
            if(player.hasPermission("inbar.alert")) {
                if (args.length > 0) {
                    if(args[1] == "store"){

                        for (Player player1 : Bukkit.getOnlinePlayers()) {
                            player1.sendTitle("ר","ש",2,10,2);
                            Location loc = player1.getLocation();
                            player1.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1 , 1);
                        }

                    }
                    String message = "";

                    for (int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }

                    Bukkit.broadcastMessage(GOLD + "" + BOLD + "[" + DARK_RED + "" + BOLD + "התראה!" + GOLD + "" + BOLD + "] " + WHITE + "> " + RED + message);

                    for (Player player1 : Bukkit.getOnlinePlayers()) {
                        player1.sendTitle(DARK_RED + "" + BOLD + "התראה!", GOLD + "" + BOLD + message);
                        Location loc = player1.getLocation();
                        player1.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1 , 1);
                    }

                } else {
                    player.sendMessage("אתה חייב לתת לי למה לעשות alert!");
                }

            } else {
                player.sendMessage("no lol");
            }
        }
        return false;
    }

}