package com.usbbog.SignchatMS.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usbbog.SignchatMS.interfaceServices.ImessageService;
import com.usbbog.SignchatMS.models.Message;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/messages/")
public class MessageController {

    //Traductores
    private final Map<String, String> traductorImgTxt = new HashMap<>();
    private final Map<String, String> traductorTxtImg = new HashMap<>();

    @Value("${image.baseurl}")
    private String imageBaseUrl;

    @PostConstruct
    public void init() {

        //Traductor de imagenes a texto
        traductorImgTxt.put(imageBaseUrl + "sc_0.png", "0");
        traductorImgTxt.put(imageBaseUrl + "sc_1.png", "1");
        traductorImgTxt.put(imageBaseUrl + "sc_2.png", "2");
        traductorImgTxt.put(imageBaseUrl + "sc_3.png", "3");
        traductorImgTxt.put(imageBaseUrl + "sc_4.png", "4");
        traductorImgTxt.put(imageBaseUrl + "sc_5.png", "5");
        traductorImgTxt.put(imageBaseUrl + "sc_6.png", "6");
        traductorImgTxt.put(imageBaseUrl + "sc_7.png", "7");
        traductorImgTxt.put(imageBaseUrl + "sc_8.png", "8");
        traductorImgTxt.put(imageBaseUrl + "sc_9.png", "9");
        traductorImgTxt.put(imageBaseUrl + "sc_a.png", "a");
        traductorImgTxt.put(imageBaseUrl + "sc_b.png", "b");
        traductorImgTxt.put(imageBaseUrl + "sc_c.png", "c");
        traductorImgTxt.put(imageBaseUrl + "sc_d.png", "d");
        traductorImgTxt.put(imageBaseUrl + "sc_e.png", "e");
        traductorImgTxt.put(imageBaseUrl + "sc_f.png", "f");
        traductorImgTxt.put(imageBaseUrl + "sc_g.png", "g");
        traductorImgTxt.put(imageBaseUrl + "sc_h.png", "h");
        traductorImgTxt.put(imageBaseUrl + "sc_i.png", "i");
        traductorImgTxt.put(imageBaseUrl + "sc_j.png", "j");
        traductorImgTxt.put(imageBaseUrl + "sc_k.png", "k");
        traductorImgTxt.put(imageBaseUrl + "sc_l.png", "l");
        traductorImgTxt.put(imageBaseUrl + "sc_m.png", "m");
        traductorImgTxt.put(imageBaseUrl + "sc_n.png", "n");
        traductorImgTxt.put(imageBaseUrl + "sc_ni.png", "ñ");
        traductorImgTxt.put(imageBaseUrl + "sc_o.png", "o");
        traductorImgTxt.put(imageBaseUrl + "sc_p.png", "p");
        traductorImgTxt.put(imageBaseUrl + "sc_q.png", "q");
        traductorImgTxt.put(imageBaseUrl + "sc_r.png", "r");
        traductorImgTxt.put(imageBaseUrl + "sc_s.png", "s");
        traductorImgTxt.put(imageBaseUrl + "sc_t.png", "t");
        traductorImgTxt.put(imageBaseUrl + "sc_u.png", "u");
        traductorImgTxt.put(imageBaseUrl + "sc_v.png", "v");
        traductorImgTxt.put(imageBaseUrl + "sc_w.png", "w");
        traductorImgTxt.put(imageBaseUrl + "sc_x.png", "x");
        traductorImgTxt.put(imageBaseUrl + "sc_y.png", "y");
        traductorImgTxt.put(imageBaseUrl + "sc_z.png", "z");
        //traductorImgTxt.put(imageBaseUrl + "space_view.png", " ");
        traductorImgTxt.put(" ", " ");

        //Traductor de texto a imagenes
        traductorTxtImg.put("0", imageBaseUrl + "sc_0.png");
        traductorTxtImg.put("1", imageBaseUrl + "sc_1.png");
        traductorTxtImg.put("2", imageBaseUrl + "sc_2.png");
        traductorTxtImg.put("3", imageBaseUrl + "sc_3.png");
        traductorTxtImg.put("4", imageBaseUrl + "sc_4.png");
        traductorTxtImg.put("5", imageBaseUrl + "sc_5.png");
        traductorTxtImg.put("6", imageBaseUrl + "sc_6.png");
        traductorTxtImg.put("7", imageBaseUrl + "sc_7.png");
        traductorTxtImg.put("8", imageBaseUrl + "sc_8.png");
        traductorTxtImg.put("9", imageBaseUrl + "sc_9.png");
        traductorTxtImg.put("a", imageBaseUrl + "sc_a.png");
        traductorTxtImg.put("b", imageBaseUrl + "sc_b.png");
        traductorTxtImg.put("c", imageBaseUrl + "sc_c.png");
        traductorTxtImg.put("d", imageBaseUrl + "sc_d.png");
        traductorTxtImg.put("e", imageBaseUrl + "sc_e.png");
        traductorTxtImg.put("f", imageBaseUrl + "sc_f.png");
        traductorTxtImg.put("g", imageBaseUrl + "sc_g.png");
        traductorTxtImg.put("h", imageBaseUrl + "sc_h.png");
        traductorTxtImg.put("i", imageBaseUrl + "sc_i.png");
        traductorTxtImg.put("j", imageBaseUrl + "sc_j.png");
        traductorTxtImg.put("k", imageBaseUrl + "sc_k.png");
        traductorTxtImg.put("l", imageBaseUrl + "sc_l.png");
        traductorTxtImg.put("m", imageBaseUrl + "sc_m.png");
        traductorTxtImg.put("n", imageBaseUrl + "sc_n.png");
        traductorTxtImg.put("ñ", imageBaseUrl + "sc_ni.png");
        traductorTxtImg.put("o", imageBaseUrl + "sc_o.png");
        traductorTxtImg.put("p", imageBaseUrl + "sc_p.png");
        traductorTxtImg.put("q", imageBaseUrl + "sc_q.png");
        traductorTxtImg.put("r", imageBaseUrl + "sc_r.png");
        traductorTxtImg.put("s", imageBaseUrl + "sc_s.png");
        traductorTxtImg.put("t", imageBaseUrl + "sc_t.png");
        traductorTxtImg.put("u", imageBaseUrl + "sc_u.png");
        traductorTxtImg.put("v", imageBaseUrl + "sc_v.png");
        traductorTxtImg.put("w", imageBaseUrl + "sc_w.png");
        traductorTxtImg.put("x", imageBaseUrl + "sc_x.png");
        traductorTxtImg.put("y", imageBaseUrl + "sc_y.png");
        traductorTxtImg.put("z", imageBaseUrl + "sc_z.png");
        traductorTxtImg.put(" ", imageBaseUrl + "space_view.png");
    }

