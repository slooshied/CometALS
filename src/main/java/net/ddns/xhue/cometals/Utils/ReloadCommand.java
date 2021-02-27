package net.ddns.xhue.cometals.Utils;

import net.ddns.xhue.cometals.ALSConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class ReloadCommand implements CommandExecutor {

    private ALSConfig config;
    private JavaPlugin plugin;

    public ReloadCommand(JavaPlugin plugin, ALSConfig config) {
        this.config = config;
        this.plugin = plugin;
    }

    public void tellConsole(String message){
        Bukkit.getConsoleSender().sendMessage(message);
    }


    ColorUtils cu = new ColorUtils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        String prefix = cu.translateAll(config.getConfig().getString("prefix"));

        if (cmd.getName().equalsIgnoreCase("carl")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("cometals.reload")) {

                    config.reloadConfig();
                    sender.sendMessage(prefix + " " + ChatColor.GREEN + "CometALS has been successfully re-loaded!");
                    tellConsole(prefix + " " + ChatColor.GREEN + "CometALS has been successfully re-loaded!");
                    return true;

                }
                else if (!sender.hasPermission("cometals.reload")) {
                    sender.sendMessage(prefix + " " + cu.translateAll("#FF0000:&lSorry! &cYou do not have permission to perform that command!"));
                    return true;

                }
            } else {
                config.reloadConfig();
                sender.sendMessage(prefix + " " + ChatColor.LIGHT_PURPLE + "CometALS has been reloaded");
                return true;
            }
            return false;
        }
        return false;
    }
}
