package me.camdenorrb.katpermissions;

import me.camdenorrb.katpermissions.redis.KRedis;
import org.apache.commons.lang.Validate;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class KPermissions extends JavaPlugin {

    private static KPermissions instance;

    private static KRedis kRedis;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        initRedis();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static KRedis getkRedis() {
        return kRedis;
    }

    public static KPermissions getInstance() {
        return instance;
    }

    private void registerEvents(Listener... listeners) {
        PluginManager pluginManager = getServer().getPluginManager();
        for (Listener listener : listeners) pluginManager.registerEvents(listener, this);
    }

    private void initRedis() {
        int port = getConfig().getInt("port");
        String host = getConfig().getString("host");
        String password = getConfig().getString("password");
        Validate.noNullElements(new Object[]{port, host, password}, "Config doesn't have correct values.");
        kRedis = new KRedis(host, port, password);
    }
}
