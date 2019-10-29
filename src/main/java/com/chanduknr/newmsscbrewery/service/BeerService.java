package com.chanduknr.newmsscbrewery.service;

import com.chanduknr.newmsscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeer(UUID beerId);
}
