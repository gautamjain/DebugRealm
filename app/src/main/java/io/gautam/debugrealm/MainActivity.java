package io.gautam.debugrealm;

import android.app.Activity;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends Activity {
    String[] keys = {"A", "B", "C", "D", "E", "F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seedRealm();
        testA();
    }

    private void testA() {
        Realm realm = Realm.getInstance(this);

        // Without sorting, it works fine
//        RealmList<Contact> contacts = realm.where(Group.class).findFirst().getContacts();

        // With sorting, it doesn't work
        RealmResults<Contact> contacts = realm.where(Group.class).findFirst().getContacts()
                                                .where().findAll("key", RealmResults.SORT_ORDER_ASCENDING);

        // ArrayIndexOutOfBoundsException
        RealmResults<Contact> statusContacts = contacts.where().equalTo("status", 1).findAll();

        // IllegalArgumentException: Field 'key': type mismatch.
        RealmResults<Contact> keyContacts = contacts.where().equalTo("key", "A").findAll();
    }

    private void seedRealm() {
        Realm realm = Realm.getInstance(this);

        realm.beginTransaction();

        // Create new group
        Group group = realm.createObject(Group.class);

        // Create & add contacts to group.  Each contact has a key and a status of 1
        for (String key : keys) {
            Contact contact = realm.createObject(Contact.class);
            contact.setKey(key);
            contact.setStatus(1);
            group.getContacts().add(contact);
        }

        realm.commitTransaction();
    }


}
