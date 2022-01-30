package net.inbar.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class alert implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        if (!(sender instanceof Player)) {
//            System.out.println("Only players can use that command!");
//            return false;
//        }

        //Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("alert")) {
            if (sender.hasPermission("inbar.alert")) {
                if (args.length > 0) {
                        String message = " ";
                        for (int i = 0; i < args.length; i++) {
                            message = message + args[i] + " ";
                        }

                        //Bukkit.broadcastMessage(GOLD + "" + BOLD + "[" + DARK_RED + "" + BOLD + "התראה!" + GOLD + "" + BOLD + "] " + WHITE + "> " + RED + message);
                        for (Player player1 : Bukkit.getOnlinePlayers()) {
                            player1.sendTitle(DARK_RED + "" + BOLD + "התראה!", GOLD + "" + BOLD + ChatColor.translateAlternateColorCodes('&', message),5,150,5);
                            player1.sendMessage(GOLD + "" + BOLD + "[" + DARK_RED + "" + BOLD + "התראה!" + GOLD + "" + BOLD + "] " + WHITE + "> " + RED + ChatColor.translateAlternateColorCodes('&', message));
                            Location loc = player1.getLocation();
                            player1.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        }

                    } else {
                        sender.sendMessage("אתה חייב לתת לי למה לעשות alert!");
                    }

                } else {
                    sender.sendMessage("no lol");
                }
            }

return false;
    }
}