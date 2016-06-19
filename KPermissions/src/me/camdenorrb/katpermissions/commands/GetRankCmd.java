package me.camdenorrb.katpermissions.commands;

import me.camdenorrb.katpermissions.KPermissions;
import me.camdenorrb.katpermissions.utils.PlayerUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Optional;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class GetRankCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command label, String name, String[] args) {
        //TODO: get Players rank through redis.
        if (args.length != 1) return false;
        Optional<OfflinePlayer> offlinePlayer = PlayerUtils.getOfflinePlayer(args[0]);
        if (!offlinePlayer.isPresent()) return false;
        KPermissions.getkRedis().getRank(offlinePlayer.get().getUniqueId(), rank -> sender.sendMessage(rank.getName()));
        return true;
    }
}
