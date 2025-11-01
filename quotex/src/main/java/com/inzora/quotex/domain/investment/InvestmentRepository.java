package com.inzora.quotex.domain.investment;

import com.inzora.quotex.application.dtos.InvestmentResponseDTO;
import com.inzora.quotex.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, UUID> {
    @Query("SELECT new InvestmentResponseDTO(i) " +
            "FROM Investment i " +
            "WHERE i.user.id = :userId")
    List<InvestmentResponseDTO> findInvestmentByUser(@Param("userId") String userId);
}
