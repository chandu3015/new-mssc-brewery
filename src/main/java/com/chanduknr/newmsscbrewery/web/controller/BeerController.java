package com.chanduknr.newmsscbrewery.web.controller;

import com.chanduknr.newmsscbrewery.web.model.BeerDto;
import com.chanduknr.newmsscbrewery.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private BeerService beerService;

    BeerController(BeerService beerService)
    {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId")UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeer(beerId),HttpStatus.OK);
    }
}
