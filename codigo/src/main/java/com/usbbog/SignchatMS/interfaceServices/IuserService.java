package com.usbbog.SignchatMS.interfaceServices;

import com.usbbog.SignchatMS.models.User;
import java.util.List;
import java.util.Optional;

public interface IuserService {
    public List<User> listarUsuarios();
    public Optional<User> listarUsuariosId(Long id);
    public int CreateUsuario(User p);
    public void DeleteUsuario(Long id);
}