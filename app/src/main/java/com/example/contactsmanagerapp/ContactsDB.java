package com.example.contactsmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class} , version = 1)


public abstract class ContactsDB extends RoomDatabase {

    public abstract ContactDao getContactDao();

    private static ContactsDB contactsDB;
    public static synchronized ContactsDB getDatabaseInstance(Context context){
        if(contactsDB == null){
            contactsDB = Room.databaseBuilder(context.getApplicationContext(), ContactsDB.class, "Contact_db").fallbackToDestructiveMigration().build();

        }
        return contactsDB;

    }
}
