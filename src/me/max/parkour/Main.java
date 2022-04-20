package me.max.parkour;

import me.max.parkour.commands.CreateCommand;
import me.max.parkour.events.ParkourMenuInteract;
import me.max.parkour.events.PlaceSignEvent;
import me.max.parkour.events.PlayerUseSugarLaunch;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public String prefix = "§7[§aParkour§7] ";

    @Override
    public void onEnable() {
        getLogger().info("M's Parkour has been enabled");

        Bukkit.getServer().getPluginManager().registerEvents(new ParkourMenuInteract(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlaceSignEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerUseSugarLaunch(), this);

        getCommand("parkour").setExecutor(new CreateCommand(this));

    }

    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("M's Parkour has been disabled");
    }


    public Location getConfigLocation(String path){
        Double x = getConfig().getDouble(path + ".x");
        Double y = getConfig().getDouble(path + ".y");
        Double z = getConfig().getDouble(path + ".z");
        String world = (String) getConfig().get(path + ".world");
        float yaw = (float) getConfig().getDouble(path + ".yaw");
        float pitch = (float) getConfig().getDouble(path + ".pitch");

        return new Location(Bukkit.getServer().getWorld(world),x,y,z, yaw, pitch);
    }

    public static ItemStack CreateNewItem(Material mat, String name){
        ItemStack item = new ItemStack(mat);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        item.setItemMeta(itemm);
        return item;
    }




}
