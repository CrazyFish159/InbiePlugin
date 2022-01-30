package net.inbar.main.events_system;

import net.inbar.main.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {

    Main plugin;

    public start(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("start_event")) {
            if (sender.hasPermission("inbar.event.start")) {

                World world = player.getWorld();


            }

        }
        return false;
    }
}