package net.ddns.xhue.cometals;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ALSConfig {

    private final Logger logger;
    private FileConfiguration config;
    private final JavaPlugin plugin;

    /**
     * Creates a Plugin config for this plugin.
     *
     * @param plugin
     *          enter <i>this</i> from your main class.
     */
    public ALSConfig(final JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.logger = plugin.getLogger();

        reloadConfig();
    }

    /**
     * Force reload the config.
     */
    public void reloadConfig() {
        plugin.reloadConfig();
        this.config = plugin.getConfig();


    }

    public Logger getLogger() {
        return logger;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}