package gasnic.randomlight;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

public final class RandomLight extends JavaPlugin {
    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        getLogger().info(
                "______                _                 _     _       _     _   \n" +
                "| ___ \\              | |               | |   (_)     | |   | |  \n" +
                "| |_/ /__ _ _ __   __| | ___  _ __ ___ | |    _  __ _| |__ | |_ \n" +
                "|    // _` | '_ \\ / _` |/ _ \\| '_ ` _ \\| |   | |/ _` | '_ \\| __|\n" +
                "| |\\ \\ (_| | | | | (_| | (_) | | | | | | |___| | (_| | | | | |_ \n" +
                "\\_| \\_\\__,_|_| |_|\\__,_|\\___/|_| |_| |_\\_____/_|\\__, |_| |_|\\__|\n" +
                "                                                 __/ |          \n" +
                "                                                |___/            by gasnic");
        config.options().copyDefaults(true);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled.");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("rlight")) {
            if (!sender.hasPermission(config.getString("permissions.start"))) {
                sender.sendMessage(config.getString("messages.nopermission").replace("&", "§"));
                return true;
            }

            if (!(sender instanceof Player)) {
                sender.sendMessage(config.getString("messages.playeronly".replace("&", "§")));
                return true;
            }

            if (args.length == 0) {
                sender.sendMessage(config.getString("messages.usage").replace("&", "§"));
                return true;
            }

            int radius = Integer.parseInt(args[0]);
            int maxRadius = config.getInt("maxRadius");

            if (radius > maxRadius) {
                sender.sendMessage(config.getString("messages.maxradius").replace("&", "§"));
                return true;
            }

            Player player = (Player) sender;
            Random rand = new Random();
            Location playerLoc = player.getLocation();

            int area = (radius * 2) * (radius * 2);
            int lightPoints = (int) Math.ceil(area / 25.0);

            for (int i = 0; i < lightPoints; i++) {
                int dx = rand.nextInt(radius * 2 + 1) - radius;
                int dz = rand.nextInt(radius * 2 + 1) - radius;
                Location lightLoc = playerLoc.clone().add(dx, 0, dz);

                lightLoc.setY(player.getWorld().getHighestBlockYAt(lightLoc) + 1);
                player.getWorld().setBlockData(lightLoc, Bukkit.createBlockData(Material.LIGHT));
            }

            return true;

        } else if (command.getName().equalsIgnoreCase("rlreload")) {
            if (!sender.hasPermission(config.getString("permissions.reload"))) {
                sender.sendMessage(config.getString("messages.nopermission").replace("&", "§"));
                return true;
            }

            reloadConfig();
            sender.sendMessage(config.getString("messages.reload").replace("&", "§"));
            return true;
        }

        return false;
    }
}
