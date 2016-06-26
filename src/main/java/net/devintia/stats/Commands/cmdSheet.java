package net.devintia.stats.Commands;


import net.devintia.stats.Stats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by tom on 25.06.16.
 */
public class cmdSheet implements CommandExecutor {

    @SuppressWarnings("unused")
    private Stats plugin;

    public cmdSheet(Stats plugin) {
        this.plugin = plugin;
    }


    public boolean onCommand( CommandSender cs, Command cmd, String label, String[] args) {

        return false;
    }

}