package com.zensar.controller;

import com.zensar.dto.AdvertiseDto;
import com.zensar.exception.BadRequestException;
import com.zensar.helper.LoginServiceHelper;
import com.zensar.model.Advertise;
import com.zensar.model.User;
import com.zensar.services.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/advertise")
public class AdvertiseController {

    @Autowired
    private AdvertiseService advertiseService;
    @Autowired
    private LoginServiceHelper loginServiceHelper;

    @PostMapping(name = "/",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertise> saveNewAdvertise(@Valid @RequestBody AdvertiseDto advertiseDto, WebRequest webRequest){
        User loggedInUser = loginServiceHelper.authenticateUser(webRequest);
        Advertise advertise = advertiseDto.buildAdvertiseModel();
        Optional<Advertise> advertiseOpt = advertiseService.saveNewAdvertise(advertise, loggedInUser);
        Advertise dbAdvertise = advertiseOpt.orElseThrow(()-> new BadRequestException("error.failedToSave"));
        return new ResponseEntity<>(dbAdvertise, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertise> updateAdvertise(@Valid @RequestBody AdvertiseDto advertiseDto, @PathVariable Long id, WebRequest webRequest) {
        User loggedInUser = loginServiceHelper.authenticateUser(webRequest);
        Advertise advertise = advertiseDto.buildAdvertiseModel();
        advertise.setId(id);
        Optional<Advertise> advertiseOpt = advertiseService.updateAdvertise(advertise,loggedInUser);
        Advertise dbAdvertise = advertiseOpt.orElseThrow(()-> new BadRequestException("error.failedToUpdate"));
        return new ResponseEntity<>(dbAdvertise, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Advertise> fetchAdvertise(@PathVariable("id") Long id, @RequestHeader("Authorization") String authToken){
        loginServiceHelper.authenticateUser(authToken);
        Optional<Advertise> advertiseOpt = advertiseService.fetchAdvertise(id);
        Advertise dbAdvertise = advertiseOpt.orElseThrow(()-> new BadRequestException("error.advertiseNotFound"));
        return new ResponseEntity<>(dbAdvertise, HttpStatus.OK);
    }

    @GetMapping(value = "/page",produces = "application/json")
    public Page<Advertise> fetchAdvertisePage(Pageable pageable, @RequestHeader("Authorization") String authToken){
        loginServiceHelper.authenticateUser(authToken);
        return advertiseService.fetchAllAdvertise(pageable);
    }
}
