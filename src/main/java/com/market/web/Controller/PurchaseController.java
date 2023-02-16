package com.market.web.Controller;

import com.market.domain.Purchase;
import com.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService service;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public Optional<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
        return service.getByClient(clientId);
    }

    @PostMapping("/save")
    public Purchase save(@RequestBody Purchase purchase) {
        return service.save(purchase);
    }
}
