package net.inbar.main.commands;

import net.inbar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class lobby implements CommandExecutor {

    Main plugin;

    public lobby(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("lobby")) {
            World world = Bukkit.getWorld("TrestiaMap");
            Location loc = new Location(world,213.50,40.17,-339.50,-89,-0);
            player.teleport(loc);
            if(this.plugin.a_event_p_list.contains(player.getDisplayName())){
                plugin.a_event_p_list.remove(player.getDisplayName());

            } else {

            }
        }
        return false;
    }

}
