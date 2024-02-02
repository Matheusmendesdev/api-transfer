package com.transfer.valid;

import com.transfer.entities.DTOs.TransferDto;
import org.springframework.stereotype.Component;

@Component
public class TransferValid implements ValidatorDays{
    @Override
    public void validator(double dto) throws Exception {
        if (dto == 0){
            throw new Exception("Não pode ser 0");
        }
    }
}
