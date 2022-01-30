package net.inbar.main.tasks;

import net.inbar.main.Main;
import net.inbar.main.file.config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Task_1 extends BukkitRunnable{

    Main plugin;

    public Task_1(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        World world = Bukkit.getWorld((String)config.get().get("lobby-world","world"));
        Location loc1 = new Location(Bukkit.getWorld((String)config.get().get("lobby-world","world")),213, 66 ,-340);
        Location loc2 = new Location(Bukkit.getWorld((String)config.get().get("lobby-world","world")),229, 66, -356);
        Location loc3 = new Location(Bukkit.getWorld((String)config.get().get("lobby-world","world")),229, 66 ,-326);
        Location loc4 = new Location(Bukkit.getWorld((String)config.get().get("lobby-world","world")),229, 76 ,-340);
        new BukkitRunnable() {
            double t = Math.PI / 4;
            public void run() {
                t = t + 0.1 * Math.PI;
                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
                    double x = t * cos(theta);
                    double y = 2 * Math.exp(-0.1 * t) * sin(t) + 1.5;
                    double z = t * sin(theta);
                    loc1.add(x, y, z);
                    world.spawnParticle(Particle.FIREWORKS_SPARK, loc1, 0);
                    loc1.subtract(x, y, z);

                    theta = theta + Math.PI / 64;

                    x = t * cos(theta);
                    y = 2 * Math.exp(-0.1 * t) * sin(t) + 1.5;
                    z = t * sin(theta);
                    loc1.add(x, y, z);
                    world.spawnParticle(Particle.HEART, loc1, 0);
                    loc1.subtract(x, y, z);

                    theta = theta + Math.PI / 64;

                    x = t * cos(theta);
                    y = 2 * Math.exp(-0.1 * t) * sin(t) + 1.5;
                    z = t * sin(theta);
                    loc1.add(x, y, z);
                    world.spawnParticle(Particle.END_ROD, loc1, 0);
                    loc1.subtract(x, y, z);
                }
                if (t > 50) {
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 1);
        world.spawnParticle(Particle.HEART,loc2,1);
        new BukkitRunnable() {
            double t = Math.PI / 4;
            public void run() {
                t = t + 0.3 * Math.PI;
                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 39) {
                    double x = t * cos(theta);
                    double y = 2 * Math.exp(-0.1 * t) * sin(t) + 0.1;
                    double z = t * sin(theta);
                    loc2.add(x, y, z);
                    world.spawnParticle(Particle.TOTEM, loc2, 0);
                    world.spawnParticle(Particle.TOTEM, loc2, 0);
                    loc2.subtract(x, y, z);
                }
                if (t > 5) {
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 1);
        world.spawnParticle(Particle.HEART,loc3,1);
        new BukkitRunnable() {
            double t = Math.PI / 4;

            public void run() {
                t = t + 0.3 * Math.PI;
                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 39) {
                    double x = t * cos(theta);
                    double y = 2 * Math.exp(-0.1 * t) * sin(t) + 0.1;
                    double z = t * sin(theta);
                    loc3.add(x, y, z);
                    world.spawnParticle(Particle.TOTEM, loc3, 0);
                    world.spawnParticle(Particle.TOTEM, loc3, 0);
                    loc3.subtract(x, y, z);
                }
                if (t > 5) {
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 1);
        new BukkitRunnable() {
            double t = Math.PI / 4;

            public void run() {
                t = t + 0.3 * Math.PI;
                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 39) {
                    double x = t * cos(theta);
                    double y = 2 * Math.exp(-0.1 * t) * sin(t) + 0.1;
                    double z = t * sin(theta);
                    loc4.add(x, y, z);
                    world.spawnParticle(Particle.TOTEM, loc4, 0);
                    world.spawnParticle(Particle.TOTEM, loc4, 0);
                    loc4.subtract(x, y, z);
                }
                if (t > 5) {
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 1);
        world.spawnParticle(Particle.HEART,loc4,1);
        Bukkit.broadcastMessage("done " + LocalTime.now());
    }
}
