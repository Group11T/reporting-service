package com.io.t11.reportingservice.dao;

import com.io.t11.reportingservice.dto.OrderDto;
import com.io.t11.reportingservice.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderDto, Long> {
    List<OrderDto> findAllByUserId(UserDto userId);
}
