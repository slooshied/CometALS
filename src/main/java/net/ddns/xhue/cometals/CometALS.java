package net.ddns.xhue.cometals;

import net.ddns.xhue.cometals.Utils.ColorUtils;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CometALS extends JavaPlugin {


    ColorUtils cu = new ColorUtils();
    String prefix = cu.translateAll(getConfig().getString("prefix"));

    @Override
    public void onEnable() {

        int pluginId = 10495;
        Metrics metrics = new Metrics(this, pluginId);

        Bukkit.getLogger().info(prefix + " " + cu.translateAll("&cCometALS has been &aenabled&c."));

        ALSConfig config = new ALSConfig(this);

        Bukkit.getPluginManager().registerEvents(new ExploitListener(config), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(prefix + " " + cu.translateAll("&cCometALS has been #FF0000:disabled&c."));

        // Plugin shutdown logic
    }
}
