package stream.azakt.betterbackup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BetterBackupCommandExecutor implements CommandExecutor {

    private final BetterBackup plugin;

    public BetterBackupCommandExecutor(BetterBackup plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("bb")) {
            if (sender instanceof Player && !sender.hasPermission("betterbackup.use")) {
                return false;
            }
            else {
                // Do something backup-y
            }
        }
        return false;
    }
}
