package net.ddns.xhue.cometals;

import net.ddns.xhue.cometals.Commands.CALSCommand;
import net.ddns.xhue.cometals.Utils.ColorUtils;
import net.ddns.xhue.cometals.Commands.ReloadCommand;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CometALS extends JavaPlugin {

    ColorUtils cu = new ColorUtils();
    String prefix = cu.translateAll(getConfig().getString("prefix"));

    @Override
    public void onEnable() {

        int pluginId = 10495;
        Metrics metrics = new Metrics(this, pluginId);

        Bukkit.getLogger().info(prefix + " " + cu.translateAll("&cCometALS has been &aenabled&c."));

        ALSConfig config = new ALSConfig(this);

        createConfig();

        ReloadCommand reloadExecutor = new ReloadCommand(this, config);
        Objects.requireNonNull(this.getCommand("carl")).setExecutor(reloadExecutor);

        CALSCommand calsExecutor = new CALSCommand(this, config);
        Objects.requireNonNull(this.getCommand("cometals")).setExecutor(calsExecutor);

        Bukkit.getPluginManager().registerEvents(new ExploitListener(config), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(prefix + " " + cu.translateAll("&cCometALS has been #FF0000:disabled&c."));

        // Plugin shutdown logic
    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getLogger().info("\n\n        " + prefix + ChatColor.YELLOW + " CometALS folder" + ChatColor.RED + " not found, generating one for you...\n");
                if(getDataFolder().mkdirs()) {
                    getLogger().info("\n\n        " + prefix + ChatColor.GREEN + " Folder generation complete!\n");
                } else {
                    getLogger().info("\n\n        " + prefix + ChatColor.RED + " Folder generation failed.\n");
                }
            }

            File file = new File(getDataFolder(), "config.yml");

            if (!file.exists()) {
                getLogger().info("\n\n        " + prefix + ChatColor.YELLOW + " config.yml" + ChatColor.RED + " not found, generating one for you...\n");
                saveDefaultConfig();
                if(file.exists()) {
                    getLogger().info("\n\n        " + prefix + ChatColor.YELLOW + " config.yml" + ChatColor.GREEN + " generation complete!\n");
                } else {
                    getLogger().info("\n\n        " + prefix + ChatColor.YELLOW + " config.yml" + ChatColor.RED + " generation failed.\n");
                }
            } else {
                getLogger().info("\n\n        " + prefix + ChatColor.YELLOW + " config.yml" + ChatColor.GREEN + " found, loading...\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe(prefix + ChatColor.DARK_RED + " CometALS returned an error while creating file(s).\n" + ChatColor.RED + "Exception: " + e);
        }
    }


}
