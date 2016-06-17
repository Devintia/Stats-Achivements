package net.devintia.stats.Database;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

/**
 * Created by tom on 17.06.16.
 */
public class CreateUserPattern {

    public static void addUserToDB(){

        Statistic[] stats = Statistic.values();
        Bukkit.broadcastMessage(stats.toString());

    }

}
