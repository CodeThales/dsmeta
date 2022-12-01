package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    public SaleService service;
    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable){
        return service.findSales(minDate, maxDate,pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }

    @PostMapping("/newSale")
    public Sale addNewSale(@RequestBody Sale sale) {
            Sale newSale = new Sale(sale.getSellerName(), sale.getVisited(), sale.getDeals(), sale.getAmount(), sale.getDate());
            return service.addNewSale(newSale);
    }







}
