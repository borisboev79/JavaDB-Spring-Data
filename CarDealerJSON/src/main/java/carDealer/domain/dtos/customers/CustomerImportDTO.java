package carDealer.domain.dtos.customers;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerImportDTO {

    private String name;

    private LocalDateTime birthDate;

    private boolean isYoungDriver;


}
