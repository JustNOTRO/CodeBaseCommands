package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.utils.ColorUtils;
import dev.notro.firstcommand.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class Vanish implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (command.getName().equalsIgnoreCase("vanish")) {
            if (!p.hasPermission("codebase.vanish")) {
                p.sendMessage(MessageUtils.NO_PERMISSION_MESSAGE);
                return true;
            }

            String isVanished = p.isInvisible() ? ColorUtils.color("&a&lVisible") : ColorUtils.color("&c&lInvisible");
            if (!p.isInvisible()) p.setInvisible(true);
            else p.setInvisible(false);
            p.sendMessage(ColorUtils.color("&bYou are now " + isVanished + ColorUtils.color("&b.")));
            return true;

        }

        return true;
    }
}
