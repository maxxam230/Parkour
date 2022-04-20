package me.max.parkour.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ParkourMenuInteract implements Listener {

    @EventHandler
    public void PlayerMenuInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equals("§2§oCreate Parkour Menu")){
            if(e.getSlot() == 2) {

                p.sendMessage("§bWelcome: §a" + e.getCursor().getItemMeta().getDisplayName());
            }
            e.setCancelled(true);
        }
    }
}
