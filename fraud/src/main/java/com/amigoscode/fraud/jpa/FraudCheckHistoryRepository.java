package com.amigoscode.fraud.jpa;

import com.amigoscode.fraud.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends
        JpaRepository<FraudCheckHistory,Integer> {
}
