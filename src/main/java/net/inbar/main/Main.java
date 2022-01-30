package net.inbar.main;

import net.inbar.main.commands.*;
import net.inbar.main.Listner.*;
import net.inbar.main.events_system.*;
import net.inbar.main.file.config;
import net.inbar.main.hideandsik.*;
import net.inbar.main.inventoryMeneger.invevent;
import net.inbar.main.items.ItemEvent;
import net.inbar.main.items.ItemManager;
import net.inbar.main.tasks.Task_1;
import net.inbar.main.tasks.star_glow;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.UUID;

//import sun.jvm.hotspot.code.CompressedStream.*;

public final class Main extends JavaPlugin {

    public int timerstuff=15;
    public boolean started = false;

    public ArrayList<Player> waiting = new ArrayList<Player>();
    public ArrayList<Player> seeker = new ArrayList<Player>();
    public ArrayList<Player> hider = new ArrayList<Player>();
    public ArrayList<Player> hider_die = new ArrayList<Player>();


    public ArrayList<String> a_event_p_list = new ArrayList<String>();
    public ArrayList<UUID> a_gun_normal = new ArrayList<UUID>();
    public ArrayList<UUID> a_gun_VIP = new ArrayList<UUID>();
    public ArrayList<UUID> a_gun_VIP_ = new ArrayList<UUID>();
    public ArrayList<UUID> a_gun_capara = new ArrayList<UUID>();
    public ArrayList<UUID> a_gun_capara_ = new ArrayList<UUID>();
    public ArrayList<UUID> a_gun_ionit = new ArrayList<UUID>();
    public ArrayList<UUID> a_gun_ionit_ = new ArrayList<UUID>();

    public ArrayList<UUID> a_2gun_normal = new ArrayList<UUID>();
    public ArrayList<UUID> a_2gun_VIP = new ArrayList<UUID>();
    public ArrayList<UUID> a_2gun_VIP_ = new ArrayList<UUID>();
    public ArrayList<UUID> a_2gun_capara = new ArrayList<UUID>();
    public ArrayList<UUID> a_2gun_capara_ = new ArrayList<UUID>();
    public ArrayList<UUID> a_2gun_ionit = new ArrayList<UUID>();
    public ArrayList<UUID> a_2gun_ionit_ = new ArrayList<UUID>();
    public boolean b_event_open = false;
    public int i_event_max = 100;

    public void removeformallgun(UUID UUID){
        a_gun_normal.remove(UUID);
        a_gun_VIP.remove(UUID);
        a_gun_VIP_.remove(UUID);
        a_gun_capara.remove(UUID);
        a_gun_capara_.remove(UUID);
        a_gun_ionit.remove(UUID);
        a_gun_ionit_.remove(UUID);
    }

    public void removeformallgun2(UUID UUID){
        a_2gun_normal.remove(UUID);
        a_2gun_VIP.remove(UUID);
        a_2gun_VIP_.remove(UUID);
        a_2gun_capara.remove(UUID);
        a_2gun_capara_.remove(UUID);
        a_2gun_ionit.remove(UUID);
        a_2gun_ionit_.remove(UUID);
    }

    public void regstercmd(){
            getCommand("tutorial").setExecutor(new tutorial());
            getCommand("set-tutorial").setExecutor(new setts());
            getCommand("setlobby").setExecutor(new set_lobby());
            getCommand("alert").setExecutor(new alert());
            getCommand("givewither").setExecutor(new TutorialCommands());
            getCommand("enable-event").setExecutor(new close_a_close_events(this));
            getCommand("disable-event").setExecutor(new close_a_close_events(this));
            getCommand("set-event").setExecutor(new seteventloc(this));
            getCommand("events").setExecutor(new event_join(this));
            getCommand("give-gun").setExecutor(new givegun());
            getCommand("holo").setExecutor(new holo(this));
            getCommand("hunger-lob").setExecutor(new hglob(this));
            getCommand("inbar_reload").setExecutor(new reload(this));
            getCommand("lobby").setExecutor(new lobby(this));
            getCommand("elist").setExecutor(new list(this));
            getCommand("smpoe").setExecutor(new setmax(this));
            getCommand("start").setExecutor(new starte(this));
            getCommand("survivalgame").setExecutor(new survivalgame());
        getCommand("test").setExecutor(new testcmd(this));
        getCommand("eventa_start").setExecutor(new command_maneger(this));
        getCommand("eventa_stop").setExecutor(new command_maneger(this));
        //getCommand("stoptask").setExecutor(new Task_1(this));
        //getCommand("starttask").setExecutor(new Task_1(this));
        }

