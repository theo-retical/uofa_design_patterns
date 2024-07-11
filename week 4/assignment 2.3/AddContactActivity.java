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
  private ContactListController contact_list_controller = new ContactListController(contact_list);
  
  private Context context;

  private EditText username;
  private EditText email;

  private String username_string = username.getTetx().toString();
  private String email_string = email.getTetx().toString();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);
    
    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);
    
    context = getApplicationContext();
    contact_list_controller.loadContacts(context);
  }

  public boolean validateInput() {
    if (username_string.isEmpty() || email_string.isEmpty()) {
      username.setError("Please enter a username and email address");
      return false;
    }

    if (!email_string.contains("@")) {
      email.setError("Please enter a valid email address");
      return false;
    }

    return true;
  }
  
  public void saveContact (View view) {

    if (!validateInput()) {
      return;
    }
  
    Contact contact = new Contact(username_string, email_string, null);
  
    boolean success = add_contact_command.getSuccess();
    if (!success) {
      return;
    }
  
    finish();
  }
}
