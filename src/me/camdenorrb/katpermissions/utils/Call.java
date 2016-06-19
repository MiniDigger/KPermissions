package me.camdenorrb.katpermissions.utils;

/**
 * Created by camdenorrb on 6/15/16.
 */
public interface Call<D> {

    void call(D paramD);

    default void onFail(D data) {}

}