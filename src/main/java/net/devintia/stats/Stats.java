package net.devintia.stats;

import net.devintia.stats.Database.CreateUserPattern;
import net.devintia.stats.listeners.PSIE;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stats extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.print( "Git test :)" );
        PSIE psie = new PSIE();
        getServer().getPluginManager().registerEvents( psie, this );

        Statistic[] stats = Statistic.values();
        Bukkit.broadcastMessage(stats.toString() + "HALLo");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
