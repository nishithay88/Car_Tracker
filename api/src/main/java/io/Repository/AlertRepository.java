package io.Repository;

import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nishitha_Yedla on 28-06-2017.
 */
public interface AlertRepository {

    List<Alerts> createAlert();
    Collection<Alerts> alertCount();
    List<Alerts> geolocation();
List<Alerts> vehicleLocation();
    List<Alerts> vehicleplot();
}
