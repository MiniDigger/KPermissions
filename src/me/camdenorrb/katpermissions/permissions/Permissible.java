package me.camdenorrb.katpermissions.permissions;

import me.camdenorrb.katpermissions.KPermissions;
import me.camdenorrb.katpermissions.listeners.PlayerListen;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import sun.reflect.Reflection;

import java.util.HashMap;
import java.util.UUID;

/**
 * @apiNote Permissible object instead of the old Bukkit version.
 */
public class Permissible {
    private final UUID id;
    private final HashMap<Permission, Boolean> permissions;

    private PermissionAttachment attachment;

    /**
     * @param id
     */
    public Permissible(UUID id) {
        this.id = id;
        if (isOnline()) this.attachment = new PermissionAttachment(KPermissions.getInstance(), getPlayer());
        else this.attachment = null;
        permissions = new HashMap<>();
    }

    /**
     * @apiNote Please do not use this method as it is purely internal for {@link me.camdenorrb.katpermissions.listeners.PlayerListen#onJoin(PlayerJoinEvent)}
     * @param player
     */
    public void registerAll(Player player)
    {
        if (Reflection.getCallerClass() != PlayerListen.class)
            return;

        attachment = player.addAttachment(KPermissions.getInstance());
        getPermissions().entrySet().forEach(e->attachment.setPermission(e.getKey(), e.getValue()));
    }

    /**
     * @apiNote Please do not use this method as it is purely internal for {@link me.camdenorrb.katpermissions.listeners.PlayerListen#onLeave(PlayerQuitEvent)}
     * @param player
     */
    public void unregisterAll(Player player)
    {
        if (Reflection.getCallerClass() != PlayerListen.class)
            return;

        getPermissions().keySet().forEach(attachment::unsetPermission);
        player.removeAttachment(attachment);
        attachment.remove();
    }

    public UUID getId()
    {
        return id;
    }

    public Player getPlayer()
    {
        return (Player) attachment.getPermissible();
    }

    public boolean isOnline()
    {
        return getPlayer().isOnline();
    }

    public HashMap<Permission, Boolean> getPermissions()
    {
        return permissions;
    }

    public boolean get(Permission permission)
    {
        return permissions.getOrDefault(permission, false);
    }

    public boolean set(Permission permission, boolean value)
    {
        return permissions.replace(permission, value);
    }

}
