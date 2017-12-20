package com.zms.girl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GirlService extends JpaRepository<Girldb,Integer> {
}
