package net.inbar.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;
import static org.bukkit.ChatColor.RED;

public class alertm {

    public void alert(String[] msg){
        String message = " ";
        for (int i = 0; i < msg.length; i++) {
            message = message + msg[i] + " ";
        }

        //Bukkit.broadcastMessage(GOLD + "" + BOLD + "[" + DARK_RED + "" + BOLD + "התראה!" + GOLD + "" + BOLD + "] " + WHITE + "> " + RED + message);
        for (Player player1 : Bukkit.getOnlinePlayers()) {
            player1.sendTitle(DARK_RED + "" + BOLD + "התראה!", GOLD + "" + BOLD + ChatColor.translateAlternateColorCodes('&', message),5,150,5);
            player1.sendMessage(GOLD + "" + BOLD + "[" + DARK_RED + "" + BOLD + "התראה!" + GOLD + "" + BOLD + "] " + WHITE + "> " + RED + ChatColor.translateAlternateColorCodes('&', message));
            Location loc = player1.getLocation();
            player1.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        }
    }
}
