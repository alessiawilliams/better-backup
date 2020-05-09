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
            if (args.length == 0) {
                return false;
            }
            else {
                if(args[0].equalsIgnoreCase("on")) {
                    this.plugin.getConfig().set("enabled", true);
                    this.plugin.saveConfig();
                    this.plugin.onReload();
                    sender.sendMessage("[BB] BetterBackup has been successfully enabled!");
                    if(sender instanceof Player) { this.plugin.getLogger().info(String.format("[BB] %s has enabled BetterBackup successfully!", sender.getName())); }
                }
                else if(args[0].equalsIgnoreCase("off")) {
                    this.plugin.getConfig().set("enabled", false);
                    this.plugin.saveConfig();
                    this.plugin.onReload();
                    sender.sendMessage("[BB] BetterBackup has been successfully disabled!");
                    if(sender instanceof Player) { this.plugin.getLogger().info(String.format("[BB] %s has disabled BetterBackup successfully!", sender.getName())); }
                }
                else if(args[0].equalsIgnoreCase("reload")) {
                    this.plugin.onReload();
                    sender.sendMessage("[BB] BetterBackup has successfully reloaded the config!");
                    if(sender instanceof Player) { this.plugin.getLogger().info(String.format("[BB] %s has reloaded BetterBackup successfully!", sender.getName())); }
                }
                else if(args[0].equalsIgnoreCase("backup")) {
                    new BetterBackupTask(this.plugin).run();
                    sender.sendMessage("[BB] BetterBackup has successfully backed up!");
                    if(sender instanceof Player) { this.plugin.getLogger().info(String.format("[BB] %s has backed up with BetterBackup successfully!", sender.getName())); }
                }
                else {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
