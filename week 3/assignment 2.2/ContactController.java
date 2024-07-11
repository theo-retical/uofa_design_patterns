package com.example.sharingapp;

/**
 * ContactController is responsible for all communication between views and Contact object
 */

public class ContactController {
  private Contact contact;

  public ContactController(Contact contact) {
    this.contact = contact;
  }

  public String getUserID() {
    return contact.getUserID();
  }

  public void setUserID(String userID) {
    contact.setUserID(userID);
  }

  public void upadateUserID(String userID) {
    contact.updateUserID(userID);
  }

  public String getUsername() {
    return contact.getUsername();
  }

  public void setUsername(String username) {
    contact.setUsername(username);
  }

  public String getEmail() {
    return contact.getEmail();
  }

  public void setEmail(String email) {
    contact.setEmail(email);
  }

  public Contact getContact() {
    return this.contact;
  }

  public void addObserver(Observer observer) {
    contact.addObserver(observer);
  }

  public void removeObserver(Observer observer) {
    contact.removeObserver(observer);
  }
}
