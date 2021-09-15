package com.cse682.nursingresourceledgerprototype.service;

import com.cse682.nursingresourceledgerprototype.entity.Ledger;
import com.cse682.nursingresourceledgerprototype.repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedgerServiceImpl {


    private final LedgerRepository ledgerRepository;

    @Autowired
    public LedgerServiceImpl(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public Ledger addLedger(Ledger  ledger){
        return ledgerRepository.save(ledger);
    }

    public List<Ledger> getAllLedgers(){
        return ledgerRepository.findAll();
    }

    public Ledger updateLedger(Ledger ledger){
        return ledgerRepository.save(ledger);
    }

}
