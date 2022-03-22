package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.utils.ColorUtils;
import dev.notro.firstcommand.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (command.getName().equalsIgnoreCase("god")) {
            if (!p.hasPermission(("codebase.god"))) {
                p.sendMessage(MessageUtils.NO_PERMISSION_MESSAGE);
                return true;
            }

           String GodEnabled = p.isInvulnerable() ? ColorUtils.color("&c&lDisabled") : ColorUtils.color("&a&lEnabled");

            if (!p.isInvulnerable()) p.setInvulnerable(true);
            else p.setInvulnerable(false);

            p.sendMessage(ColorUtils.color("&bGod mode has been ") + GodEnabled + ColorUtils.color("&b."));
            return true;

        }


        return true;
    }
}
