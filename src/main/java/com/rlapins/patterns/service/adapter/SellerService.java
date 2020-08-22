package com.rlapins.patterns.service.adapter;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements Seller {

    @Override
    public String getSellerId() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        return generator.generate(20);
    }

}
