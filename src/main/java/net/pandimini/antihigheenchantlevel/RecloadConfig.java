package net.pandimini.antihigheenchantlevel;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RecloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("antiench.rlc")){
                Main.getInstance().reloadConfig();
                player.sendMessage(ChatColor.GREEN + "Successfully reload the config");
            }
        } else if (sender instanceof ConsoleCommandSender){
            Main.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Successfully reload the config");
        }
        return false;
    }
}
