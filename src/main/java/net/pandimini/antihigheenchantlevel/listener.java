package net.pandimini.antihigheenchantlevel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;



public class listener implements Listener {
    @EventHandler
    public static void onMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if (!Main.getInstance().getConfig().getList("settings.saveplayer").contains(player.getName())){
            IsItem.isItem(player);
        }
    }
}
