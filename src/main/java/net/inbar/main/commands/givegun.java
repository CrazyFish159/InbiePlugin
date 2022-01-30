package net.inbar.main.commands;

import net.inbar.main.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class givegun implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("give-gun")){

            if(!(sender instanceof Player)) {
                return false;
            } else {
                if(p.hasPermission("inbar.givegun")){
                    p.getInventory().addItem(ItemManager.gun);
                } else {
                    p.sendMessage(DARK_RED + "You dont have a permission for that!");
                }

            }

        }

        return false;
    }

}
