package me.camdenorrb.katpermissions.utils;

import org.bukkit.command.CommandSender;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class MsgUtils {

    public static boolean send(CommandSender sender, String message, boolean colored) {
        sender.sendMessage(colored ? ChatUtils.format(message) : message);
        return true;
    }
}
