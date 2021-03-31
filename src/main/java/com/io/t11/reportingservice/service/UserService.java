package com.io.t11.reportingservice.service;

import com.io.t11.reportingservice.dao.OrderRepository;
import com.io.t11.reportingservice.dao.PortfolioRepository;
import com.io.t11.reportingservice.dao.UserRepository;
import com.io.t11.reportingservice.dto.OrderDto;
import com.io.t11.reportingservice.dto.PortfolioDto;
import com.io.t11.reportingservice.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger((UserService.class));

    @Autowired
    UserRepository userRepository;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    public UserService(UserRepository userRepository, PortfolioRepository portfolioRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.portfolioRepository = portfolioRepository;
        this.orderRepository = orderRepository;
    }

    //get all users
    public ArrayList<UserDto> getAllUsers() {
        logger.info("Operation running....");
        return (ArrayList<UserDto>) userRepository.findAll();
    }

    public ArrayList<PortfolioDto> getUserPortfolio(Long userId) {
        logger.info("Retrieving user portfolio with id: {}", userId);
        return (ArrayList<PortfolioDto>) portfolioRepository.getUserPortfolios(userId);
    }

    public ArrayList<PortfolioDto> getAllPortfolios() {
        logger.info("Operation running....");
        return (ArrayList<PortfolioDto>) portfolioRepository.findAll();
    }

    public ArrayList<OrderDto> getAllOrders() {
        logger.info("Operation running....");
        return (ArrayList<OrderDto>) orderRepository.findAll();
    }

    public List<OrderDto> getUserOrders(UserDto userId){
        logger.info("Operation running....");
        return orderRepository.findAllByUserId(userId);
    }
}
