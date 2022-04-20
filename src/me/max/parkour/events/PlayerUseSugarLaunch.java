package me.max.parkour.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerUseSugarLaunch implements Listener {

    @EventHandler
    public void SugarLaunch(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.getItemInHand().getType().equals(Material.SUGAR)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                e.getItem().setAmount(e.getItem().getAmount() - 1);
                p.setVelocity(p.getLocation().getDirection().multiply(40));
                p.spawnParticle(Particle.CLOUD, p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ(), 1000, 1, 0.5, 1, 0.0001);
                p.playSound(p.getLocation(), Sound.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, 100, 100);
            }
        }
    }


}
