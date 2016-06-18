package net.devintia.stats;

import net.devintia.stats.StatManagers.StatType;
import net.devintia.stats.listeners.PSIE;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stats extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PSIE psie = new PSIE();
        getServer().getPluginManager().registerEvents( psie, this );

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
