package ru.rgordeev.server.controllers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class APIController {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Model {
        private String title;
        private String body;
        private Integer count;
    }

    @GetMapping(value = "/get/{name}")
    public ResponseEntity<String> get(@PathVariable(name = "name") String name) {
        String response = String.format("Hello, %s!", name);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Model> post(@RequestBody Model model) {
        return ResponseEntity.ok(model);
    }

    @PutMapping(value = "/put", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Model> put(@RequestBody Model model) {
        return ResponseEntity.ok(model);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        String response = String.format("Item with id: %d was deleted", id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/form", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public ResponseEntity<Map> form(@RequestBody MultiValueMap form) {
        return ResponseEntity.ok(form);
    }

    @GetMapping(value = "/query")
    public ResponseEntity<String> query(@RequestParam("name") String name, @RequestParam("lastname") String lastname) {
        String response = String.format("Hello, %s %s!", name, lastname);
        return ResponseEntity.ok(response);
    }
}
