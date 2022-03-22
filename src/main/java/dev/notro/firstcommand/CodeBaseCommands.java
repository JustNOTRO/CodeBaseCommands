package dev.notro.firstcommand;

import dev.notro.firstcommand.commands.*;
import dev.notro.firstcommand.listeners.FreezedPlayers;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;


public class CodeBaseCommands extends JavaPlugin {

    @Getter
    private static CodeBaseCommands instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "CodeBaseCommands has been Enabled");
        getCommand("fly").setExecutor(new Fly());
        getCommand("god").setExecutor(new God());
        getCommand("heal").setExecutor(new Heal());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gma").setExecutor(new Gamemode());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());
        getCommand("feed").setExecutor(new Feed());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("freeze").setExecutor(new Freeze());
        Bukkit.getPluginManager().registerEvents(new FreezedPlayers(), this);

    }

    public static class PlayerCollection {

        @Getter
        private static final ArrayList<UUID>
                freezePlayers = new ArrayList<>();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "CodeBaseCommands has been Disabled");
    }

}

