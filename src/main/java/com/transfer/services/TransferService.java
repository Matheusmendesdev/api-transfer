package com.transfer.services;

import com.transfer.entities.DTOs.TransferDto;
import com.transfer.mapper.TransferMapper;
import com.transfer.repository.TransferRepository;
import com.transfer.valid.ValidatorDays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private List<ValidatorDays> validatorDays;

    public TransferDto ScheduleTransfer(TransferDto dto){
        long dateDif = TaxValidators.calcDateDif(dto.getTransferDate());
        double resultTax = TaxValidators.tax(dateDif, dto.getTransferValue());

        dto.setTax(resultTax);
        TaxValidators.validTax(validatorDays, dto);

        var transfer = TransferMapper.INSTANCE.transferDtoToTransfer(dto);
        var save = TransferMapper.INSTANCE.transferToTransferDto(transferRepository.save(transfer));
        return save;
    }

    public List<TransferDto> findAll() {
        var dto = TransferMapper.INSTANCE.transferToListDTO(transferRepository.findAll());
        return dto;
    }
}