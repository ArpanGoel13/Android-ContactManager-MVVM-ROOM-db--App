package com.example.contactsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;



public class AddActivityClickHandler {
    Context context;
    Contacts contact;
    MyViewModel myViewModel;

    public AddActivityClickHandler(Context context, Contacts contact, MyViewModel myViewModel) {
        this.context = context;
        this.contact = contact;
        this.myViewModel = myViewModel;
    }

    public void onAddClicked(View view){
        if(contact.getName() == null || contact.getEmail() == null){
            Toast.makeText(context, "Fields can't be empty!", Toast.LENGTH_LONG).show();
        }
        else{

            Intent i = new Intent(context, MainActivity.class);
            myViewModel.addContact(contact);
            context.startActivity(i);

        }



    }

}
