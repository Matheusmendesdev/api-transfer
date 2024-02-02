package com.transfer.controllers;

import com.transfer.entities.DTOs.TransferDto;
import com.transfer.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping(value = "/make-transfer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TransferDto> scheduleTransfer(@RequestBody @Valid TransferDto dto) {
        var transfer = transferService.ScheduleTransfer(dto);
        return ResponseEntity.ok(dto);
    }
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransferDto> allTransferLogs(){
        return transferService.findAll();
    }

}
