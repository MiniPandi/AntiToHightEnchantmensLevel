package net.pandimini.antihigheenchantlevel;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public class IsItem {
    public static void isItem(Player player){

        for (int i = 0; i < player.getInventory().getSize();i++){
            ItemStack item = player.getInventory().getItem(i);
            if (item != null && item.getType() != Material.AIR) {
                if  (Main.getInstance().getConfig().getBoolean("settings.attribute")){
                    ItemMeta itemMeta = item.getItemMeta();
                    for (Attribute attribute : Attribute.values()) {
                        if (itemMeta.getAttributeModifiers() != null){
                            Collection<AttributeModifier> modifiers = itemMeta.getAttributeModifiers(attribute);
                            if (modifiers != null) {
                                for (AttributeModifier modifier : modifiers) {
                                    double amount = modifier.getAmount();
                                    int level = (int) amount;
                                    item.setAmount(0);
                                    player.sendMessage(ChatColor.RED + "You are not allowed to use this item.");
                                }
                            }
                        }
                    }
                } else {
                    int anInt = Main.getInstance().getConfig().getInt("settings.maxattribute");
                    ItemMeta itemMeta = item.getItemMeta();
                    for (Attribute attribute : Attribute.values()) {
                        if (itemMeta.getAttributeModifiers() != null){
                            Collection<AttributeModifier> modifiers = itemMeta.getAttributeModifiers(attribute);
                            if (modifiers != null) {
                                for (AttributeModifier modifier : modifiers) {
                                    double amount = modifier.getAmount();
                                    int level = (int) amount;
                                    if (level > anInt){
                                        item.setAmount(0);
                                        player.sendMessage(ChatColor.RED + "You are not allowed to use this item.");
                                    }

                                }
                            }
                        }
                    }
                }
                if  (Main.getInstance().getConfig().getBoolean("settings.enchantments")){
                    for (Enchantment enchantment: Enchantment.values()) {
                        if (item.getEnchantments().containsKey(enchantment)){
                            int enchantmentLevel = item.getEnchantmentLevel(enchantment);
                            if (enchantmentLevel > enchantment.getMaxLevel()){
                                item.setAmount(0);
                                player.sendMessage(ChatColor.RED + "You are not allowed to use this item.");
                            }
                        }
                    }
                }

            }
        }
    }
}
