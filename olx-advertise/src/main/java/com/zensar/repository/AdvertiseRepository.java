package com.zensar.repository;

import com.zensar.model.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {
}
