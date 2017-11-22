package io.Service;


import io.Entity.Vehicle;

import java.util.ArrayList;
import java.util.List;


public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    ArrayList<Vehicle> create(ArrayList<Vehicle> veh);
}
