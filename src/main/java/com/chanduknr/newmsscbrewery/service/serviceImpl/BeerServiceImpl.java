package com.chanduknr.newmsscbrewery.service.serviceImpl;

import com.chanduknr.newmsscbrewery.web.model.BeerDto;
import com.chanduknr.newmsscbrewery.service.BeerService;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID beerId) {
        return  BeerDto.builder().id(UUID.randomUUID()).beerName("Carona Extra").upc(80660956053l).beerStyle("American-style").build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteBeer(String beerID) {

    }
}
