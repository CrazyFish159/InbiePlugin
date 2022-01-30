package net.inbar.main;


import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.inbar.main.file.config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PluginPlaceholder extends PlaceholderExpansion {
    private Main plugin;

    public PluginPlaceholder(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier(){
        return "inbar";
    }

    @Override
    public String getVersion(){
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){

        if(player == null){
            return "";
        }

        // %inbar_event%
        if(identifier.equals("event")){
            if(this.plugin.b_event_open){
                return (String) config.get().get("events-open","&2&l✓&r סטטוס:&a&l האיוונט פתוח");
            } else {
                return (String) config.get().get("events-close","&7סטטוס: &c&lסגור &4&l✗");
            }
            // %inbar_events%
        } else if(identifier.equals("events")){
            return ChatColor.translateAlternateColorCodes('&',"&7אנשים מחוברים:&3&l " + this.plugin.a_event_p_list.size() + "/" + plugin.i_event_max) + "";
        } else if (identifier.equals("seekers")) {
            //if(plugin.seeker.get(0))
            if(!plugin.seeker.isEmpty()){
                return (plugin.seeker.get(0).getDisplayName());
            } else {
                return "אין!";
            }

        } else if(identifier.equalsIgnoreCase("timer")){
            if(plugin.started = true){
            return plugin.timerstuff + "";
        } else {
                return "ממתין לשחקנים נוספים!";
            }
        }
        return null;
    }
}