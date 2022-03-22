package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.utils.MessageUtils;
import dev.notro.firstcommand.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof  Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (command.getName().equalsIgnoreCase("fly")) {
            if (!p.hasPermission("codebase.fly")) {
                p.sendMessage((MessageUtils.NO_PERMISSION_MESSAGE));
                return true;
            }

            String isEnabled = p.getAllowFlight() ? ColorUtils.color("&c&lDisabled") : ColorUtils.color("&a&lEnabled");

            if (!p.getAllowFlight()) p.setAllowFlight(true);
            else p.setAllowFlight(false);
            p.sendMessage(ColorUtils.color("&bYour flying ability has been " + isEnabled + ColorUtils.color("&b.")));


            return true;

        }

        return true;
    }
}
