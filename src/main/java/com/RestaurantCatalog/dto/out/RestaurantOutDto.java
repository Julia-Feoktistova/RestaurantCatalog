package com.RestaurantCatalog.dto.out;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class RestaurantOutDto {
    private final Long id;
    private final String name;
    private final String address;
    private final String description;
    private final String telephoneNumber;
    private final String email;
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private final LocalDate foundationDate;

}