        public void regsterevent(){
            getServer().getPluginManager().registerEvents(new joine(this), this);
            getServer().getPluginManager().registerEvents(new ItemEvent(this), this);
            getServer().getPluginManager().registerEvents(new time_event(), this);
            getServer().getPluginManager().registerEvents(new invevent(this), this);
            getServer().getPluginManager().registerEvents(new teleport(this), this);
            getServer().getPluginManager().registerEvents(new worlde(this), this);
            getServer().getPluginManager().registerEvents(new invmoment(), this);
            getServer().getPluginManager().registerEvents(new plots_gmc(), this);
            getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
            getServer().getPluginManager().registerEvents(new netherportal(), this);
            getServer().getPluginManager().registerEvents(new events(this), this);

        }

        public void regsteritem(){
            ItemManager.init();
        }

        public void regsterrecipe(){
            ItemStack result = new ItemStack(Material.ANCIENT_DEBRIS, 1);
            NamespacedKey key = new NamespacedKey(this, "ANCIENT_DEBRIS");
            ShapedRecipe netheringot = new ShapedRecipe(key ,result);
            netheringot.shape(
                    "DDD",
                    "GTD",
                    "GGG" );
            netheringot.setIngredient('D', Material.DIAMOND);
            netheringot.setIngredient('T', Material.DIAMOND_BLOCK);
            netheringot.setIngredient('G', Material.GOLD_INGOT);
            Bukkit.addRecipe(netheringot);
//--------------------------------------------------------------------------------------------------------------------
            ItemStack result_2 = (ItemManager.wither);
            NamespacedKey key1 = new NamespacedKey(this, "wither");
            ShapedRecipe wither = new ShapedRecipe(key1 ,result_2);
            wither.shape(
                    "EEE",
                    "BTB",
                    "GHG" );
            wither.setIngredient('E', Material.ENDER_PEARL);
            wither.setIngredient('T', Material.NETHERITE_CHESTPLATE);
            wither.setIngredient('B', Material.OBSIDIAN);
            wither.setIngredient('H', Material.COAL);
            wither.setIngredient('G', Material.BONE);
            Bukkit.addRecipe(wither);
//--------------------------------------------------------------------------------------------------------------------
            ItemStack result_3 = new ItemStack(Material.BLAZE_ROD, 1);
            NamespacedKey key2 = new NamespacedKey(this, "BLAZE_ROD");
            ShapedRecipe blaze = new ShapedRecipe(key2 ,result_3);
            blaze.shape(
                    "  i",
                    " i ",
                    "   " );
            blaze.setIngredient('i', Material.GOLD_NUGGET);
            Bukkit.addRecipe(blaze);
//--------------------------------------------------------------------------------------------------------------------
            ItemStack result_4 = new ItemStack(Material.NETHER_WART, 1);
            NamespacedKey key5 = new NamespacedKey(this, "NETHER_WART");
            ShapedRecipe netherwart = new ShapedRecipe(key5 ,result_4);
            netherwart.shape(
                    " i ",
                    " e ",
                    "   " );
            netherwart.setIngredient('i', Material.SWEET_BERRIES);
            netherwart.setIngredient('e', Material.RED_DYE);
            Bukkit.addRecipe(netherwart);
//--------------------------------------------------------------------------------------------------------------------
            ItemStack result_5 = new ItemStack(Material.ELYTRA, 1);
            NamespacedKey key6 = new NamespacedKey(this, "elytra");
            ShapedRecipe elytra = new ShapedRecipe(key6 ,result_5);
            elytra.shape(
                    "zaw",
                    "fnf",
                    "nnn" );
            elytra.setIngredient('z', Material.ZOMBIE_HEAD);
            elytra.setIngredient('a', Material.GOLDEN_APPLE);
            elytra.setIngredient('w', Material.PHANTOM_MEMBRANE);
            elytra.setIngredient('f', Material.FIREWORK_ROCKET);
            elytra.setIngredient('n', Material.NETHERITE_BLOCK);
            Bukkit.addRecipe(elytra);
//--------------------------------------------------------------------------------------------------------------------
        }

        @Override
        public void onEnable() {
            System.out.println("[inbar] " +  "Loding");
            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
                System.out.println("hook into PlaceHolderAPI");
            } else {
                getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
                Bukkit.getPluginManager().disablePlugin(this);
            }
            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
                new PluginPlaceholder(this).register();
            }
            BukkitTask task = new star_glow().runTaskTimer(this, 0L,1L);
            BukkitTask task2 = new Task_1(this).runTaskTimer(this, 0L,7200 * 1000);
            regstercmd();
            regsterevent();
            regsteritem();
            regsterrecipe();
            System.out.println("[inbar] " +  "Loding Config");
            config.setup();
            config.get().addDefault("lobby-world","world");
            config.save();
            System.out.println("[inbar] plugin enabled!");
        }

        @Override
        public void onDisable() {
            System.out.println("[inbar] " + "Disableing plugin");
            System.out.println("[inbar] " + "Good bye!");

            for(Player p : Bukkit.getOnlinePlayers()){
                p.getInventory().remove(ItemManager.gun);
            }
        }


    }
