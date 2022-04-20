package me.max.parkour.menus;

import me.max.parkour.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class ParkourCreateMenu {


    public static void CreateAnvilMenu(Player p){

        Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL, "§2§oCreate Parkour Menu");
        for(int i = 0; i<inv.getSize() ;i++) {
        }

        inv.setItem(0, Main.CreateNewItem(Material.NAME_TAG, " "));


        p.openInventory(inv);
    }
}
