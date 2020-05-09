package stream.azakt.betterbackup;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterBackup extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getCommand("bb").setExecutor(new BetterBackupCommandExecutor(this));
    }

    @Override
    public void onDisable() {

    }
}
