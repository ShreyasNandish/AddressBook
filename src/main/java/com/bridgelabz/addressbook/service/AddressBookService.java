package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.email.EmailService;
import com.bridgelabz.addressbook.exception.CustomException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBook{
    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    EmailService emailService;
    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        emailService.sendEmail(contactDTO.getEmail(),"Employee add to database","Hi added new contact");
        return addressBookRepository.save(contact);
    }

    @Override
    public Contact updateContact(ContactDTO contactDTO, int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            Contact contact = addressBookRepository.findById(id).get();
            contact.setName(contactDTO.getName());
            contact.setCity(contactDTO.getCity());
            contact.setState(contactDTO.getState());
            contact.setPhoneNumber(contactDTO.getPhoneNumber());
            contact.setAddress(contactDTO.getAddress());
            contact.setZipCode(contactDTO.getZipCode());
            contact.setEmail(contactDTO.getEmail());
            return addressBookRepository.save(contact);
        }
        else
        {
            throw new CustomException("Contact not present");
        }
    }

    @Override
    public String deleteContact(int id) {
        if(addressBookRepository.findById(id).isPresent())
        {
            addressBookRepository.deleteById(id);
            return "deleted contact";
        }

        else
        {
            throw new CustomException("Contact not present");
        }
    }

    @Override
    public List<Contact> getAllContacts() {

        if(!addressBookRepository.findAll().isEmpty())
        {
            return addressBookRepository.findAll();
        }

        else
        {
            throw new CustomException("Contact not found");
        }
    }

    @Override
    public Contact getContactByID(int id) {
        if(addressBookRepository.findById(id).isPresent())
        {
           return addressBookRepository.getContactById(id);
        }
        else
        {
            throw new CustomException("Contact not present");
        }
    }

    @Override
    public List<Contact> getContactByName(String name) {
        if(!addressBookRepository.findContactByName(name).isEmpty())
        {
            return addressBookRepository.findContactByName(name);
        }
        else
        {
            throw new CustomException("Contact not found");
        }
    }

    @Override
    public List<Contact> getContactByCity(String city) {
        if(!addressBookRepository.findContactByCity(city).isEmpty())
        {
            return addressBookRepository.findContactByCity(city);
        }

        else
        {
            throw new CustomException("Contact not found");
        }
    }

    @Override
    public List<Contact> getContactByState(String state) {
        if(!addressBookRepository.findContactByState(state).isEmpty())
        {
            return addressBookRepository.findContactByState(state);
        }

        else {
            throw new CustomException("Contact not found");
        }
    }
}
