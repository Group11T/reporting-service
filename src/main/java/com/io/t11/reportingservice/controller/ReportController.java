package com.io.t11.reportingservice.controller;

import com.io.t11.reportingservice.dto.OrderDto;
import com.io.t11.reportingservice.dto.PortfolioDto;
import com.io.t11.reportingservice.dto.ReportDto;
import com.io.t11.reportingservice.dto.UserDto;
import com.io.t11.reportingservice.model.CustomApiResponses;
import com.io.t11.reportingservice.service.ReportService;
import com.io.t11.reportingservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static Logger logger = LoggerFactory.getLogger((ReportController.class));

    @Autowired
    private final ReportService reportService;

    @Autowired
    private final UserService userService;

    @Autowired
    public ReportController(ReportService reportService, UserService userService){
        this.reportService = reportService;
        this.userService = userService;
    }

    @PostMapping("/save_report")
    public ResponseEntity<CustomApiResponses> saveReport(@RequestBody ReportDto reportDto) {
        logger.info("Received request object: {}", reportDto);
        reportService.saveReport(reportDto);
        logger.info("Saved request");
        CustomApiResponses responses = new CustomApiResponses(201, "report saved");
        return ResponseEntity.ok().body(responses);

        // add error
    }

    @GetMapping("/reports")
    public ResponseEntity<List<ReportDto>> getAllReports() {
        ArrayList<ReportDto> reportDtos;
        //ReportDto reportDto = new ReportDto();
        logger.info("Fetching list of all orders.....");
        reportDtos = reportService.getAllOrders();
        return ResponseEntity.ok().body(reportDtos);
    }

    @GetMapping("/reports/{publisher}")
    public ResponseEntity<List<ReportDto>> getPublisherReports(@PathVariable String publisher) {
        ArrayList<ReportDto> reportDtoList;
        logger.info("Fetching list of publisher: {} reports", publisher);
        reportDtoList = reportService.getPublisherOrders(publisher);
        return ResponseEntity.ok().body(reportDtoList);
    }

    @GetMapping("/reports/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        ArrayList<UserDto> userDtoArrayList;
        logger.info("Fetching list of users....");
        userDtoArrayList = userService.getAllUsers();
        return ResponseEntity.ok().body(userDtoArrayList);
    }

//    @GetMapping("/reports/user/portfolio/{userId}")
//    public ResponseEntity<List<PortfolioDto>> getUserPortfolio(@PathVariable Long userId) {
//        ArrayList<PortfolioDto> portfolioDtoArrayList;
//        logger.info("Fetching portfolio list for user: {}", userId);
//        portfolioDtoArrayList = userService.getUserPortfolio(userId);
//        return ResponseEntity.ok().body(portfolioDtoArrayList);
//    }

    @GetMapping("/reports/orders")
    public ResponseEntity<ArrayList<OrderDto>> getAllOrders() {
        ArrayList<OrderDto> orderDtoArrayList;
        logger.info("Fetching all orders ...");
        orderDtoArrayList = userService.getAllOrders();
        return ResponseEntity.ok().body(orderDtoArrayList);
    }

//    @GetMapping("/reports/{userId}/orders")
//    public ResponseEntity<List<OrderDto>> getUserOrders(@PathVariable Long userId) {
//        List<OrderDto> orderDtoArrayList;
//        logger.info("Fetching orders performed by user: {}", userId);
//        UserDto userDto = new UserDto();
//        userDto.setId(userId);
//        orderDtoArrayList = userService.getUserOrders(userDto);
//        return ResponseEntity.ok().body(orderDtoArrayList);
//    }

}
