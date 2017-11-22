package io.Controller;


import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Vehicle;
import io.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class AlertController {

    @Autowired
    AlertService service;

@CrossOrigin
@RequestMapping(method = RequestMethod.GET,value = "/alerts")
public List<Alerts> createAlert(){
return service.createAlert();
    }

@CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value="/alertcount")
    public Collection<Alerts> alertCount(){
    return service.alertCount();
    }

    @CrossOrigin
 @RequestMapping(method = RequestMethod.GET,value = "/alertlocation")
public List<Alerts> geolocation(){
        return service.geolocation();
}
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/vehiclelocation")
    public List<Alerts> vehicleLocation(){
        return service.vehicleLocation();
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/vehicleplot")
    public List<Alerts> fuelVolumeOver1Hour(){
        return service.vehicleplot();
    }
}



