package com.transfer.services;

import com.transfer.entities.DTOs.TransferDto;
import com.transfer.exceptions.TaxInvalidException;
import com.transfer.valid.ValidatorDays;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TaxValidators {
    public static double tax(long days, double value){
        if(days == 0){
            return (3.0 * value) / 100;
        }
        if(days > 0 && days <= 10){
            return 12.0;
        }
        if(days >= 11 && days <= 20){
            return (8.2 * value) / 100;
        }
        if(days >= 21 && days <= 30){
            return (6.9 * value) / 100;
        }
        if(days >= 31 && days <= 40){
            return (4.7 * value) / 100;
        }
        if(days >= 41 && days <= 50){
            return (1.7 * value) / 100;
        }else{
            return 0L;
        }
    }

    public static void validTax(List<ValidatorDays> days, TransferDto dto) {
        days.forEach(v -> {
            try {
                v.validator(dto.getTax());
            } catch (Exception e) {
                throw new TaxInvalidException("Cannot schedule for more than 50 days!");
            }
        });
    }


    public static long calcDateDif(LocalDate date) {
        return ChronoUnit.DAYS.between(LocalDate.now(), date);
    }
}
