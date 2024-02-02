package com.transfer.entities.DTOs;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransferDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private String originAccount;
    @NotNull
    private String destinyAccount;
    @NotNull
    private double transferValue;
    private double tax;
    @Future
    private LocalDate transferDate;
    @NotNull
    private LocalDateTime scheduling;

    public TransferDto() {}

    public TransferDto(String originAccount, String destinyAccount, double transferValue, double tax, LocalDate transferDate, LocalDateTime scheduling) {
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
        this.transferValue = transferValue;
        this.tax = tax;
        this.transferDate = transferDate;
        this.scheduling = scheduling;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public String getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(String destinyAccount) {
        this.destinyAccount = destinyAccount;
    }

    public double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(double transferValue) {
        this.transferValue = transferValue;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public LocalDateTime getScheduling() {
        return scheduling;
    }

    public void setScheduling(LocalDateTime scheduling) {
        this.scheduling = scheduling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferDto that = (TransferDto) o;
        return Double.compare(transferValue, that.transferValue) == 0 && Double.compare(tax, that.tax) == 0 && Objects.equals(originAccount, that.originAccount) && Objects.equals(destinyAccount, that.destinyAccount) && Objects.equals(transferDate, that.transferDate) && Objects.equals(scheduling, that.scheduling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originAccount, destinyAccount, transferValue, tax, transferDate, scheduling);
    }
}
