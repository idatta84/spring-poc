package com.springconcepts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springconcepts.beans.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

    public Order findByTrackingId(String trackingId);
    
}