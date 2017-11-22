package io.Controller;

import io.Entity.Vehicle;
import io.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService service;

@CrossOrigin
    @RequestMapping(method = RequestMethod.GET,path="/allvehicles")
    public List<Vehicle> findAll(){
        return service.findAll();
    }

@CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "vehicles/{vin}")
    public Vehicle findOne(@PathVariable("vin") String vin){
        return service.findOne(vin);
    }

@CrossOrigin  // enabling cross-domain data transfers from mocker
    @RequestMapping(method = RequestMethod.PUT,path = "/vehicles")
    public ArrayList<Vehicle> create(@RequestBody ArrayList<Vehicle> veh){
        return service.create(veh);
    }


}
