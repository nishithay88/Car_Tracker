package io.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries(
        @NamedQuery(name = "Readings.findById",query = "select r from Readings r where r.vin=:paramVid")
)
public class Readings {

    @Id
    private String R_id;
    private String vin;
    private double latitude;
    private double longitude;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss.sssXXX")
    private Timestamp timestamp;
    private int fuelVolume;
    private String speed;
    private String engineHp;
    private String checkEngineLightOn;
    private String engineCoolantLow;
    private String cruiseControlOn;
    private int engineRpm;
    @Embedded
    private Tires tires;   //embedding tires class
    private String  priority;

   @OneToMany
    private List<Alerts> alert;

    public Readings(){
        this.R_id= UUID.randomUUID().toString();
    }


    public String getR_id() {
        return R_id;
    }

    public void setR_id(String r_id) {
        R_id = r_id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(String engineHp) {
        this.engineHp = engineHp;
    }

    public String getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(String checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public String getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(String engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public String getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(String cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public List<Alerts> getAlert() {
        return alert;
    }

    public void setAlert(List<Alerts> alert) {
        this.alert = alert;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Readings{" +
                "R_id='" + R_id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed='" + speed + '\'' +
                ", engineHp='" + engineHp + '\'' +
                ", checkEngineLightOn='" + checkEngineLightOn + '\'' +
                ", engineCoolantLow='" + engineCoolantLow + '\'' +
                ", cruiseControlOn='" + cruiseControlOn + '\'' +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                ", priority='" + priority + '\'' +
                ", alert=" + alert +
                '}';
    }
}

