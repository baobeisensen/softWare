package com.zms.girl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GirlService extends JpaRepository<Girldb,Integer> {
    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    List<Girldb> findByAge(Integer age);
}
