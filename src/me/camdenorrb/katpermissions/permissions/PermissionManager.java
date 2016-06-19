package me.camdenorrb.katpermissions.permissions;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PermissionManager {

    private static PermissionManager instance;
    
    private List<Permissible> attachment = new ArrayList<>();

    /**
     * Prevent construction.
     */
    private PermissionManager() {}

    public boolean addPermission(UUID id, Permission permission, boolean value) {
        return addPermission(Bukkit.getOfflinePlayer(id), permission, value);
    }

    public boolean addPermission(OfflinePlayer player, Permission permission, boolean value) {
        getPermissible(player.getUniqueId()).set(permission, value);
        return true;
    }

    public Permissible getPermissible(UUID player) {
        Optional<Permissible> opt = attachment.stream().filter(p->p.getId() == player).findFirst();
        if (!opt.isPresent()) {
            attachment.add(new Permissible(player));
            opt = attachment.stream().filter(p -> p.getId() == player).findFirst();
        }
        return opt.get();
    }
}
