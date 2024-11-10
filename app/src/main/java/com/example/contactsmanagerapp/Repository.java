package com.example.contactsmanagerapp;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    ContactsDB contactsDB;
    ContactDao contactDao;
    private static final ExecutorService executorService= Executors.newSingleThreadExecutor();

    public Repository(Application application) {
        contactsDB = ContactsDB.getDatabaseInstance(application);
        contactDao = contactsDB.getContactDao();
    }

    public void insert(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.insert(contacts);
            }
        });
    }
    public void delete(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.delete(contacts);
            }
        });
    }
    public LiveData<List<Contacts>> getALlContacts(){
        return contactDao.getAllContacts();
    }
}
