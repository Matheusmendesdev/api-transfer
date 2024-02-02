package com.transfer.mapper;

import com.transfer.entities.DTOs.TransferDto;
import com.transfer.entities.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);

    @Mapping(source = "originAccount", target = "originAccount")
    @Mapping(source = "destinyAccount", target = "destinyAccount")
    @Mapping(source = "transferValue", target = "transferValue")
    @Mapping(source = "tax", target = "tax")
    @Mapping(source = "transferDate", target = "transferDate")
    @Mapping(source = "scheduling", target = "scheduling")
    TransferDto transferToTransferDto(Transfer transfer);

    @Mapping(source = "originAccount", target = "originAccount")
    @Mapping(source = "destinyAccount", target = "destinyAccount")
    @Mapping(source = "transferValue", target = "transferValue")
    @Mapping(source = "tax", target = "tax")
    @Mapping(source = "transferDate", target = "transferDate")
    @Mapping(source = "scheduling", target = "scheduling")
    Transfer transferDtoToTransfer(TransferDto transferDto);

    @Mapping(source = "originAccount", target = "originAccount")
    @Mapping(source = "destinyAccount", target = "destinyAccount")
    @Mapping(source = "transferValue", target = "transferValue")
    @Mapping(source = "tax", target = "tax")
    @Mapping(source = "transferDate", target = "transferDate")
    @Mapping(source = "scheduling", target = "scheduling")
    List<TransferDto> transferToListDTO(List<Transfer> transfer);
}
