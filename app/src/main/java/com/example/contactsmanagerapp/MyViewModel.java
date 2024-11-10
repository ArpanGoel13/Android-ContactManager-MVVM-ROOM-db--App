package com.example.contactsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Repository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void addContact(Contacts contacts){
        repository.insert(contacts);
    }

    public void deleteContact(Contacts contacts){
        repository.delete(contacts);
    }

    public LiveData<List<Contacts>> fetchContacts(){
        return repository.getALlContacts();
    }


}
