package io.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.mapping.UniqueKey;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "vehicle.findById", query = "select v from Vehicle v where v.vin=:paramVid"),
        @NamedQuery(name = "vehicle.all", query = "select v from Vehicle v")
} )

@Embeddable
public class Vehicle {

   @Id
   private String id;
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private  int maxFuelVolume;
    private  String lastServiceDate;

    @OneToMany(fetch = FetchType.EAGER) //creating one to many relationship since each vehicle can have multiple readings
@JsonIgnore
    private Collection<Readings> readings=new ArrayList<Readings>();

    public Vehicle(){
        this.id=UUID.randomUUID().toString();
    }


    public Collection<Readings> getReadings() {
        return readings;
    }

    public String getVin() {
        return vin;
    }

    public void setVid(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }

    public void setRedlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Integer maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }


}
