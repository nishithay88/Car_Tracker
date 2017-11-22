package io.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Tires;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertRepository{

    @PersistenceContext
    EntityManager emf;
    @Transactional
    public List<Alerts> createAlert() {
       TypedQuery<Object[]> query = emf.createNamedQuery("createAlert",Object[].class);
       List<Object[]> resultList = query.getResultList();
        List<Alerts> list=new ArrayList<Alerts>();

        Iterator i=resultList.iterator();


        while (i.hasNext()) {
            Object[] o = (Object[]) i.next();
            Alerts alert = new Alerts();
            alert.setRedlineRpm((Integer) o[0]);
            alert.setEngineRpm((Integer) o[1]);
            alert.setMaxFuelVolume((Integer) o[2]);
            alert.setFuelVolume((Integer) o[3]);
            alert.setTires((Tires) o[4]);
            alert.setCheckEngineLightOn((String) o[5]);
            alert.setEngineCoolantLow((String) o[6]);
            alert.setVin((String) o[7]);
            alert.setTimestamp((Timestamp) o[8]);
            alert.setLatitude((Double) o[9]);
            alert.setLongitude((Double) o[10]);
            list.add(alert);

            if (alert.getEngineRpm() > alert.getRedlineRpm())
                alert.setPriority("HIGH");

             if(alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume()))
                alert.setPriority("MEDIUM");
             if(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36)
            alert.setPriority("LOW");
             if(alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true))
            alert.setPriority("LOW");
             if ((alert.getEngineRpm() > alert.getRedlineRpm())&&(alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume())))
            alert.setPriority("HIGH,MEDIUM");
             if ((alert.getEngineRpm() > alert.getRedlineRpm())&&(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36))
            alert.setPriority("HIGH,LOW");
             if ((alert.getEngineRpm() > alert.getRedlineRpm())&& (alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true)))
            alert.setPriority("HIGH,LOW");
             if ((alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume()))&&(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36))
            alert.setPriority("MEDIUM,LOW");
             if ((alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume()))&&(alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true)))
            alert.setPriority("MEDIUM,LOW");
             if((alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36)&&(alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true)))
            alert.setPriority("LOW,LOW");
             if(((alert.getEngineRpm() > alert.getRedlineRpm())&&(alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume())))&&(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36))
                 alert.setPriority("HIGH,MEDIUM,LOW");
            if(((alert.getEngineRpm() > alert.getRedlineRpm())&&(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36)&&(alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true))))
            alert.setPriority("HIGH,LOW,LOW");
            if((alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume()))&&(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36)&&(alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true)))
               alert.setPriority("MEDIUM,LOW,LOW");
            if((alert.getEngineRpm() > alert.getRedlineRpm())&&(alert.getFuelVolume() < (0.1 * alert.getMaxFuelVolume()))&&(alert.getTires().getFrontLeft() < 32 || alert.getTires().getFrontLeft() > 36 || alert.getTires().getFrontRight() < 32 || alert.getTires().getFrontRight() > 36 || alert.getTires().getRearLeft() < 32 || alert.getTires().getRearLeft() > 36 || alert.getTires().getRearRight() < 32 || alert.getTires().getRearRight() > 36)&&(alert.getEngineCoolantLow().equals(true) || alert.getCheckEngineLightOn().equals(true)))
                alert.setPriority("HIGH,MEDIUM,LOW,LOW");
                emf.persist(alert);
        }
    return list;

    }

    public Collection<Alerts> alertCount() {
        List<Alert> query=new ArrayList<Alert>();
        query= emf.createNativeQuery("select vin,count(Priority),timestamp from alerts where timestamp> current_timestamp-interval 5 hour and Priority like 'HIGH%' group by vin").getResultList();

        List<Alerts> alerts=new ArrayList<Alerts>();
        Iterator i=query.iterator();

        while (i.hasNext()){
            Object[] o=(Object[]) i.next();

            Alerts a=new Alerts(){
                @JsonIgnore
                @Override
                public void setAlertId(int alertId) {
                    super.setAlertId(alertId);
                }

                @JsonIgnore
                @Override
                public void setPriority(String priority) {
                    super.setPriority(priority);
                }

                @JsonIgnore
                @Override
                public void setEngineRpm(int engineRpm) {
                    super.setEngineRpm(engineRpm);
                }

                @JsonIgnore
                @Override
                public void setRedlineRpm(int redlineRpm) {
                    super.setRedlineRpm(redlineRpm);
                }

                @JsonIgnore
                @Override
                public void setMaxFuelVolume(int maxFuelVolume) {
                    super.setMaxFuelVolume(maxFuelVolume);
                }

                @JsonIgnore
                @Override
                public void setFuelVolume(int fuelVolume) {
                    super.setFuelVolume(fuelVolume);
                }

                @JsonIgnore
                @Override
                public void setCheckEngineLightOn(String checkEngineLightOn) {
                    super.setCheckEngineLightOn(checkEngineLightOn);
                }

                @JsonIgnore
                @Override
                public void setEngineCoolantLow(String engineCoolantLow) {
                    super.setEngineCoolantLow(engineCoolantLow);
                }

                @JsonIgnore
                @Override
                public void setTires(Tires tires) {
                    super.setTires(tires);
                }

                @JsonIgnore
                @Override
                public void setTimestamp(Timestamp timestamp) {
                    super.setTimestamp(timestamp);
                }

                @JsonIgnore
                @Override
                public void setLatitude(double latitude) {
                    super.setLatitude(latitude);
                }

                @JsonIgnore
                @Override
                public void setLongitude(double longitude) {
                    super.setLongitude(longitude);
                }
            };

            a.setVin((String) o[0]);
            a.setCount( Integer.parseInt((String.valueOf(o[1]))));
            a.setTimestamp((Timestamp) o[2]);
            alerts.add(a);

        }


        return alerts;
    }

    @Transactional
    public List<Alerts> geolocation() {

        List<Readings> query=new ArrayList<Readings>();
        query= emf.createNativeQuery("select r.vin,r.latitude,r.longitude,r.timestamp,a.priority from Readings r,Alerts a where r.timestamp> current_timestamp-interval 30 MINUTE ").getResultList();
        List<Object[]> resultList=new ArrayList<Object[]>();

        List<Alerts> list=new ArrayList<Alerts>();

        Iterator i=query.iterator();

        while (i.hasNext()){
            Object[] o=(Object[]) i.next();

            Alerts alerts=new Alerts(){

                @JsonIgnore
                @Override
                public void setCount(int count) {
                    super.setCount(count);
                }

                @JsonIgnore
                @Override
                public void setAlertId(int alertId) {
                    super.setAlertId(alertId);
                }



                @JsonIgnore
                @Override
                public void setEngineRpm(int engineRpm) {
                    super.setEngineRpm(engineRpm);
                }

                @JsonIgnore
                @Override
                public void setRedlineRpm(int redlineRpm) {
                    super.setRedlineRpm(redlineRpm);
                }

                @JsonIgnore
                @Override
                public void setMaxFuelVolume(int maxFuelVolume) {
                    super.setMaxFuelVolume(maxFuelVolume);
                }

                @JsonIgnore
                @Override
                public void setFuelVolume(int fuelVolume) {
                    super.setFuelVolume(fuelVolume);
                }

               @JsonIgnore
               @Override
                public void setCheckEngineLightOn(String checkEngineLightOn) {
                    super.setCheckEngineLightOn(checkEngineLightOn);
                }

               @JsonIgnore
               @Override
                public void setEngineCoolantLow(String engineCoolantLow) {
                    super.setEngineCoolantLow(engineCoolantLow);
                }

                @JsonIgnore
                @Override
                public void setTires(Tires tires) {
                    super.setTires(tires);
                }
            };
            alerts.setVin((String) o[0]);
            alerts.setLatitude(Double.parseDouble(String.valueOf(o[1])));
            alerts.setLongitude(Double.parseDouble(String.valueOf(o[2])));
            alerts.setTimestamp((Timestamp) o[3]);
            alerts.setPriority((String) o[4]);
            list.add(alerts);

        }

        return list;
    }
    @Transactional
    public List<Alerts> vehicleLocation() {
        List<Alerts> query=new ArrayList<Alerts>();
        query=emf.createNativeQuery("SELECT vin,latitude,longitude,timestamp from alerts where timestamp>(current_timestamp()-interval 30 MINUTE )").getResultList();
        List<Alerts> list=new ArrayList<Alerts>();
        Iterator i=query.iterator();
        while (i.hasNext()){
           Object[] o= (Object[]) i.next();
            Alerts alerts=new Alerts(){

                @JsonIgnore
                @Override
                public void setCount(int count) {
                    super.setCount(count);
                }

                @JsonIgnore
                @Override
                public void setAlertId(int alertId) {
                    super.setAlertId(alertId);
                }

                @JsonIgnore
                @Override
                public void setPriority(String priority) {
                    super.setPriority(priority);
                }

                @JsonIgnore
                @Override
                public void setFuelVolume(int fuelVolume) {
                    super.setFuelVolume(fuelVolume);
                }
                @JsonIgnore
                @Override
                public void setEngineRpm(int engineRpm) {
                    super.setEngineRpm(engineRpm);
                }

                @JsonIgnore
                @Override
                public void setRedlineRpm(int redlineRpm) {
                    super.setRedlineRpm(redlineRpm);
                }

                @JsonIgnore
                @Override
                public void setMaxFuelVolume(int maxFuelVolume) {
                    super.setMaxFuelVolume(maxFuelVolume);
                }

                @JsonIgnore
                @Override
                public void setCheckEngineLightOn(String checkEngineLightOn) {
                    super.setCheckEngineLightOn(checkEngineLightOn);
                }

                @JsonIgnore
                @Override
                public void setEngineCoolantLow(String engineCoolantLow) {
                    super.setEngineCoolantLow(engineCoolantLow);
                }

                @JsonIgnore
                @Override
                public void setTires(Tires tires) {
                    super.setTires(tires);
                }
            };
            alerts.setVin((String) o[0]);
            alerts.setLatitude((Double) o[1]);
            alerts.setLongitude((Double) o[2]);
            alerts.setTimestamp((Timestamp) o[3]);
            list.add(alerts);
        }

        return list;
    }

    public List<Alerts> vehicleplot() {
        List<Alerts> query=new ArrayList<Alerts>();

        query=emf.createNativeQuery("SELECT vin,fuelVolume,engineRpm,timestamp from alerts").getResultList();
        List<Alerts> list=new ArrayList<Alerts>();
        Iterator itr=query.iterator();
        while (itr.hasNext()){
            Object[] obj= (Object[]) itr.next();
            Alerts a=new Alerts(){

                @JsonIgnore
                @Override
                public void setCount(int count) {
                    super.setCount(count);
                }

                @JsonIgnore
                @Override
                public void setAlertId(int alertId) {
                    super.setAlertId(alertId);
                }

                @JsonIgnore
                @Override
                public void setPriority(String priority) {
                    super.setPriority(priority);
                }

                @JsonIgnore
                @Override
                public void setLatitude(double latitude) {
                    super.setLatitude(latitude);
                }

                @JsonIgnore
                @Override
                public void setLongitude(double longitude) {
                    super.setLongitude(longitude);
                }

                @JsonIgnore
                @Override
                public void setRedlineRpm(int redlineRpm) {
                    super.setRedlineRpm(redlineRpm);
                }

                @JsonIgnore
                @Override
                public void setMaxFuelVolume(int maxFuelVolume) {
                    super.setMaxFuelVolume(maxFuelVolume);
                }

                @JsonIgnore
                @Override
                public void setCheckEngineLightOn(String checkEngineLightOn) {
                    super.setCheckEngineLightOn(checkEngineLightOn);
                }

                @JsonIgnore
                @Override
                public void setEngineCoolantLow(String engineCoolantLow) {
                    super.setEngineCoolantLow(engineCoolantLow);
                }

                @JsonIgnore
                @Override
                public void setTires(Tires tires) {
                    super.setTires(tires);
                }
            };
            a.setVin((String) obj[0]);
            a.setFuelVolume((Integer) obj[1]);
            a.setEngineRpm((Integer) obj[2]);
            a.setTimestamp((Timestamp) obj[3]);
            list.add(a);
        }

        return list;
    }
}

