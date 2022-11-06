package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.Month;
import java.time.Year;

@Entity
@DiscriminatorValue(value = "credit card")
public class CreditCard extends BillingDetail {
    private static final String type = "CREDIT CARD";

    @Column
    private String cardType;

    @Column
    private String cardNumber;

    @Column
    private Month expirationMonth;

    @Column
    private Year expirationYear;

    public CreditCard() {
        super(type);
    }

    public CreditCard(String cardType, String cardNumber, Month expirationMonth, Year expirationYear) {
        super(type);
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Month getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Month expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Year getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Year expirationYear) {
        this.expirationYear = expirationYear;
    }
}
