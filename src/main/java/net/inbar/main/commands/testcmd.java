package net.inbar.main.commands;

import net.inbar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class testcmd implements CommandExecutor {

    Main plugin;

    public testcmd(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
        Player p = (Player) sender;


        p.sendMessage("testing...");

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(p.getName());
        meta.setDisplayName(p.getDisplayName() + " Skull");
        skull.setItemMeta(meta);
        p.getEquipment().setHelmet(skull);

        p.sendMessage("testing.");
        return false;
    }
}
