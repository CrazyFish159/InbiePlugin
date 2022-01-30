package net.inbar.main.Listner;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.time.LocalDateTime;


public class time_event implements Listener {

    LocalDateTime now = LocalDateTime.now();
    int h = now.getHour();
    int m = now.getMinute();
    int s = now.getSecond();
    int hm = 00;
    int mm = 00;
    int sm = 00;

    public void infiniteLoopUsingWhile() {
        while (true) {
            if(now.getHour() == 17 || now.getMinute() == 57){

                Bukkit.broadcastMessage("the time now is 16:55");
            }
        }
    }

}
