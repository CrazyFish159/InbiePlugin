package net.inbar.main.events_system;

import net.inbar.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class list implements CommandExecutor {

    Main plugin;

    public list(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("elist")) {
            if (sender.hasPermission("inbar.elist")) {
                p.sendMessage(plugin.a_event_p_list.size() + plugin.a_event_p_list.get(0) + "");
            }
        }
        return false;
    }
}