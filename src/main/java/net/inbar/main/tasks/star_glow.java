package net.inbar.main.tasks;

import net.inbar.main.file.config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class star_glow extends BukkitRunnable {

    @Override
    public void run() {
        World world = Bukkit.getWorld((String) config.get().get("lobby-world","TrestiaMap"));
        assert world != null;
        Location loc = new Location(world,228, 56.00 ,-346.00);

        for (double z = -346.00; z < -342.00; z++){
            loc.setZ(z);
            world.spawnParticle(Particle.FLAME,loc,(int) config.get().get("int",1));

        }
        world.spawnParticle(Particle.FLAME,new Location(world,228.00, 57.00, -343.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,58.00 ,-342.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,59.00 ,-341.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,57.00 ,-342.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,58.00 ,-341.00),(int) config.get().get("int",1));
        for (double z = -341.00; z < -337.00; z++){
            loc.setZ(z);
            loc.setY(59.00);
            world.spawnParticle(Particle.FLAME,loc,(int) config.get().get("int",1));
        }
        world.spawnParticle(Particle.FLAME,new Location(world,228.00, 58.00, -338.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,57.00 ,-337.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,56.00 ,-336.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,57.00 ,-336.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,57.00 ,-336.00),(int) config.get().get("int",1));
        world.spawnParticle(Particle.FLAME,new Location(world,228.00 ,58.00 ,-337.00),(int) config.get().get("int",1));
        for (double z = -335.00; z < -332.00; z++){
            loc.setZ(z);
            loc.setY(56.00);
            world.spawnParticle(Particle.FLAME,loc,(int) config.get().get("int",1));
        }
    }
}
