package net.pandimini.antitohigeenchantlevel;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class listener implements Listener {
    @EventHandler
    public static void onMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        for (int i = 0; i < player.getInventory().getSize();i++){
            ItemStack item = player.getInventory().getItem(i);
            if (item != null && item.getType() != Material.AIR)
            for (Enchantment enchantment: Enchantment.values()) {
                if (item.getEnchantments().containsKey(enchantment)){
                    int enchantmentLevel = item.getEnchantmentLevel(enchantment);
                    if (enchantmentLevel > enchantment.getMaxLevel()){
                        item.setAmount(0);
                        player.sendMessage(ChatColor.RED + "You ar not allowed to use items with to hiegt enchantment level");
                    }
                }
            }
        }
    }
}
