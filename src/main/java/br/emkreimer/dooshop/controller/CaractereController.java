package br.emkreimer.dooshop.controller;

import br.emkreimer.dooshop.model.CharResponse;
import br.emkreimer.dooshop.service.CaractereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caracteres")
public class CaractereController {

    @Autowired
    CaractereService charService;

    @PostMapping()
    public CharResponse processString(@RequestBody String word) {
        return charService.getResults(word);


    }
}
