package com.chanduknr.newmsscbrewery.service;

import com.chanduknr.newmsscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeer(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(String beerID);
}
