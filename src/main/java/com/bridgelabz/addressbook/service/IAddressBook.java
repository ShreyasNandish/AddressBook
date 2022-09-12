package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

import java.util.List;


public interface IAddressBook {
    Contact addContact(ContactDTO contactDTO);
    Contact updateContact(ContactDTO contactDTO,int id);
    String deleteContact(int id);
    List<Contact> getAllContacts();
    Contact getContactByID(int id);
    List<Contact> getContactByName(String name);
    List<Contact> getContactByCity(String city);
    List<Contact> getContactByState(String state);
}
