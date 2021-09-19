package com.cse682.nursingresourceledgerprototype.repository;

import com.cse682.nursingresourceledgerprototype.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LedgerRepository class. JpaRepository implements the CRUD repository APIs.
 */
@Repository
public interface LedgerRepository extends JpaRepository<Ledger,Long> {
}
