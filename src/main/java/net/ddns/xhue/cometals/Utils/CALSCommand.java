package net.ddns.xhue.cometals.Utils;

import net.ddns.xhue.cometals.ALSConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static net.ddns.xhue.cometals.Utils.Centering.CenteredMessages.sendCenteredMessage;


public class CALSCommand implements CommandExecutor {
    
    private ALSConfig config;
    private JavaPlugin plugin;

    public CALSCommand(JavaPlugin plugin, ALSConfig config) {
        this.config = config;
        this.plugin = plugin;
    }
    
    ColorUtils cu = new ColorUtils();


    @Override
    public boolean onCommand( CommandSender sender, Command cmd, String commandLabel, String[] args) {


        String prefix = cu.translateAll(config.getConfig().getString("prefix"));

        if (cmd.getName().equalsIgnoreCase("cometals")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("cometals.help")) {
                    Player p = ((Player) sender).getPlayer();

                    assert p != null;
                    sendCenteredMessage(p, " ");
                    sendCenteredMessage(p, cu.translateAll("&8&m         &8[ #7F00FF:&lComet#FF6000:&lALS &8]&8&m         "));
                    sendCenteredMessage(p, cu.translateAll( "&6&oThe ultimate solution to those pesky exploit-stands."));
                    sendCenteredMessage(p, cu.translateAll( " "));
                    sendCenteredMessage(p, cu.translateAll( "&7Version: &d") + plugin.getDescription().getVersion());
                    sendCenteredMessage(p, cu.translateAll( "&7Author: &dxHue"));
                    sendCenteredMessage(p, cu.translateAll( " "));
                    sendCenteredMessage(p, cu.translateAll( "&7&nCommands:"));
                    sendCenteredMessage(p, cu.translateAll( "&d/ca-rl &6- &7Reloads the plugin configuration file."));
                    sendCenteredMessage(p, cu.translateAll( " "));
                    sendCenteredMessage(p, cu.translateAll( "&d/cometals &6- &7Opens this help page."));
                    sendCenteredMessage(p, cu.translateAll( "&8&m                                      "));
                    sendCenteredMessage(p, cu.translateAll( " "));

                    
                }
                else {
                    sender.sendMessage(prefix + " " + cu.translateAll("#FF0000:&lSorry! &cYou do not have permission to perform that command!"));
                    return true;
                }
            } else {
                sender.sendMessage(prefix + " " + cu.translateAll("#FF0000:&lSorry! &cYou can only execute this command as a player!"));
                return true;
            }
            return true;
        }
        return true;

    }
}
