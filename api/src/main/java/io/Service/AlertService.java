package io.Service;


import com.sun.org.apache.bcel.internal.generic.LUSHR;
import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface AlertService {

    List<Alerts> createAlert();
    Collection<Alerts> alertCount();
    List<Alerts> geolocation();
List<Alerts> vehicleLocation();
    List<Alerts> vehicleplot();
}
