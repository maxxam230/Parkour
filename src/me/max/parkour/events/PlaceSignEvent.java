package me.max.parkour.events;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceSignEvent implements Listener {


    @EventHandler
    public void PlaceSigne(BlockPlaceEvent e){
        if(e.getBlock().getType().equals(Material.OAK_SIGN)){
            Sign sign = (Sign) e.getBlock().getState();
            if(sign.getLine(0).equalsIgnoreCase("[parkour]")){
                sign.setGlowingText(true);
                sign.setLine(1, "§2Testing");
                sign.update();
            }
        }
    }


}
