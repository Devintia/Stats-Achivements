package net.devintia.stats;

import lombok.Getter;
import net.devintia.db.DbHandlerFactory;
import net.devintia.db.DbType;
import net.devintia.stats.listeners.PSIE;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import net.devintia.db.DbHandler;

import java.util.HashMap;
import java.util.Map;

public final class Stats extends JavaPlugin implements Listener {

    @Getter
    private DbHandler dbHandler;

    @Override
    public void onEnable() {
        PSIE psie = new PSIE();
        getServer().getPluginManager().registerEvents( psie, this );

        dbHandler = DbHandlerFactory.getNewDbHandler( DbType.YAML ); //YAML for test purposes
        dbHandler.init();

        dbHandler.save( "key", new DBTest( "test", 1 ) );
        DBTest test = (DBTest) dbHandler.get( "key" );
        if ( test.testString.equals( "test" ) && test.testInt == 1 ) {
            System.out.println( "sucess!" );
        } else {
            System.out.println( "fail!" );
        }
        dbHandler.update( "key", new DBTest( "test2", 2 ) );
        test = (DBTest) dbHandler.get( "key" );
        if ( test.testString.equals( "test2" ) && test.testInt == 2 ) {
            System.out.println( "sucess!" );
        } else {
            System.out.println( "fail!" );
        }

    }

    class DBTest implements ConfigurationSerializable{

        String testString;
        int testInt;

        public DBTest( String s, int i ) {
            testString = s;
            testInt = i;
        }

        public DBTest( Map<String, Object> data ) {
            testInt = (int) data.get( "testInt" );
            testString = (String) data.get( "testString" );
        }

        @Override
        public Map<String, Object> serialize() {
            Map<String, Object> map = new HashMap<>();
            map.put( "testInt", testInt );
            map.put( "testString", testString );
            return map;
        }
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
