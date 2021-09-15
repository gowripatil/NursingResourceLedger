package com.cse682.nursingresourceledgerprototype.repository;

import com.cse682.nursingresourceledgerprototype.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger,Long> {
}
