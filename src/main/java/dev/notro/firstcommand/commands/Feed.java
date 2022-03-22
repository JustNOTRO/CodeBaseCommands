package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.utils.ColorUtils;
import dev.notro.firstcommand.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof  Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (command.getName().equalsIgnoreCase("feed")) {
            if (!p.hasPermission("codebase.feed")) {
                p.sendMessage(MessageUtils.NO_PERMISSION_MESSAGE);
                return true;
            }

            int foodlevel = p.getFoodLevel();
            if (foodlevel == 20) {
                p.sendMessage(ColorUtils.color("&cYou already have been &b&lFed&b."));
                return true;
            }

            else p.setFoodLevel(20);
            p.sendMessage(ColorUtils.color("&bYou have been &c&lFed&b."));

        }

        return true;
    }
}
