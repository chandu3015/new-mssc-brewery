package com.chanduknr.newmsscbrewery.web.controller;

import com.chanduknr.newmsscbrewery.web.model.BeerDto;
import com.chanduknr.newmsscbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto)
    {
        BeerDto savedBeer = beerService.saveBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","api/v1/beer/"+savedBeer.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId")UUID beerId,@RequestBody BeerDto beerDto)
    {

        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{beerId}"})
    public void deleteBeer(@PathVariable("beerId")UUID beerId)
    {
        beerService.deleteBeer("beerID");
    }
}
