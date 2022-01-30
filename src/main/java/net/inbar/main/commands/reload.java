package net.inbar.main.commands;

import net.inbar.main.Main;
import net.inbar.main.file.config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reload  implements CommandExecutor {

    Main plugin;

    public reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("inbar_reload")) {
            config.reload();
            p.sendMessage("ok sir!");
        }
        return false;
    }
}