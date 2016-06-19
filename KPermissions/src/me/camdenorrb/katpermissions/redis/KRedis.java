package me.camdenorrb.katpermissions.redis;

import me.camdenorrb.katpermissions.rank.KRank;
import me.camdenorrb.katpermissions.utils.Call;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class KRedis {

    private final JedisPool jedisPool;

    public KRedis(String host, int port , String password) {
        jedisPool = new JedisPool(new JedisPoolConfig(), host, port, 2000, password);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setRankSync(UUID uuid, KRank kRank) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(uuid.toString(), kRank.getName());
        }
    }

    public void setRank(UUID uuid, KRank kRank) {
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.set(uuid.toString(), kRank.getName());
            }
        }).start();
    }

    public void getRank(UUID uuid, Call<KRank> call) {
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                String kRank = jedis.get(uuid.toString());
                jedis.select(1);
                if (kRank != null) call.call(new KRank(kRank, jedis.get(kRank)));
                else call.onFail(null);
            }
        }).start();
    }
}
