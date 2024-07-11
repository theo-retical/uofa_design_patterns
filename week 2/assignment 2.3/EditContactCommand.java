package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
  * Edit a contact
*/

public class EditContactActivity extends AppCompatActivity {
  private ContactList contact_list = new ContactList();
  private Contact contact;
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

    Intent intent = getIntent();
    int pos = intent.getIntExtra("pos", 0);

    contact = contact_list.getContact(pos);

    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);
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

    if (!contact_list.isUsernameAvailable(username_string) && !contact.getUsername().equals(username_string) {
      username.setError("Username already exists");
      return;
    }

    String id = contact.getUserID();
    Contact new_contact = new Contact(username_string, email_string, id);

    EditContactCommand edit_contact_command = new EditContactCommand(contact_list, contact, new_contact, context);
    edit_contact_command.execute();

    boolean success = add_contact_command.getSuccess();
    if (!success) {
      return;
    }
  
    finish();
  }

  public void deleteContact (View view) {
    
    DeleteContactCommand delete_contact_command = new DeleteContactCommand(contact_list, contact, context);
    delete_contact_command.execute();

    boolean success = delete_contact_command.getSuccess();
    if (!success) {
      return;
    }
  
    finish();
  }
}


 
