package net.inbar.main.hideandsik;

import net.inbar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Random;

public class task_1 extends BukkitRunnable {

    Main plugin;

    public task_1(Main plugin) {
        this.plugin = plugin;
    }

    public static void randomplayer(Player p){
        ArrayList<Player> p2 = new ArrayList<>(Bukkit.getOnlinePlayers());
        int random = new Random().nextInt(p2.size());
        Player player = p2.get(random);
        p.sendMessage(random + "");
        player.setGlowing(true);
        p.sendTitle("משהו נבחר!",player.getDisplayName());

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team team = board.registerNewTeam("blueTeam");
        team.setColor(ChatColor.BLUE);
        team.addEntry(player.getUniqueId().toString());

    }

    @Override
    public void run() {
        //randomplayer();
    }

}
