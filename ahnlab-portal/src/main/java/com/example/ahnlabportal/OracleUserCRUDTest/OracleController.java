package com.example.ahnlabportal.OracleUserCRUDTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class OracleController {

    @Autowired
    private OracleService oracleService;

    @GetMapping
    public ResponseEntity<List<OracleEntity>> getAllUsers() {
        return ResponseEntity.ok(oracleService.getAllUsers());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<OracleEntity> getUserById(@PathVariable Long id) {
//        return ResponseEntity.of(oracleService.getUserById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<OracleEntity> createUser(@RequestBody OracleEntity user) {
//        return ResponseEntity.ok(oracleService.createUser(user));
//    }
//
//    @PutMapping
//    public ResponseEntity<OracleEntity> updateUser(@RequestBody OracleEntity user) {
//        return ResponseEntity.ok(oracleService.updateUser(user));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        oracleService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }
}
