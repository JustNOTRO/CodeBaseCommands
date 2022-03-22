package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.utils.ColorUtils;
import dev.notro.firstcommand.utils.MessageUtils;
import org.apache.logging.log4j.message.Message;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (!p.hasPermission("codebase.gamemode")) {
            p.sendMessage(MessageUtils.NO_PERMISSION_MESSAGE);
            return true;
        }

        switch (command.getName().toLowerCase()) {
            case "gmc":
                if (p.getGameMode().equals(GameMode.CREATIVE)) {
                    p.sendMessage(ColorUtils.color("&cYou are already on Game mode &9&lCreative&b."));
                    return true;

                }
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ColorUtils.color("&bSet own game mode to &9&lCreative&b."));
                break;

            case "gma":
                if (p.getGameMode().equals(GameMode.ADVENTURE)) {
                    p.sendMessage(ColorUtils.color("&cYou are already on Game mode &9&lAdventure&b."));
                    return true;
                }
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ColorUtils.color("&bSet own game mode to &9&lAdventure&b."));
                break;

            case "gms":
                if (p.getGameMode().equals(GameMode.SURVIVAL)) {
                    p.sendMessage(ColorUtils.color("&cYou are already on Game mode &9&lSurvival&b."));
                    return true;
                }
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ColorUtils.color("&bSet own game mode to &9&lSurvival&b."));
                break;

            case "gmsp":
                if (p.getGameMode().equals(GameMode.SPECTATOR)) {
                    p.sendMessage(ColorUtils.color("&cYou are already on Game mode &9&lSpectator&b."));
                    return true;
                }
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ColorUtils.color("&bSet own game mode to &9&lSpectator&b."));
                break;

        }
        return true;
    }
}
