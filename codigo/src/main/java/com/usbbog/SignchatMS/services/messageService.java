package com.usbbog.SignchatMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usbbog.SignchatMS.interfaceServices.ImessageService;
import com.usbbog.SignchatMS.interfaces.IMessage;
import com.usbbog.SignchatMS.models.Message;

@Service
public class messageService implements ImessageService {

    @Autowired
    private IMessage data;

    @Override
    public List<Message> listarMensajes(){
        return (List<Message>) data.findAll();
    }

    @Override
    public Optional<Message> listarMensajesId(Long id){
        return data.findById(id);
    }

    @Override
    public int CreateMensaje(Message p){
        int res = 0;
        Message mensaje = data.save(p);
        if(!mensaje.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void DeleteMensaje(Long id){
        data.deleteById(id);
    }
}