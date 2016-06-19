package me.camdenorrb.katpermissions.utils;

import org.bukkit.ChatColor;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class ChatUtils {

    public static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
