package me.camdenorrb.katpermissions.rank;

import me.camdenorrb.katpermissions.utils.ChatUtils;

/**
 * Created by camdenorrb on 6/15/16.
 */
public class KRank {

    private final String name;
    private final String prefix;

    public KRank(String name, String prefix) {
        this.name = name;
        this.prefix = ChatUtils.format(prefix);
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

}
