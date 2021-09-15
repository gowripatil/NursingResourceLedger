package com.cse682.nursingresourceledgerprototype.controller;

import com.cse682.nursingresourceledgerprototype.entity.Ledger;
import com.cse682.nursingresourceledgerprototype.service.LedgerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/auth/ledger")
public class LedgerController {
    private final LedgerServiceImpl ledgerService;

    public LedgerController(LedgerServiceImpl ledgerService){
        this.ledgerService = ledgerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ledger>> getAllEmployees(){
        List<Ledger> ledgerList = ledgerService.getAllLedgers();
        return new ResponseEntity<List<Ledger>>(ledgerList, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Ledger> addEmployee(@RequestBody Ledger ledger){
        Ledger addLedger = ledgerService.addLedger(ledger);
        return new ResponseEntity<Ledger>(addLedger, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Ledger> updateEmployee(@RequestBody Ledger ledger){
        Ledger updateLedger = ledgerService.updateLedger(ledger);
        return new ResponseEntity<Ledger>(updateLedger, HttpStatus.CREATED);
    }


}