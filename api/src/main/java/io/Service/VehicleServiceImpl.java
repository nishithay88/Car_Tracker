package io.Service;


import io.Entity.Vehicle;
import io.Repository.VehicleRepository;
import io.exception.BadRequestException;
import io.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


    public List<Vehicle> findAll() {
return repository.findAll();
    }

    @Transactional
//Method to throw exception if requested vin does not exits
    public Vehicle findOne(String vin) {

       Vehicle exists=repository.findOne(vin);
       if(exists==null)
       {
           throw new ResourceNotFoundException("Vehicle with"+vin+"does not exists");
       }
       return exists;
    }

@Transactional
   public ArrayList<Vehicle> create(ArrayList<Vehicle> veh) {
    ArrayList<Vehicle> exist = repository.create(veh);
    if (exist.isEmpty()) {
        throw new BadRequestException("No data to display");
    }
return exist;
}

}

