package net.inbar.main.parkur;

import org.bukkit.scheduler.BukkitRunnable;

import static net.inbar.main.parkur.setParkur.*;

public class Parkur_Task extends BukkitRunnable {
    @Override
    public void run() {
        int random = (int)(Math.random() * 6);
        switch(random) {
            case 1:
                set_parkur_int_1();
                break;
            case 2:
                set_parkur_int_2();
                break;
            case 3:
                set_parkur_int_3();
                break;
            case 4:
                set_parkur_int_4();
                break;
            case 5:
                set_parkur_int_5();
                break;
            default:
                break;
        }
    }
}
