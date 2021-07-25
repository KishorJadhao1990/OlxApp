package com.zensar.repository;

import com.zensar.model.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {
}
