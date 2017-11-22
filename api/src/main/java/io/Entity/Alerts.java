package io.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;


@Entity
@NamedQueries(
        @NamedQuery(name = "createAlert", query = "select v.redlineRpm,r.engineRpm,v.maxFuelVolume,r.fuelVolume,r.tires,r.checkEngineLightOn,r.engineCoolantLow,v.vin,r.timestamp,r.latitude,r.longitude from Vehicle v,Readings r where v.vin=r.vin")

)
      public class Alerts{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int alertId;
    private String Priority;
    private int engineRpm;
    private int redlineRpm;
    private int maxFuelVolume;
    private int  fuelVolume;
    @Embedded
    private Tires tires;
    private String checkEngineLightOn;
    private String engineCoolantLow;
    private String vin;
    private int count;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T' HH:mm:ss.sssXXX")
    private Timestamp timestamp;
    private double latitude;
    private double longitude;





@Autowired
public Alerts(Vehicle veh){
veh.getRedlineRpm();
}

@Autowired
public Alerts(Readings readings){
readings.getEngineRpm();
}

public Alerts(){

}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
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

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "Alerts{" +
                "alertId=" + alertId +
                ", Priority='" + Priority + '\'' +
                ", engineRpm=" + engineRpm +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", fuelVolume=" + fuelVolume +
                ", tires=" + tires +
                ", checkEngineLightOn='" + checkEngineLightOn + '\'' +
                ", engineCoolantLow='" + engineCoolantLow + '\'' +
                ", vin='" + vin + '\'' +
                ", count=" + count +
                ", timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
