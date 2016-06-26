package net.devintia.stats.Commands;


import net.devintia.stats.API.Money;
import net.devintia.stats.Stats;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by tom on 25.06.16.
 */
public class cmdMoney implements CommandExecutor {

    @SuppressWarnings( "unused" )
    private Stats plugin;

    public cmdMoney( Stats plugin ) {
        this.plugin = plugin;
    }


    public boolean onCommand( CommandSender cs, Command cmd, String label, String[] args ) {
        if ( label.equalsIgnoreCase( "money" ) ) {
            if ( args.length != 0 ) {
                if ( args[0].equalsIgnoreCase( "get" ) ) {
                    if ( args.length == 2 ) {
                        UUID tUUID = Bukkit.getOfflinePlayer( args[1] ).getUniqueId();
                        cs.sendMessage( Stats.getGPrefix() + args[1] + "'s Balance is " + Money.getMoney( tUUID ) );
                    } else if ( args.length == 1 && cs instanceof Player ) {
                        cs.sendMessage( Stats.getGPrefix() + "Your Balance is " + Money.getMoney( ( (Player) cs ).getUniqueId() ) );
                    } else {
                        cs.sendMessage( Stats.getGPrefix() + "Sorry. This Command is only for Players" );
                    }
                }if(args[0].equalsIgnoreCase( "add" )){
                    if ( args.length == 3) {
                        if( Stats.isInt( args[2] )) {
                            UUID tUUID = Bukkit.getOfflinePlayer( args[1] ).getUniqueId();
                            cs.sendMessage( Stats.getGPrefix() + "Added " + args[2] + " to " + args[1] + "Balance. Its now " + Money.getMoney( tUUID ) );
                        }else{
                            cs.sendMessage( Stats.getGPrefix() + "The Value to add is no Integer. It has to be a normal number" );
                        }
                    } else if ( args.length == 2 && cs instanceof Player ) {
                        cs.sendMessage( Stats.getGPrefix() + "Added " + args[1] + " to your Balance. You now have " + Money.getMoney( ( (Player) cs ).getUniqueId() ) );
                    } else {
                        cs.sendMessage( Stats.getGPrefix() + "Sorry. This Command is only for Players" );
                    }
                }
                } else {
                    cs.sendMessage( Stats.getGPrefix() + "You need at least one Argument to perform this Command!" );
            }
            return true;
        }
        return false;
    }

}