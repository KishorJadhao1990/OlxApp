package com.zensar.services;

import com.zensar.exception.BadRequestException;
import com.zensar.helper.CategoryServiceHelper;
import com.zensar.model.Advertise;
import com.zensar.model.User;
import com.zensar.repository.AdvertiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseRepository advertiseRepository;
    @Autowired
    private CategoryServiceHelper categoryServiceHelper;

    @Override
    public Optional<Advertise> fetchAdvertise(Long id) {
        return advertiseRepository.findById(id);
    }

    @Override
    public Page<Advertise> fetchAllAdvertise(Pageable pageable) {
        return advertiseRepository.findAll(pageable);
    }

    @Override
    public Optional<Advertise> saveNewAdvertise(Advertise advertise, User loggedInUser, String token) {
        advertise.setCCUU(loggedInUser.getId());
        categoryServiceHelper.fetchCategory(advertise.getCategoryId(), token);
        return Optional.of(advertiseRepository.save(advertise));
    }

    @Override
    public Optional<Advertise> updateAdvertise(Advertise advertise, User loggedInUser, String token) {
        Optional<Advertise> advertiseOptional = advertiseRepository.findById(advertise.getId());
        Advertise dbAdvertise = advertiseOptional.orElseThrow(() -> new BadRequestException("error.advertiseNotFound"));
        dbAdvertise.setUU(loggedInUser.getId());
        dbAdvertise.setTitle(advertise.getTitle());
        dbAdvertise.setPrice(advertise.getPrice());
        categoryServiceHelper.fetchCategory(advertise.getCategoryId(), token);
        dbAdvertise.setCategoryId(advertise.getCategoryId());
        dbAdvertise.setDescription(advertise.getDescription());

        return Optional.of(advertiseRepository.save(dbAdvertise));
    }

}
