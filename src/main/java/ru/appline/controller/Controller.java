package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.CompasNew;
import ru.appline.logic.CompasModel;

import java.util.Map;

@RestController
public class Controller {
    private  static final CompasModel compasModel = CompasModel.getInstance();

    @PostMapping(value = "/create", consumes = "application/json")
    public String create(@RequestBody Map<String, CompasNew> map){
        compasModel.add(map);
        return "Вы создали сторону света!";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<String, CompasNew> getAll() {
        return compasModel.getAll();
    }

    @GetMapping(value = "/getFromList", consumes = "application/json", produces = "application/json")
    public Map<String, String> getFromList(@RequestBody Map<String, Integer> degree) {
        return compasModel.getFromList(degree.get("Degree"));
    }
}

// Выполнила Маркина Ксения