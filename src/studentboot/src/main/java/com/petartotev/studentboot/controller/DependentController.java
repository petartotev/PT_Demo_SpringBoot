package com.petartotev.studentboot.controller;

import com.petartotev.studentboot.diexamples.*;
import com.petartotev.studentboot.model.Car;
import com.petartotev.studentboot.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/dependent")
public class DependentController {
    private final Singletony mySingletony;
    private final Requesty myRequesty;
    private final Prototypey myPrototypey;

    public DependentController(Singletony singletony, Requesty requesty, Prototypey prototypey) {
        this.mySingletony = singletony;
        this.myRequesty = requesty;
        this.myPrototypey = prototypey;
    }

    @GetMapping("/singleton")
    public int getSingletonNumber() {
        return mySingletony.doSingletony();
    }

    @GetMapping("/request")
    public int getRequestNumber() {
        return myRequesty.doRequesty();
    }
}