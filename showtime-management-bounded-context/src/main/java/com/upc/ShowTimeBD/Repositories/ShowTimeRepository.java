package com.upc.ShowTimeBD.Repositories;

import com.upc.ShowTimeBD.Models.ShowTimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTimeModel, Long> {
    //int updateCapacity(Long id, int capacity) throws Exception;

}
