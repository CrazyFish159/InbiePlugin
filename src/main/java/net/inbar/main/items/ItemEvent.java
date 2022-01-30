package net.inbar.main.items;

import net.inbar.main.Main;
import net.inbar.main.file.config;
import net.inbar.main.inventoryMeneger.invMeneger;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.bukkit.ChatColor.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemEvent implements Listener {

    Main plugin;

    public int taskID = 1;

    public ItemEvent(Main plugin) {
        this.plugin = plugin;
    }

    Map<String, Long> cooldowns = new HashMap<String, Long>();

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e){
        if(e.getEntity().getType().equals(EntityType.SNOWBALL)){
        Snowball ball = (Snowball) e.getEntity();
        Player p = (Player) ball.getShooter();
        Location aloc = ball.getLocation();
        World world = ball.getWorld();
//        if(Objects.requireNonNull(e.getHitEntity()).getType().toString().equals("ITEM_FRAME")){
//        }
        if(plugin.a_2gun_normal.contains(p.getUniqueId())) {
            world.spawnParticle(Particle.FLAME, aloc, 100);
            world.spawnParticle(Particle.SPIT, aloc, 12);
            world.spawnParticle(Particle.ENCHANTMENT_TABLE, aloc, 10);
        } else if(plugin.a_2gun_VIP.contains(p.getUniqueId())){
            world.spawnParticle(Particle.TOTEM, aloc, 200);
            world.spawnParticle(Particle.SMOKE_NORMAL, aloc, 12);
            world.spawnParticle(Particle.LAVA, aloc, 10);
        }  else if(plugin.a_2gun_VIP_.contains(p.getUniqueId())){
            world.spawnParticle(Particle.LAVA, aloc, 100);
            world.spawnParticle(Particle.SPIT, aloc, 12);
            world.spawnParticle(Particle.HEART, aloc, 10);
        }  else if(plugin.a_2gun_capara.contains(p.getUniqueId())){
            new BukkitRunnable(){
                Location loc = ball.getLocation();
                double t = 0;
                double r = 2;
                public void run(){
                    t = t + Math.PI/16;
                    double x = r*cos(t);
                    double y = r*sin(t);
                    double z = r*sin(t);
                    loc.add(x, y, z);
                    world.spawnParticle(Particle.LAVA, loc, 1);
                    loc.subtract(x, y, z);
                    if (t > Math.PI*8){
                        this.cancel();
                    }
                }

            }.runTaskTimer(plugin, 0, 1);

        }  else if(plugin.a_2gun_capara_.contains(p.getUniqueId())){

            world.spawnEntity(aloc,EntityType.FIREWORK);

        }  else if(plugin.a_2gun_ionit.contains(p.getUniqueId())){
            new BukkitRunnable() {
                double t = Math.PI / 4;
                Location loc = ball.getLocation();

                public void run() {
                    t = t + 0.3 * Math.PI;
                    for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 39) {
                        double x = t * cos(theta);
                        double y = 2 * Math.exp(-0.1 * t) * sin(t) + 0.1;
                        double z = t * sin(theta);
                        loc.add(x, y, z);
                        world.spawnParticle(Particle.TOTEM, loc, 0);
                        loc.subtract(x, y, z);
                    }
                    if (t > 20) {
                        this.cancel();
                    }
                }

            }.runTaskTimer(plugin, 0, 1);
        }  else if(plugin.a_2gun_ionit_.contains(p.getUniqueId())){
            Location loc = ball.getLocation();
            loc.getWorld().spawnEntity(loc,EntityType.LIGHTNING);
            new BukkitRunnable() {
                double t = Math.PI / 4;

                public void run() {
                    t = t + 0.1 * Math.PI;
                    for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
                        double x = t * cos(theta);
                        double y = 2 * Math.exp(-0.1 * t) * sin(t) + 1.5;
                        double z = t * sin(theta);
                        loc.add(x, y, z);
                        world.spawnParticle(Particle.FIREWORKS_SPARK, loc, 0);
                        //ParticleEffect.FIREWORKS_SPARK.display(loc,0,0,0,0,1);
                        loc.subtract(x, y, z);

                        theta = theta + Math.PI / 64;

                        x = t * cos(theta);
                        y = 2 * Math.exp(-0.1 * t) * sin(t) + 1.5;
                        z = t * sin(theta);
                        loc.add(x, y, z);
                        world.spawnParticle(Particle.HEART, loc, 0);
                        loc.subtract(x, y, z);

                        theta = theta + Math.PI / 64;

                        x = t * cos(theta);
                        y = 2 * Math.exp(-0.1 * t) * sin(t) + 1.5;
                        z = t * sin(theta);
                        loc.add(x, y, z);
                        world.spawnParticle(Particle.END_ROD, loc, 0);
                        loc.subtract(x, y, z);
                    }
                    if (t > 180) {
                        this.cancel();
                    }
                }

            }.runTaskTimer(plugin, 0, 1);
        }
        /*
        world.spawnParticle(Particle.FLAME, aloc, 100);
        world.spawnParticle(Particle.SPIT, aloc, 12);
        world.spawnParticle(Particle.ENCHANTMENT_TABLE, aloc, 10);

        Bukkit.broadcastMessage(e.getHitEntity().getType().toString() + "\n" + e.getHitBlockFace());
        if(e.getHitEntity().getType().equals(EntityType.ITEM_FRAME)){
            Bukkit.broadcast("tset","non");
            e.setCancelled(true);
        }
         */
        ball.remove();
        }
    }


    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {

        Action action = event.getAction();
        Player player = event.getPlayer();
        World world = event.getPlayer().getLocation().getWorld();
        Location loc = player.getLocation();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getItemMeta() == null) {
            return;
        }
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        loc.setY(loc.getY() + 1.0D);
        if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)){
        if (name.equals("§6§lרובה פארטיקלס")) {
            if (!player.hasPermission("inbar.gunbypass")) {

                if (!(loc.getWorld().getName().equals( config.get().get("lobby-world","world")))) {
                    player.sendMessage("למה אתה מנסה בכלל?");
                    return;
                }
            }
            if (cooldowns.containsKey(player.getName())) {
                if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                    Long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                    player.sendMessage(RED + "תחכה/י עוד -=" + timeleft + "=- שניות!");

                    return;
                }

            }
            new ItemStack(item.getType(), 1);
            final Entity drop = loc.getWorld().spawnEntity(loc, EntityType.SNOWBALL);
            drop.setGlowing(true);
            drop.setCustomName("weeeeeeeeeeeeeeeee");
            drop.setVelocity(loc.getDirection().multiply(5));
            ((Projectile) drop).setShooter(player);

            if (player.hasPermission("inbar.gunbypass")) {
            } else {
                cooldowns.put(player.getName(), System.currentTimeMillis() + (6 * 1000));
            }
            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                @Override
                public void run() {
                    if(!drop.isDead()) {
                        Location droploc = drop.getLocation();
                        assert world != null;
                            if(plugin.a_gun_normal.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.CRIT, droploc, 10);
                            world.spawnParticle(Particle.CRIT, droploc, 10);
                        } else if(plugin.a_gun_VIP.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.TOTEM, droploc, 10);
                            world.spawnParticle(Particle.TOTEM, droploc, 10);
                        } else if(plugin.a_gun_VIP_.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.PORTAL, droploc, 5);
                            world.spawnParticle(Particle.REVERSE_PORTAL, droploc, 5);
                        } else if(plugin.a_gun_capara.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.FIREWORKS_SPARK, droploc, 5);
                            world.spawnParticle(Particle.FIREWORKS_SPARK, droploc, 5);
                        } else if(plugin.a_gun_capara_.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.CRIT_MAGIC, droploc, 5);
                            world.spawnParticle(Particle.CRIT_MAGIC, droploc, 5);
                        } else if(plugin.a_gun_ionit.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.SMOKE_NORMAL, droploc, 5);
                        } else if(plugin.a_gun_ionit_.contains(player.getUniqueId())){
                            world.spawnParticle(Particle.HEART, droploc, 5);
                            world.spawnParticle(Particle.HEART, droploc, 5);
                            world.spawnParticle(Particle.FIREWORKS_SPARK, droploc, 5);
                            world.spawnParticle(Particle.FIREWORKS_SPARK, droploc, 5);
                        } else {
                            world.spawnParticle(Particle.CRIT, droploc, 10);
                            world.spawnParticle(Particle.CRIT, droploc, 10);
                            }
                    } else {
                        //BukkitScheduler.cancelTask();
                    }
                }
            }, 0, 0L);


        } else if (name.equals("§c§lחזרה ללובי")) {
            player.teleport(new Location(Bukkit.getWorld("TrestiaMap"), 213.50, 40.17, -339.50, -89, -0));
        }
    } else if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)){
            if (name.equals("§6§lרובה פארטיקלס")) {
                    invMeneger.openInventory_selctor(player);

            } else {
            }
        }

    }

}