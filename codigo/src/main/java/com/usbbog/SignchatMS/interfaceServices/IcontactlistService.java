package com.usbbog.SignchatMS.interfaceServices;

import com.usbbog.SignchatMS.models.ContactList;
import java.util.List;
import java.util.Optional;

public interface IcontactlistService {
    public List<ContactList> listarContactos();
    public Optional<ContactList> listarContactosId(Long id);
    public int CreateContacto(ContactList p);
    public void DeleteContacto(Long id);
}