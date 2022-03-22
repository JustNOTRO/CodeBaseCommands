package dev.notro.firstcommand.commands;

import dev.notro.firstcommand.CodeBaseCommands;
import dev.notro.firstcommand.utils.ColorUtils;
import dev.notro.firstcommand.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Freeze implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(MessageUtils.NO_SENDER_EXECUTER);
            return true;
        }

        if (command.getName().equalsIgnoreCase("freeze")) {
            if (!p.hasPermission("codebase.freeze")) {
                p.sendMessage(MessageUtils.NO_PERMISSION_MESSAGE);
                return true;
            }

            if (args.length == 0) {
                p.sendMessage(MessageUtils.NO_DESCRIBED_PLAYER);
                return true;
            }

            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                p.sendMessage(MessageUtils.NO_PLAYER_EXISTENCE);
                return true;
            }

            UUID uuid = target.getUniqueId();
            String name = p.getName();

            if (!CodeBaseCommands.PlayerCollection.getFreezePlayers().contains(uuid)) {
                CodeBaseCommands.PlayerCollection.getFreezePlayers().add(uuid);
                target.sendMessage(ColorUtils.color("&bYou are now &9&lFrozen &bby &9&l" + name + ColorUtils.color("&b.")));
                return true;
            }

            else CodeBaseCommands.PlayerCollection.getFreezePlayers().remove(uuid);
            target.sendMessage(ColorUtils.color("&bYou are now &9&lUnfrozen &bby &9&l" + name + ColorUtils.color("&b.")));

        }

        return true;
    }
}
