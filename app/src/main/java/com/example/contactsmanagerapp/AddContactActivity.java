package com.example.contactsmanagerapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactsmanagerapp.databinding.ActivityAddContactBinding;

public class AddContactActivity extends AppCompatActivity {
    ActivityAddContactBinding activityAddContactBinding;
    Contacts contact;
    AddActivityClickHandler clickHandler;
    MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_contact);
        contact = new Contacts();
        activityAddContactBinding.setContact(contact);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        clickHandler = new AddActivityClickHandler(this, contact, viewModel);
        activityAddContactBinding.setClickHandler(clickHandler);



    }
}