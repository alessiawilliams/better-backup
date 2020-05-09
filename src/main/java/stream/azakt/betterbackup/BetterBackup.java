package stream.azakt.betterbackup;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterBackup extends JavaPlugin implements Listener {

    private int backupTaskId;

    @Override
    public void onEnable() {
        // Create default config on first run
        this.saveDefaultConfig();
        // Create command /bb
        this.getCommand("bb").setExecutor(new BetterBackupCommandExecutor(this));
        // Create Backup Task if enabled
        if(this.getConfig().getBoolean("enabled")) {
            this.getLogger().info("started task");
            this.createBackupTask();
        }
    }

    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelTask(backupTaskId);
    }

    public void onReload() {
        this.getServer().getScheduler().cancelTask(backupTaskId);
        this.reloadConfig();
        this.onEnable();
    }

    public void createBackupTask() {
        // Create backup scheduled task
        int tickInterval = this.getConfig().getInt("minutes-interval") * 60 * 20;
        backupTaskId = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                new BetterBackupTask(BetterBackup.this).run();
            }
        }, tickInterval, tickInterval);
    }
}
