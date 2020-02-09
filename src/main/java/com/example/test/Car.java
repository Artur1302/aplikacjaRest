package com.example.test;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Car.
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "engine")
    private String engine;

    @Column(name = "serial_no")
    private String serialNo;

    @ManyToMany
    @JoinTable(name = "car_driver",
               joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    private Set<Driver> drivers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public Car model(String model) {
        this.model = model;
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public Car engine(String engine) {
        this.engine = engine;
        return this;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public Car serialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Car drivers(Set<Driver> drivers) {
        this.drivers = drivers;
        return this;
    }

    public Car addDriver(Driver driver) {
        this.drivers.add(driver);
        driver.getCars().add(this);
        return this;
    }

    public Car removeDriver(Driver driver) {
        this.drivers.remove(driver);
        driver.getCars().remove(this);
        return this;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        return id != null && id.equals(((Car) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id=" + getId() +
            ", model='" + getModel() + "'" +
            ", engine='" + getEngine() + "'" +
            ", serialNo='" + getSerialNo() + "'" +
            "}";
    }
}
