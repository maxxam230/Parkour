package me.max.parkour.commands;

import me.max.parkour.Main;
import me.max.parkour.menus.ParkourCreateMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateCommand implements CommandExecutor {

    Main plugin;

    public CreateCommand(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        if(command.getName().equalsIgnoreCase("parkour")){
            if (args.length > 0){
                if(args[0].equalsIgnoreCase("create")){
                    if(args.length > 1){
                        if(!plugin.getConfig().contains("parkours." + args[1])){
                            saveParkourSpawn("parkours." + args[1].toString(), p);
                            p.sendMessage(plugin.prefix + "§2Parkour Saved: "+args[1]);
                        } else {
                            p.sendMessage(plugin.prefix + "§cThis parkour already exists");
                        }
                    } else {
                        p.sendMessage(plugin.prefix + "§c/parkour create (name)");
                    }
                } else if(args[0].equalsIgnoreCase("remove")){
                    if(args.length > 1){
                        if(plugin.getConfig().contains("parkours." + args[1])){
                            plugin.getConfig().set("parkours." + args[1], null);
                            plugin.saveConfig();
                            p.sendMessage(plugin.prefix + "§2Pakour §b§o" + args[1] + " §r§2removed");
                        } else {
                            p.sendMessage(plugin.prefix + "§cThis parkour doesn't exist");
                        }
                    } else {
                        p.sendMessage(plugin.prefix + "§c/parkour remove (name)");
                    }
                } else if(args[0].equalsIgnoreCase("list")){
                    if(plugin.getConfig().contains("parkours")){
                        p.sendMessage(plugin.prefix);
                        ConfigurationSection sec = plugin.getConfig().getConfigurationSection("parkours");
                        for(String key : sec.getKeys(false)){
                            p.sendMessage("§b§o"+key);
                        }
                    }else{
                        p.sendMessage(plugin.prefix + "§cNo parkours created yet");
                    }
                } else if(args[0].equalsIgnoreCase("menu")){
                    ParkourCreateMenu.CreateAnvilMenu(p);
                }
            }else{
                createHelpMessae(p);
            }
        } else if(command.getName().equalsIgnoreCase("list")){

        }


        return false;
    }

    public void saveParkourSpawn(String path, Player p){
        plugin.getConfig().set(path + ".x", p.getLocation().getX());
        plugin.getConfig().set(path + ".y", p.getLocation().getY());
        plugin.getConfig().set(path + ".z", p.getLocation().getZ());
        plugin.getConfig().set(path + ".world", p.getWorld().getName());
        plugin.getConfig().set(path + ".yaw", p.getLocation().getYaw());
        plugin.getConfig().set(path + ".pitch", p.getLocation().getPitch());
        plugin.saveConfig();
    }


    public void createHelpMessae(Player p){
        p.sendMessage(plugin.prefix);
        p.sendMessage("/parkour create (name)");
        p.sendMessage("/parkour remove (name)");
        p.sendMessage("/parkour list");
    }






}
