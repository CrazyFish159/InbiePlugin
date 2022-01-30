package net.inbar.main.hideandsik;

import net.inbar.main.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.Random;
import static org.bukkit.ChatColor.*;

public class command_maneger implements CommandExecutor{

    Main plugin;

    public command_maneger(Main plugin) {
        this.plugin = plugin;
    }

    Player seeker;

    boolean timer = true;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("eventa_start")){
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(!plugin.a_event_p_list.contains(p.getDisplayName()))return false;

                    p.sendTitle(ChatColor.translateAlternateColorCodes('&',"&b&lהמשחק מתחיל!"),ChatColor.translateAlternateColorCodes('&',"&1בהצלחה!"));
                    p.sendMessage("בוחר שחקן...");
                    p.getInventory().clear();
                    p.setGlowing(false);
                    p.setGameMode(GameMode.SURVIVAL);

            }

            new BukkitRunnable() {

                @Override
                public void run() {
                    plugin.seeker.clear();
                    Player player = Bukkit.getOnlinePlayers().stream().skip(new Random().nextInt(Bukkit.getOnlinePlayers().size())).findFirst().get();
                    plugin.seeker.add(player);
                    seeker = player;

                    player.setGlowing(true);
                    player.setGameMode(GameMode.ADVENTURE);
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(plugin.a_event_p_list.contains(p.getDisplayName())){
                            p.sendMessage("נבחר מחפש: " + player.getDisplayName() + "!") ;
                        }
                        if(!plugin.seeker.contains(p)){
                            plugin.hider.add(p);
                        }

                        if(plugin.hider.contains(p)){
                        p.setMaxHealth(2);
                        }



                    ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
                    ItemMeta swordmata = sword.getItemMeta();
                    swordmata.setDisplayName("killer sword");
                    sword.setItemMeta(swordmata);
                    player.setGameMode(GameMode.ADVENTURE);

                    player.getInventory().clear();
                    player.getInventory().setItem(4,sword);

                        //player.addPotionEffect(,true);


                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,9*20,150));
                        player.setAI(false);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,9*20,150));


                        World world = Bukkit.getWorld("Bayville"); ///execute in minecraft:bayville run tp @s -42.50 14.00 234.50 -179.91 -3.44
                        Location location = new Location(world, -42.50 ,500 ,234.50,-179 ,-3);
                        player.teleport(location);


                    ScoreboardManager manager = Bukkit.getScoreboardManager();
                    assert manager != null;
                    Scoreboard board = manager.getNewScoreboard();
                    Team team = board.registerNewTeam("AQUA");
                    team.setColor(AQUA);
                    team.addEntry(player.getDisplayName());
                    team.addEntry(player.getDisplayName());
                }
                }

            }.runTaskLater(this.plugin, 5 * 20);
            new BukkitRunnable() {

                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                        if(!plugin.hider.contains(p.getUniqueId())) return;
                        p.sendTitle("יש לכם 10 שניות להתחבאות!","");
                        p.setMaxHealth(2);
                    }
                }

            }.runTaskLater(this.plugin, 3*20);
            new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                        p.sendMessage("יש לכם 5 שניות להתחבאות!");
                    }
                }
            }.runTaskLater(this.plugin, 10*20);
            new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                        p.sendMessage("יש לכם 1 שניות להתחבאות!");
                        seeker.setAI(true);
                    }
                }
            }.runTaskLater(this.plugin, 14*20);
            new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                        p.sendMessage("יש לכם 2 שניות להתחבאות!");
                    }
                }
            }.runTaskLater(this.plugin, 13*20);
            new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                        p.sendMessage("יש לכם 3 שניות להתחבאות!");
                    }
                }
            }.runTaskLater(this.plugin, 12*20);
            new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!plugin.a_event_p_list.contains(p.getDisplayName())) return;
                        p.sendMessage("יש לכם 4 שניות להתחבאות!");
                    }
                }
            }.runTaskLater(this.plugin, 11*20);
            start_timer();

        } else if(command.getName() == "eventa_stop"){
            stopgame();

        }

        return false;
    }

    public void start_timer() {
        Bukkit.broadcastMessage("started timer");
            timer=true;
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("נגמר הזמן!");
                        plugin.timerstuff = -0;
                    }
                }
            }.runTaskLater(this.plugin, 15 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 1 דקות נשאר!");
                        plugin.timerstuff = 1;
                    }
                }
            }.runTaskLater(this.plugin, 14 * 1200);
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 2 דקות נשאר!");
                        plugin.timerstuff = 2;
                    }
                }
            }.runTaskLater(this.plugin, 13 * 1200);
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                    Bukkit.broadcastMessage("עוד 3 דקות נשאר!");
                    plugin.timerstuff = 3;
                    }
                }
            }.runTaskLater(this.plugin, 12 * 1200);
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 4 דקות נשאר!");
                        plugin.timerstuff = 4;
                    }
                }
            }.runTaskLater(this.plugin, 11 * 1200);
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 5 דקות נשאר!");
                        plugin.timerstuff = 5;
                    }
                }
            }.runTaskLater(this.plugin, 10 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 6 דקות נשאר!");
                        plugin.timerstuff = 6;
                    }
                }
            }.runTaskLater(this.plugin, 9 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 7 דקות נשאר!");
                        plugin.timerstuff = 7;
                    }
                }
            }.runTaskLater(this.plugin, 8 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 8 דקות נשאר!");
                        plugin.timerstuff = 8;
                    }
                }
            }.runTaskLater(this.plugin, 7 * 1200);


            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 9 דקות נשאר!");
                        plugin.timerstuff = 9;
                    }
                }
            }.runTaskLater(this.plugin, 6 * 1200);


            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 10 דקות נשאר!");
                        plugin.timerstuff = 10;
                    }
                }
            }.runTaskLater(this.plugin, 5 * 1200);


            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 11 דקות נשאר!");
                        plugin.timerstuff = 11;
                    }
                }
            }.runTaskLater(this.plugin, 4 * 1200);


            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 12 דקות נשאר!");
                        plugin.timerstuff = 12;
                    }
                }
            }.runTaskLater(this.plugin, 3 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 13 דקות נשאר!");
                        plugin.timerstuff = 13;
                    }
                }
            }.runTaskLater(this.plugin, 3 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 14 דקות נשאר!");
                        plugin.timerstuff = 14;
                    }
                }
            }.runTaskLater(this.plugin, 2 * 1200);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(timer) {
                        Bukkit.broadcastMessage("עוד 15 דקות נשאר!");
                        plugin.timerstuff = 15;
                    }
                }
            }.runTaskLater(this.plugin, 1200);

    }

    public void stop_timer(){
        timer=false;
    }

    public void stopgame(){

        for (Player p : Bukkit.getOnlinePlayers()){
            p.setMaxHealth(20);
            p.setGlowing(false);
        }

        for (int i = 0; i < plugin.seeker.size(); i++) {
            plugin.seeker.remove(i);
        }
        for (int i = 0; i < plugin.hider.size(); i++) {
            plugin.hider.remove(i);
        }
    }
    public static void endgame(Player winner){



    }
}















