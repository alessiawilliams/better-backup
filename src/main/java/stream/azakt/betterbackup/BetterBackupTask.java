package stream.azakt.betterbackup;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BetterBackupTask extends BukkitRunnable {

    private final Plugin plugin;

    public BetterBackupTask(Plugin plugin) { this.plugin = plugin; }

    @Override
    public void run() {
        // Actual backup-y things occur here!
        this.plugin.getLogger().info("");
    }
}
