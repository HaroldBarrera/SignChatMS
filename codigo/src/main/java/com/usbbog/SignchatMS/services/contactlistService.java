package com.usbbog.SignchatMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usbbog.SignchatMS.interfaceServices.IcontactlistService;
import com.usbbog.SignchatMS.interfaces.IContactList;
import com.usbbog.SignchatMS.models.ContactList;

@Service
public class contactlistService implements IcontactlistService {

    @Autowired
    private IContactList data;

    @Override
    public List<ContactList> listarContactos(){
        return (List<ContactList>) data.findAll();
    }

    @Override
    public Optional<ContactList> listarContactosId(Long id){
        return data.findById(id);
    }

    @Override
    public int CreateContacto(ContactList p){
        int res = 0;
        ContactList contacto = data.save(p);
        if(!contacto.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void DeleteContacto(Long id){
        data.deleteById(id);
    }
}