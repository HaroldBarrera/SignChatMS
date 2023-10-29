package com.usbbog.SignchatMS.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class KeyboardController {
    private final ResourceLoader resourceLoader;

    @Value("${image.baseurl}")
    private String imageBaseUrl;

    public KeyboardController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/images/{imageName}")
    public void getImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/static/keyboard/" + imageName);

        if (resource.exists()){
            InputStream inputStream = resource.getInputStream();
            response.setContentType("image/jpeg"); //Adaptar el tipo de imagen (PNG, JPEG, etc)
            StreamUtils.copy(inputStream, response.getOutputStream());
        } else {
            // TODO: Hacer algo en caso de que no exista la imagen
        }
    }

    @GetMapping("/keyboard")
    public ResponseEntity<String> getSpecialKeyboard(){
        StringBuilder html = new StringBuilder();
        html.append("<div class=\"keyboard\">");

        //Generar los <img/> para cada tecla 0-9
        for(char key = '0'; key <= '9'; key++){
            String imageName = "sc_" + key + ".png";
            html.append("<button class=\"key-button\" data-key=\"").append(key).append("\" onclick=\"LscKeyPressed(this)\">");
            html.append("<img src=\"").append(imageBaseUrl).append(imageName).append("\" alt=\"").append(key).append("\">");
            html.append("</button>");
        }

        html.append("<br />");

        //Generar los <img/> para cada tecla a-z
        for(char key = 'a'; key <= 'z'; key++){
            String imageName = "sc_" + key + ".png";
            html.append("<button class=\"key-button\" data-key=\"").append(key).append("\" onclick=\"LscKeyPressed(this)\">");
            html.append("<img src=\"").append(imageBaseUrl).append(imageName).append("\" alt=\"").append(key).append("\">");
            html.append("</button>");

            //Letra ñ
            if (key == 'n'){
                html.append("<button class=\"key-button\" data-key=\"").append("ñ").append("\" onclick=\"LscKeyPressed(this)\">");
                html.append("<img src=\"").append(imageBaseUrl).append("sc_ni.png").append("\" alt=\"").append("ñ").append("\">");
                html.append("</button>");
            }

            //Salto de Linea cada 10 teclas
            if ((key - 'a' + 1) % 10 == 0){
                html.append("<br />");
            }
        }

        html.append("<br />");

        //Teclas SPACE y BORRAR
        html.append("<button class=\"key-button\" data-key=\"").append(" ").append("\" onclick=\"LscKeyPressed(this)\">");
        html.append("<img src=\"").append(imageBaseUrl).append("space_key.png").append("\" alt=\"").append(" ").append("\">");
        html.append("</button>");

        html.append("<button class=\"key-button\" data-key=\"").append("del").append("\" onclick=\"LscKeyPressed(this)\">");
        html.append("<img src=\"").append(imageBaseUrl).append("delete_key.png").append("\" alt=\"").append("del").append("\">");
        html.append("</button>");

        // Agregar el script para manejar el evento de clic
        html.append("<script>");
        html.append("function LscKeyPressed(button) {");
        html.append("    var key = button.getAttribute('data-key');");
        html.append("    console.log('Tecla clickeada:', key);");
        html.append("}");
        html.append("</script>");

        html.append("</div>");

        return ResponseEntity.ok().body(html.toString());
    }

    @GetMapping("/keyboard/react")
    public ResponseEntity<String> getSpecialKeyboardReact(){
        StringBuilder html = new StringBuilder();
        html.append("<div class=\"keyboard\">");

        //Generar los <img/> para cada tecla 0-9
        for(char key = '0'; key <= '9'; key++){
            String imageName = "sc_" + key + ".png";
            //html.append("<button className=\"key-button\" data-key=\"").append(key).append("\" onClick={handleButtonClick}>");
            html.append("<button className=\"key-button\" data-key=\"").append(key).append("\">");
            //html.append("<button className=\"key-button\" data-key=\"").append(key).append("\" onclick=\"handleButtonClick(this)\">");
            html.append("<img src=\"").append(imageBaseUrl).append(imageName).append("\" alt=\"").append(key).append("\">");
            html.append("</button>");
        }

        html.append("<br />");

        //Generar los <img/> para cada tecla a-z
        for(char key = 'a'; key <= 'z'; key++){
            String imageName = "sc_" + key + ".png";
            html.append("<button className=\"key-button\" data-key=\"").append(key).append("\">");
            //html.append("<button className=\"key-button\" data-key=\"").append(key).append("\" onClick={handleButtonClick}>");
            //html.append("<button className=\"key-button\" data-key=\"").append(key).append("\" onclick=\"handleButtonClick(this)\">");
            html.append("<img src=\"").append(imageBaseUrl).append(imageName).append("\" alt=\"").append(key).append("\">");
            html.append("</button>");

            //Letra ñ
            if (key == 'n'){
                html.append("<button class=\"key-button\" data-key=\"").append("ñ").append("\">");
                html.append("<img src=\"").append(imageBaseUrl).append("sc_ni.png").append("\" alt=\"").append("ñ").append("\">");
                html.append("</button>");
            }

            //Salto de Linea cada 10 teclas
            if ((key - 'a' + 1) % 10 == 0){
                html.append("<br />");
            }
        }

        html.append("<br />");

        //Teclas SPACE y BORRAR
        String spaceImageAlt = imageBaseUrl + "space_view.png";
        html.append("<button class=\"key-button\" data-key=\"").append(" ").append("\">");
        html.append("<img src=\"").append(imageBaseUrl).append("space_key.png").append("\" alt=\"").append(" ").append("\">");
        html.append("</button>");

        html.append("<button class=\"key-button\" data-key=\"").append("del").append("\">");
        html.append("<img src=\"").append(imageBaseUrl).append("delete_key.png").append("\" alt=\"").append("del").append("\">");
        html.append("</button>");

        // Agregar el script para manejar el evento de clic
//        html.append("<script>");
//        html.append("function LscKeyPressed(button) {");
//        html.append("    var key = button.getAttribute('data-key');");
//        html.append("    console.log('Tecla clickeada:', key);");
//        html.append("}");
//        html.append("</script>");
//
//        html.append("</div>");

        return ResponseEntity.ok().body(html.toString());
    }
}
