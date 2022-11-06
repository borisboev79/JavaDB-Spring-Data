package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bank account")
public class BankAccount extends BillingDetail {
    private static final String type = "BANK ACCOUNT";

    @Column
    private String name;

    @Column
    private String swiftCode;

    public BankAccount() {
        super(type);
    }

    public BankAccount(String name, String swiftCode) {
        super(type);
        this.name = name;
        this.swiftCode = swiftCode;
    }

    public BankAccount(String type, String name, String swiftCode) {
        super(type);
        this.name = name;
        this.swiftCode = swiftCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
