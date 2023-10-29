package com.usbbog.SignchatMS.interfaces;

import com.usbbog.SignchatMS.models.ContactList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactList extends CrudRepository<ContactList, Long>{
}