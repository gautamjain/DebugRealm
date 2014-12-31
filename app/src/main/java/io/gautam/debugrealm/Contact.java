package io.gautam.debugrealm;

import io.realm.RealmObject;

public class Contact extends RealmObject {

    private String key;

    private int status;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
