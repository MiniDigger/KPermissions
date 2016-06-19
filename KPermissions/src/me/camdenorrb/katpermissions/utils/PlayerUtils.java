package me.camdenorrb.katpermissions.utils;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class PlayerUtils {

    public static Optional<OfflinePlayer> getOfflinePlayer(String name) {
        return Arrays.stream(Bukkit.getOfflinePlayers()).filter(offlinePlayer -> offlinePlayer.getName().equalsIgnoreCase(name)).findFirst();
    }
}
