package net.inbar.main.events_system;

import net.inbar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.ChatColor.*;

public class setmax implements CommandExecutor {

    Main plugin;

    public setmax(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("smpoe")) {
            if (sender.hasPermission("inbar.smpoe")) {
                if(args.length > 0){
                    String str = args[0];
                    try{
                        int number = Integer.parseInt(str);
                        if(number > Bukkit.getServer().getMaxPlayers()){
                            sender.sendMessage(RED +  " you cant do that" + " the max players on the server is: " + Bukkit.getServer().getMaxPlayers() + " > " + number);
                            return false;
                        }
                        if(number == plugin.i_event_max){
                            sender.sendMessage(RED + "the max player already: " + plugin.i_event_max + "!");
                            return false;
                        }
                        if(number < -0){
                            sender.sendMessage(RED + "error!");
                            return false;
                        }
                        sender.sendMessage(GREEN + "you set the max player on events to: " + number + "!");
                        plugin.i_event_max = number;
                    }catch (NumberFormatException ex){
                        sender.sendMessage(RED + "error! " + "'" + args[0] + "'" + " is not a number!");
                        ex.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}