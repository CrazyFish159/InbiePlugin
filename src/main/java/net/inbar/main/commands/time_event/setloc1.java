package net.inbar.main.commands.time_event;

import net.inbar.main.meneger.LocationManeger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;

import static org.bukkit.ChatColor.*;

public class setloc1 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
//        if (!(sender instanceof Player)) {
//            sender.sendMessage("Only players can use that command!");
//        }

        if (cmd.getName().equalsIgnoreCase("setpos1")) {
            LocationManeger.setLocation("pos1", player.getLocation());
            LocationManeger.savecfg();
            player.sendMessage(AQUA + "[Time event] " + GREEN + "ok you set the " + DARK_GREEN + "pos1");
        }
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            int h = now.getHour();
            int m = now.getMinute();
            int s = now.getSecond();
            int hm = 00;
            int mm = 00;
            int sm = 00;

            if (now.getHour() == 20 || now.getMinute() == 32) {
                Bukkit.broadcastMessage("time is up");

                Location loc = LocationManeger.getLocation("pos1");
                loc.getWorld().spawnParticle(Particle.FLAME, loc, 10, 1);
                loc.getWorld().spawnParticle(Particle.FLAME, loc, 10, 1);
                loc.getWorld().spawnParticle(Particle.FLAME, loc, 10, 1);
                loc.getWorld().spawnParticle(Particle.FLAME, loc, 10, 1);
                loc.getWorld().spawnParticle(Particle.FLAME, loc, 10, 1);
                Bukkit.broadcastMessage("time is up");
            }
        }
    }
}