package com.booboo.CAREN.Api;

import com.booboo.CAREN.Model.Field;
import com.booboo.CAREN.Model.Gamecharacter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/field")
public class FieldController {
    Field field = Field.getInstance();

    @CrossOrigin
    @GetMapping("/character")
    public List<Gamecharacter> getChar(){
        return field.getAllChar();
    }
}
