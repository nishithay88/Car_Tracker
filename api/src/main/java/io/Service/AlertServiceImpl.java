package io.Service;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Vehicle;
import io.Repository.AlertRepository;
import io.exception.BadRequestException;
import javafx.scene.layout.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {
@Autowired
private AlertRepository repository;


    public List<Alerts> createAlert() {
        List<Alerts> exisiting = repository.createAlert();
        if (exisiting.isEmpty()) {
            throw new BadRequestException("No readings to display");
        }
        return exisiting;
    }
    public Collection<Alerts> alertCount() {
        Collection<Alerts> exisiting = repository.alertCount();
        if (exisiting.isEmpty()) {
            throw new BadRequestException("No alerts to display");
        }
        return exisiting;
    }

    public List<Alerts> geolocation() {
        List<Alerts> exisiting = repository.geolocation();
        if (exisiting.isEmpty()) {
            throw new BadRequestException("No alerts to map");
        }
        return exisiting;
    }

    public List<Alerts> vehicleLocation() {
        List<Alerts> exisiting = repository.vehicleLocation();
        if (exisiting.isEmpty()) {
            throw new BadRequestException("No vehicles available to map");
        }
        return exisiting;
    }

    public List<Alerts> vehicleplot() {
        List<Alerts> exisiting = repository.vehicleplot();
        if (exisiting.isEmpty()) {
            throw new BadRequestException("No vehicles available to plot");
        }
        return exisiting;
    }
}
