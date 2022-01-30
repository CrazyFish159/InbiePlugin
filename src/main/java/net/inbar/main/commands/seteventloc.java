package net.inbar.main.commands;

import net.inbar.main.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class seteventloc implements CommandExecutor {

    Main plugin;

    public seteventloc(Main plugin) {
        this.plugin = plugin;
    }

    private final File file = new File("plugins/inbar_server/data/Location.yml");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("set-event")) {

            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            Location location = player.getLocation();
            config.set("some.path", location);
            player.sendMessage("ok!");

        }
        return true;
    }

}
