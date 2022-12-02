package com.example.RestaurantCatalog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "restaurant")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(description, that.description) && Objects.equals(telephoneNumber, that.telephoneNumber) && Objects.equals(email, that.email) && Objects.equals(foundationDate, that.foundationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, description, telephoneNumber, email, foundationDate);
    }

    @OneToMany(mappedBy = "id",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Review> reviews;

}
