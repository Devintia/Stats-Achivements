package net.devintia.stats;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stats extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.print( "Git test :)" );
        this.getServer().getPluginManager().registerEvents( this, this );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
