package net.inbar.main.inventoryMeneger;

import net.inbar.main.file.config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class invMeneger {

    public static void openInventory_selctor(Player player){
        player.getOpenInventory().close();
        Inventory inv = Bukkit.createInventory(player, 27, ChatColor.translateAlternateColorCodes('&', "Particle Gun Selector"));

            ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemMeta m0 = fill.getItemMeta();
            m0.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&k"));
            fill.setItemMeta(m0);

            ItemStack trial_sel = new ItemStack(Material.RAIL);
            ItemMeta m1 = trial_sel.getItemMeta();
            m1.setDisplayName("שביל");
            trial_sel.setItemMeta(m1);

            ItemStack exppload_sel = new ItemStack(Material.TNT);
            ItemMeta m2 = exppload_sel.getItemMeta();
            m2.setDisplayName("פיצוץ");
            exppload_sel.setItemMeta(m2);

            ItemStack close = new ItemStack(Material.RED_DYE);
            ItemMeta m3 = close.getItemMeta();
            m3.setDisplayName("סגור");
            close.setItemMeta(m3);


            for (int i = 0; i < (int) config.get().get("inv-size", 27); i++) {
                inv.setItem(i, fill);
            }

            inv.setItem(11,trial_sel);
            inv.setItem(15,exppload_sel);
            inv.setItem(26,close);

            player.openInventory(inv);

    }

    public static void openInventory_trials(Player player) {
        player.getOpenInventory().close();
        Inventory inv = Bukkit.createInventory(player, 27, ChatColor.translateAlternateColorCodes('&', "Particle Gun Selector: trail"));

        ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta m0 = fill.getItemMeta();
        m0.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&k"));
        fill.setItemMeta(m0);

        ItemStack no_perms = new ItemStack(Material.GRAY_DYE);
        ItemMeta m1 = no_perms.getItemMeta();
        m1.setDisplayName("you dont have perms for that!");
        no_perms.setItemMeta(m1);
        ItemStack normal = new ItemStack(Material.ORANGE_DYE);
        ItemMeta m2 = normal.getItemMeta();
        m2.setDisplayName("normal");
        normal.setItemMeta(m2);
        ItemStack VIP = new ItemStack(Material.PURPLE_DYE);
        ItemMeta m3 = VIP.getItemMeta();
        m3.setDisplayName("vip");
        VIP.setItemMeta(m3);
        ItemStack VIP_ = new ItemStack(Material.BLUE_DYE);
        ItemMeta m4 = VIP_.getItemMeta();
        m4.setDisplayName("vip+");
        VIP_.setItemMeta(m4);
        ItemStack capara = new ItemStack(Material.YELLOW_DYE);
        ItemMeta m5 = capara.getItemMeta();
        m5.setDisplayName("capara");
        capara.setItemMeta(m5);
        ItemStack capara_ = new ItemStack(Material.GREEN_DYE);
        ItemMeta m6 = capara_.getItemMeta();
        m6.setDisplayName("capara+");
        capara_.setItemMeta(m6);
        ItemStack ionit = new ItemStack(Material.BROWN_DYE);
        ItemMeta m7 = ionit.getItemMeta();
        m7.setDisplayName("i on it");
        ionit.setItemMeta(m7);
        ItemStack ionit_ = new ItemStack(Material.PINK_DYE);
        ItemMeta m8 = no_perms.getItemMeta();
        m8.setDisplayName("i on it +");
        ionit_.setItemMeta(m8);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta m9 = back.getItemMeta();
        m9.setDisplayName("go back");
        back.setItemMeta(m9);

        for (int i = 0; i < (int) config.get().get("inv-size", 27); i++) {
            inv.setItem(i, fill);
        }
        if (!player.hasPermission("inbargun.normal")) inv.setItem(10, no_perms); else
            inv.setItem(10, normal);
        if (!player.hasPermission("inbargun.VIP")) inv.setItem(11, no_perms); else
            inv.setItem(11, VIP);
        if (!player.hasPermission("inbargun.VIP+")) inv.setItem(12, no_perms); else
            inv.setItem(12, VIP_);
        if (!player.hasPermission("inbargun.capara")) inv.setItem(13, no_perms); else
            inv.setItem(13, capara);
        if (!player.hasPermission("inbargun.capara+")) inv.setItem(14, no_perms); else
            inv.setItem(14, capara_);
        if (!player.hasPermission("inbargun.ionit")) inv.setItem(15, no_perms); else
            inv.setItem(15, ionit);
        if (!player.hasPermission("inbargun.ionit+")) inv.setItem(16, no_perms); else
            inv.setItem(16, ionit_);
        inv.setItem(26, back);


        player.openInventory(inv);

    }


    public static void openInventory_explosion(Player player){
        player.getOpenInventory().close();
        Inventory inv = Bukkit.createInventory(player, 27, ChatColor.translateAlternateColorCodes('&', "Particle Gun Selector: explosion"));

        ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta m0 = fill.getItemMeta();
        m0.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&k"));
        fill.setItemMeta(m0);

        ItemStack no_perms = new ItemStack(Material.GRAY_DYE);
        ItemMeta m1 = no_perms.getItemMeta();
        m1.setDisplayName("you dont have perms for that!");
        no_perms.setItemMeta(m1);
        ItemStack normal = new ItemStack(Material.ORANGE_DYE);
        ItemMeta m2 = normal.getItemMeta();
        m2.setDisplayName("normal");
        normal.setItemMeta(m2);
        ItemStack VIP = new ItemStack(Material.PURPLE_DYE);
        ItemMeta m3 = VIP.getItemMeta();
        m3.setDisplayName("vip");
        VIP.setItemMeta(m3);
        ItemStack VIP_ = new ItemStack(Material.BLUE_DYE);
        ItemMeta m4 = VIP_.getItemMeta();
        m4.setDisplayName("vip+");
        VIP_.setItemMeta(m4);
        ItemStack capara = new ItemStack(Material.YELLOW_DYE);
        ItemMeta m5 = capara.getItemMeta();
        m5.setDisplayName("capara");
        capara.setItemMeta(m5);
        ItemStack capara_ = new ItemStack(Material.GREEN_DYE);
        ItemMeta m6 = capara_.getItemMeta();
        m6.setDisplayName("capara+");
        capara_.setItemMeta(m6);
        ItemStack ionit = new ItemStack(Material.BROWN_DYE);
        ItemMeta m7 = ionit.getItemMeta();
        m7.setDisplayName("i on it");
        ionit.setItemMeta(m7);
        ItemStack ionit_ = new ItemStack(Material.PINK_DYE);
        ItemMeta m8 = no_perms.getItemMeta();
        m8.setDisplayName("i on it +");
        ionit_.setItemMeta(m8);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta m9 = back.getItemMeta();
        m9.setDisplayName("go back");
        back.setItemMeta(m9);

        for (int i = 0; i < (int) config.get().get("inv-size", 27); i++) {
            inv.setItem(i, fill);
        }
        if (!player.hasPermission("inbargun.normal")) inv.setItem(10, no_perms);
        else
            inv.setItem(10, normal);
        if (!player.hasPermission("inbargun.VIP")) inv.setItem(11, no_perms);
        else
            inv.setItem(11, VIP);
        if (!player.hasPermission("inbargun.VIP+")) inv.setItem(12, no_perms);
        else
            inv.setItem(12, VIP_);
        if (!player.hasPermission("inbargun.capara")) inv.setItem(13, no_perms);
        else
            inv.setItem(13, capara);
        if (!player.hasPermission("inbargun.capara+")) inv.setItem(14, no_perms);
        else
            inv.setItem(14, capara_);
        if (!player.hasPermission("inbargun.ionit")) inv.setItem(15, no_perms);
        else
            inv.setItem(15, ionit);
        if (!player.hasPermission("inbargun.ionit+")) inv.setItem(16, no_perms);
        else
            inv.setItem(16, ionit_);
        inv.setItem(26, back);

        player.openInventory(inv);
    }

}
