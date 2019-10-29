package com.chanduknr.newmsscbrewery.service;

import com.chanduknr.newmsscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomer(UUID customerId);
}
