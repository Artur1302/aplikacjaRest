package com.example.test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Driver.
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mileage")
    private Integer mileage;

    @ManyToMany(mappedBy = "drivers")
    @JsonIgnore
    private Set<Car> cars = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Driver name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public Driver lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Driver mileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Driver cars(Set<Car> cars) {
        this.cars = cars;
        return this;
    }

    public Driver addCar(Car car) {
        this.cars.add(car);
        car.getDrivers().add(this);
        return this;
    }

    public Driver removeCar(Car car) {
        this.cars.remove(car);
        car.getDrivers().remove(this);
        return this;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Driver)) {
            return false;
        }
        return id != null && id.equals(((Driver) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Driver{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", mileage=" + getMileage() +
            "}";
    }
}
