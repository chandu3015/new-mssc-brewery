package com.chanduknr.newmsscbrewery.web.controller;

import com.chanduknr.newmsscbrewery.service.CustomerService;
import com.chanduknr.newmsscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;


    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId)
    {
        return new ResponseEntity<CustomerDto>((CustomerDto) customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto)
    {
        CustomerDto savedCutomer = this.customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/customer/"+savedCutomer.getId());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity updateCustomer(@PathVariable("customerId")UUID customerId,@RequestBody CustomerDto customerDto)
    {
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    public void deleteCustomer(@PathVariable("customerId")UUID customerId)
    {
        customerService.deleteCustomer(customerId);
    }
}
