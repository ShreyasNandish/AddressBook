package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<Contact,Integer>{
    @Query(value = "SELECT * FROM Contact c WHERE c.name = :name", nativeQuery = true)
    List<Contact> findContactByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Contact c WHERE c.id = :id", nativeQuery = true)
     Contact getContactById(@Param("id")int id);

    @Query(value = "SELECT * FROM Contact c WHERE c.city = :city", nativeQuery = true)
    List<Contact> findContactByCity(@Param("city")String city);

    @Query(value = "SELECT * FROM Contact c WHERE c.state = :state", nativeQuery = true)
    List<Contact> findContactByState(@Param("state")String state);
}
