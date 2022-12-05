package carDealer.domain.dtos.customers;

import carDealer.domain.entities.Sale;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AllCustomersByBirthdateDTO implements Serializable {
    private Long Id;
    private String Name;
    private LocalDateTime BirthDate;
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;
    private List<Sale> Sales;

    public AllCustomersByBirthdateDTO() {
        Sales = new ArrayList<>();
    }

    public AllCustomersByBirthdateDTO(Long id, String name, LocalDateTime birthDate, boolean isYoungDriver) {
        this();
        Id = id;
        Name = name;
        BirthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
    }
}
