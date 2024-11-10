package com.example.contactsmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Contacts contacts);
    @Delete
    void delete(Contacts contacts);

    @Query(" SELECT * FROM contacts_table")
    LiveData<List<Contacts>> getAllContacts();

}
