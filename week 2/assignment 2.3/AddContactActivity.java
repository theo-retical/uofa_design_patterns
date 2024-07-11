package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
  * Add a new contact
*/

public class AddContactActivity extends AppCompatActivity {
  private ContactList contact_list = new ContactList();
  private Context context;

  private EditText username;
  private EditText email;


@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);
  
    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);
  
    context = getApplicationContext();
    contact_list.loadContacts(context);
  }
  
  public void saveContact (View view) {
  
    String username_string = username.getText().toString();
    String email_string = email.getText().toString();
  
    if (username_string.isEmpty() || email_string.isEmpty()) {
      username.setError("Please enter a username and email address");
      return;
    }
  
    if (!email_string.contains("@")) {
      email.setError("Please enter a valid email address");
      return;
    }
  
    for (Contact c : contact_list.getContacts())) {
      if (c.getUsername().equals(username_string)) {
        username.setError("Username already exists");
        return;
      }
    }
  
    Contact contact = new Contact(username_string, email_string, null);
  
    // Add Contact
    AddContactCommand add_contact_command = new AddContactCommand(contact_list, contact, context);
    add_contact_command.execute();
  
    boolean success = add_contact_command.getSuccess();
    if (!success) {
      return;
    }
  
    finish();
  }
}
