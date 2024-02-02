package com.transfer.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Transfer")
@Table(name = "transfer")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_account")
    private String originAccount;

    @Column(name = "destiny_account")
    private String destinyAccount;

    @Column(name = "transfer_value")
    private double transferValue;

    @Column(name = "tax")
    private double tax;

    @Column(name = "transfer_date")
    private LocalDate transferDate;

    @Column(name = "scheduling")
    private LocalDateTime scheduling;

    public Transfer(){}

    public Transfer(Long id, String originAccount, String destinyAccount, double transferValue, double tax, LocalDate transferDate, LocalDateTime scheduling) {
        this.id = id;
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
        this.transferValue = transferValue;
        this.tax = tax;
        this.transferDate = transferDate;
        this.scheduling = scheduling;
    }

    public void setId(Long id) {
        this.id = id;
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
        Transfer transfer = (Transfer) o;
        return Double.compare(transferValue, transfer.transferValue) == 0 && Double.compare(tax, transfer.tax) == 0 && Objects.equals(id, transfer.id) && Objects.equals(originAccount, transfer.originAccount) && Objects.equals(destinyAccount, transfer.destinyAccount) && Objects.equals(transferDate, transfer.transferDate) && Objects.equals(scheduling, transfer.scheduling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originAccount, destinyAccount, transferValue, tax, transferDate, scheduling);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", originAccount='" + originAccount + '\'' +
                ", destinyAccount='" + destinyAccount + '\'' +
                ", TransferValue=" + transferValue +
                ", tax=" + tax +
                ", transferDate=" + transferDate +
                ", scheduling=" + scheduling +
                '}';
    }
}
