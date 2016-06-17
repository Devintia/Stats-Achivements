package net.devintia.stats.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

/**
 * Created by tom on 17.06.16.
 */
public class PSIE implements Listener {

    @EventHandler
    public void onPSIE( PlayerStatisticIncrementEvent e){

        Player p = e.getPlayer();
        Bukkit.broadcastMessage( e.getStatistic().toString());
        Bukkit.broadcastMessage( e.getPlayer().getStatistic( Statistic.WALK_ONE_CM ) + "");

    }

}
