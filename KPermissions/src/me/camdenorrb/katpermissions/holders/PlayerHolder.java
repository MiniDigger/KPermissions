package me.camdenorrb.katpermissions.holders;

import me.camdenorrb.katpermissions.rank.KRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class PlayerHolder {

    private static Map<UUID, KRank> uuidkRankMap= new HashMap<>();

    public static void remove(UUID uuid) {
        uuidkRankMap.remove(uuid);
    }

    public static KRank get(UUID uuid) {
        return uuidkRankMap.get(uuid);
    }

    public static void set(UUID uuid, KRank kRank) {
        uuidkRankMap.put(uuid, kRank);
    }

    public static boolean contains(UUID uuid) {
        return uuidkRankMap.containsKey(uuid);
    }

    public static Map<UUID, KRank> getUuidkRankMap() {
        return Collections.unmodifiableMap(uuidkRankMap);
    }

}
