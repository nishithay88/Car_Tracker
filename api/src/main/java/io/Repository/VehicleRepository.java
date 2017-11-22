package io.Repository;


import io.Entity.Vehicle;

import java.util.ArrayList;
import java.util.List;


public interface VehicleRepository {
List<Vehicle> findAll();
    Vehicle findOne(String vin);
    ArrayList<Vehicle> create(ArrayList<Vehicle> veh);

}
