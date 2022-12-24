package com.RestaurantCatalog.dto.in;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantInDto {
    private  Integer id;
    @NotBlank(message = "пустое имя")
    private String name;
    @NotBlank(message = "нет адреса")
    private String address;
    @NotBlank(message = "нет описания")
    private String description;
    @NotBlank(message = "нет номера телефона")
    private String telephoneNumber;
    @NotBlank(message = "нет почты")
    @Email(message = "неверный формат телефона")
    private String email;
    @Past(message = "будущее")
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate foundationDate;
}
