package io.gautam.debugrealm;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Group extends RealmObject {

    private RealmList<Contact> contacts;

    public RealmList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(RealmList<Contact> contacts) {
        this.contacts = contacts;
    }
}
