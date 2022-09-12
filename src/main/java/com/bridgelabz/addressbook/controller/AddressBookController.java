package com.bridgelabz.addressbook.controller;


import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.service.IAddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class AddressBookController {

    @Autowired
    IAddressBook iAddressBook;

    //Adding contact to the database and giving a response message with a status code
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contactDTO){
        ResponseDTO responseDTO = new ResponseDTO("Added contact",iAddressBook.addContact(contactDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@Valid @RequestBody ContactDTO contactDTO,@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Updated contact",iAddressBook.updateContact(contactDTO,id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //deleting contact with the help of a given employee unique ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted contact",iAddressBook.deleteContact(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getContactById")
    public ResponseEntity<ResponseDTO> getContactById(@RequestParam(value = "id") int id){
        ResponseDTO responseDTO = new ResponseDTO("reterived contact by id",iAddressBook.getContactByID(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getContactByName")
    public ResponseEntity<ResponseDTO> getContactByName(@RequestParam(value = "name") String name){
        ResponseDTO responseDTO = new ResponseDTO("reterived contact by name",iAddressBook.getContactByName(name));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getContactByCity")
    public ResponseEntity<ResponseDTO> getContactByCity(@RequestParam(value = "city") String city){
        ResponseDTO responseDTO = new ResponseDTO("reterived contact by city",iAddressBook.getContactByCity(city));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getContactByState")
    public ResponseEntity<ResponseDTO> getContactByState(@RequestParam(value = "state") String state){
        ResponseDTO responseDTO = new ResponseDTO("reterived contact by state",iAddressBook.getContactByState(state));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //Displaying all the contacts that are present in database
    @GetMapping("/getAllContacts")
    public ResponseEntity<ResponseDTO> getAllContact(){
        ResponseDTO responseDTO = new ResponseDTO("reterived contact by state",iAddressBook.getAllContacts());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
