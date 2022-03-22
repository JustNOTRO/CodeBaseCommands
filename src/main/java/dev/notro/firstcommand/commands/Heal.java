package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.utils.ColorUtils;
import dev.notro.firstcommand.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (command.getName().equalsIgnoreCase("heal")) {
            if (!p.hasPermission("codebase.heal")) {
                p.sendMessage(MessageUtils.NO_PERMISSION_MESSAGE);
                return true;
            }

            double getHealth = p.getHealth();
            if (getHealth == 20) {
                p.sendMessage(ColorUtils.color("&bYou are already full &c&lHealth&b."));
                return true;
            }
            else p.setHealth(20);
            p.sendMessage(ColorUtils.color("&bYou have been &a&lHealed&b."));

        }
        return true;
    }
}
