package net.inbar.main.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;


public class ItemManager {

    public static ItemStack wither;
    public static ItemStack gun;
    public static ItemStack beck_to_lob;

    public static void init() {
        createwither();
        createParticleGun();
        create_beck_to_lob();
    }

    public static void createwither() {
        ItemStack item = new ItemStack(Material.BAT_SPAWN_EGG, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("wither spawn egg");
        item.setItemMeta(meta);
        wither = item;
        System.out.println(item.getItemMeta().getDisplayName() + " item been created!");
    }


    private static void createParticleGun(){
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§lרובה פארטיקלס");
        item.setItemMeta(meta);
        gun = item;
        System.out.println(item.getItemMeta().getDisplayName() + " item been created!");

    }

    private static void create_beck_to_lob(){
        ItemStack item = new ItemStack(Material.GREEN_BED, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('§',"§c§lחזרה ללובי"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "לחיצה ימינית להשתגרות ללובי");
        meta.setLore(lore);
        item.setItemMeta(meta);
        beck_to_lob = item;
        System.out.println(item.getItemMeta().getDisplayName() + " item been created!");

    }

}