package net.devintia.stats;

import lombok.Getter;
import net.devintia.db.DbHandlerFactory;
import net.devintia.db.DbType;
import net.devintia.stats.API.Money;
import net.devintia.stats.listeners.PSIE;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import net.devintia.db.DbHandler;

import java.util.HashMap;
import java.util.Map;

public final class Stats extends JavaPlugin implements Listener {

    @Getter
    public static DbHandler dbHandler;

    @Override
    public void onEnable() {

        dbHandler = DbHandlerFactory.getNewDbHandler( DbType.YAML ); //YAML for test purposes
        dbHandler.init();
        getServer().getPluginManager().registerEvents( this, this );

    }

    @Override
    public void onDisable() {
        dbHandler.cleanUp();
        dbHandler = null;
    }

    @EventHandler
    public void onJoin( PlayerJoinEvent e){
        if(dbHandler.get( e.getPlayer() ) == null){
            e.getPlayer().sendMessage( getGPrefix() + "Welcome. You were added to the Money Database" );
            Money.addPlayer( e.getPlayer().getUniqueId() );
        }else{
            e.getPlayer().sendMessage( getGPrefix()+"Welcome back! You have " + Money.getMoney( e.getPlayer().getUniqueId()) );
        }
    }

    public static ComponentBuilder getGPrefix() {
        return new ComponentBuilder( "Devintia" ).color( ChatColor.BLUE ).append( "> " ).color( ChatColor.GRAY );
    }
    public static ComponentBuilder getPrefix() {
        return new ComponentBuilder( "Stats" ).color( ChatColor.BLUE ).append( "> " ).color( ChatColor.LIGHT_PURPLE );
    }

    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException nFE) {
            return false;
        }
        return true;
    }


}
