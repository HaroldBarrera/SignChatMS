package com.usbbog.SignchatMS.interfaceServices;

import com.usbbog.SignchatMS.models.Message;
import java.util.List;
import java.util.Optional;

public interface ImessageService {
    public List<Message> listarMensajes();
    public Optional<Message> listarMensajesId(Long id);
    public int CreateMensaje(Message p);
    public void DeleteMensaje(Long id);
}