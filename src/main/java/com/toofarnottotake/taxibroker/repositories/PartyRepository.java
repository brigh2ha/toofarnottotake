package com.toofarnottotake.taxibroker.repositories;

import com.toofarnottotake.taxibroker.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
