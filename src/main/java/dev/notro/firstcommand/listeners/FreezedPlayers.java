package dev.notro.firstcommand.listeners;

import dev.notro.firstcommand.CodeBaseCommands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class FreezedPlayers implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if (CodeBaseCommands.PlayerCollection.getFreezePlayers().contains(uuid))
        event.setCancelled(true);
    }
}
