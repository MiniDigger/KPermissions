package me.camdenorrb.katpermissions.listeners;

import me.camdenorrb.katpermissions.permissions.PermissionManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @apiNote Please do not use this class, as it's purely internal.
 */
// Do NOT rename, due a check inside Permissible.java in the registerAll and unregisterAll methods.
public class PlayerListen implements Listener {
    
    private final PermissionManager permissionManager;
    
    public PlayerListen(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        permissionManager.getPermissible(event.getPlayer().getUniqueId()).registerAll(event.getPlayer());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        permissionManager.getPermissible(event.getPlayer().getUniqueId()).unregisterAll(event.getPlayer());
    }
}
