package com.example.ahnlabportal.OracleUserCRUDTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleRepository extends JpaRepository<OracleEntity, Long> {
}