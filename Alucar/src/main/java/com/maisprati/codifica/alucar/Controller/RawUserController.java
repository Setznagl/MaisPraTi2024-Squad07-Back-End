package com.maisprati.codifica.alucar.Controller;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rawusers")
public class RawUserController {

    private final RawUserService rawUserService;

    @Autowired
    public RawUserController(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }

    @PostMapping
    public ResponseEntity<Void> createRawUser(@RequestBody RawUser rawUser) {
        rawUserService.InsertRawUser(rawUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
