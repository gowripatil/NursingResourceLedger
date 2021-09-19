package com.cse682.nursingresourceledgerprototype.controller;

import com.cse682.nursingresourceledgerprototype.entity.Ledger;
import com.cse682.nursingresourceledgerprototype.service.LedgerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * LegderController class handles create/update a ledger and list all ledger
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/ledger")
public class LedgerController {
    private final LedgerServiceImpl ledgerService;

    public LedgerController(LedgerServiceImpl ledgerService){
        this.ledgerService = ledgerService;
    }

    /**
     * GET method to handle listing of all ledgers.
     * User calls GET http://localhost:8080/auth/ledger/all REST API. It returns all ledgers
     * if succesfull.
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<Ledger>> getAllEmployees(){
        List<Ledger> ledgerList = ledgerService.getAllLedgers();
        return new ResponseEntity<List<Ledger>>(ledgerList, HttpStatus.OK);
    }

    /**
     * POST method to handle ledger creation.
     * User calls POST http://localhost:8080/auth/ledger/add REST API. Ledger details are passed
     * in the request body and the response is
     * 200 - If Ledger creation is successful
     * 400 - If Ledger creation is not successful
     * @param ledger
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Ledger> addEmployee(@RequestBody Ledger ledger){
        Ledger addLedger = ledgerService.addLedger(ledger);
        return new ResponseEntity<Ledger>(addLedger, HttpStatus.CREATED);
    }

    /**
     * POST method to handle ledger update.
     * User calls POST http://localhost:8080/auth/ledger/update REST API. Ledger details are passed
     * in the request body and the response is
     * 200 - If Ledger update is successful
     * 400 - If Ledger update is not successful
     * @param ledger
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Ledger> updateEmployee(@RequestBody Ledger ledger){
        Ledger updateLedger = ledgerService.updateLedger(ledger);
        return new ResponseEntity<Ledger>(updateLedger, HttpStatus.CREATED);
    }


}