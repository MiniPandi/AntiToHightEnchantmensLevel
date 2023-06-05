package net.pandimini.antihighenchantlevel.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        for(ItemStack item : player.getInventory().getContents()) {
            if(item == null || item.getType().equals(Material.AIR)) return;

            item.getEnchantments().forEach(((enchantment, integer) -> {
                if(item.getEnchantmentLevel(enchantment) > enchantment.getMaxLevel()) {
                    item.setAmount(0);
                    player.sendMessage(ChatColor.RED + "You are not allowed to use this item.");
                }
            }));
        }
    }
}