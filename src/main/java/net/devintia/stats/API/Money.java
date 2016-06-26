package net.devintia.stats.API;

import net.devintia.stats.Stats;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tom on 25.06.16.
 */
public class Money {

    public static void addPlayer(UUID uuid){
        Stats.dbHandler.save( uuid, new DBMoney( 0 ) );
    }

    public static void addMoney( UUID uuid, int i){
        Stats.dbHandler.update( uuid, new DBMoney( getMoney( uuid )+i ) );
    }
    public static int getMoney( UUID uuid){
        return Integer.parseInt( Stats.dbHandler.get( uuid ).toString() );
    }
    public static void removeMoney( UUID uuid ){
        Stats.dbHandler.delete( uuid );
    }

}

class DBMoney implements ConfigurationSerializable{

    int money;
    public DBMoney( int value ){
        money = value;
    }
    public DBMoney( Map<String, Object> data){
        money = (int)data.get( "money" );
    }
    @Override
    public Map<String, Object> serialize(){
        Map<String, Object> map = new HashMap<>(  );
        map.put( "money", money );
        return map;
    }

}