    @Autowired
    private ImessageService service;

    @PostMapping("/create")
    public String crearMensaje(Model model, Message mensaje){
        service.CreateMensaje(mensaje);
        return "Message Created";
    }

    @GetMapping("")
    public List<Message> mostrarMensajes(){
        List<Message> mensajes = service.listarMensajes();
        return mensajes;
    }

    @PostMapping("/translate/img-txt")
    public String traducirImagenes(@RequestBody Map<String, Object> body){

        List<String> imagenes = new ArrayList<>();

        //Pasamos el body a una lista
        for(Object value : body.values()){
            if (value instanceof List){
                List<String> lista = (List<String>) value;
                imagenes.addAll(lista);
            }
        }

        //Traducimos el mensaje
        StringBuilder mensaje = new StringBuilder();

        for (String imagen : imagenes) {
            String significado = traductorImgTxt.get(imagen);
            if (significado != null){
                mensaje.append(significado);
            }
        }

        return mensaje.toString();
    }

    @PostMapping("/translate/txt-img")
    public List<String> traducirTextoAImagenes(@RequestBody Map<String, String> body) {

        String texto = body.get("text");
        List<String> imagenes = new ArrayList<>();

        // Iterar a través del texto y buscar la ruta de imagen correspondiente para cada letra
        for (char letra : texto.toCharArray()) {
            String rutaImagen = traductorTxtImg.get(String.valueOf(letra));
            if (rutaImagen != null) {
                imagenes.add(rutaImagen);
            }
        }

        return imagenes;
    }

}
