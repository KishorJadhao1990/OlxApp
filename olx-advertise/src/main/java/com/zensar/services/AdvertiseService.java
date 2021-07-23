package com.zensar.services;

import com.zensar.model.Advertise;
import com.zensar.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface AdvertiseService {

    Optional<Advertise> fetchAdvertise(Long id);
    Page<Advertise> fetchAllAdvertise(Pageable pageable);
    Optional<Advertise> saveNewAdvertise(Advertise advertise, User loggedInUser, String token);
    Optional<Advertise> updateAdvertise(Advertise advertise, User loggedInUser, String token);

}
