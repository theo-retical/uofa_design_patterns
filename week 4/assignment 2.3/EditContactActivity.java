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
  private ContactListController contact_list_controller = new ContactListController(contact_list);
  
  private Contact contact;
  private ContactController contact_controller;
  
  private Context context;

  private EditText username;
  private EditText email;

  private int pos;
  private boolean on_create_update = true;


@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);

    Intent intent = getIntent();
    int pos = intent.getIntExtra("pos", 0);
      
    context = getApplicationContext();
    contact_list_controller.addObserver(this);
    contact_list_controller.loadContacts(context);
    on_create_update = false;
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

  @Override
  public void onDestroy() {
    super.onDestroy();
    contact_listr_controller.removeObserver(this);
  }

  public void update() {
    if (on_create_update) {

      contact = contact_list_controller.getContact(pos);
      contact_controller = new ContactController(contact);

      username = (EditText) findViewByid(R.id.username);
      email = (EditText) findViewByid(R.id.email);

      username.setText(contact_controller.getUsername());
      email.setText(contact_controller.getEmail());
    }
  }
}
