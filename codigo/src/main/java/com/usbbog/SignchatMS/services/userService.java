package com.usbbog.SignchatMS.services;

import com.usbbog.SignchatMS.interfaceServices.IuserService;
import com.usbbog.SignchatMS.interfaces.IUser;
import com.usbbog.SignchatMS.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService implements IuserService{
    
    @Autowired
    private IUser data;

    @Override
    public List<User> listarUsuarios(){
        return (List<User>) data.findAll();
    }

    @Override
    public Optional<User> listarUsuariosId(Long id){
        return data.findById(id);
    }

    @Override
    public int CreateUsuario(User p){
        int res = 0;
        User usuario = data.save(p);
        if(!usuario.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void DeleteUsuario(Long id){
        data.deleteById(id);
    }
}