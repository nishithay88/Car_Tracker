package io.Repository;

import io.Entity.Vehicle;
import io.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

   @PersistenceContext
    private EntityManager entityManager; //injecting entitymanager to access data resources


    @Transactional
    public List<Vehicle> findAll() {
      TypedQuery<Vehicle> query=entityManager.createNamedQuery("vehicle.all",Vehicle.class)  ;
      List<Vehicle> resultList=query.getResultList();
          return resultList;
    }

    @Transactional
    public Vehicle findOne(String vin) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("vehicle.findById",
                Vehicle.class);
        query.setParameter("paramVid", vin);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1){
            return resultList.get(0);
        }else {
            return null;
        }
    }

    @Transactional
    //Method to read vehicle data from mocker
    public ArrayList<Vehicle> create(ArrayList<Vehicle> veh)
    {
        for(Vehicle v: veh ) { //persisting each vehicle from arrayList into database
            entityManager.persist(v);
        }
        return veh;
    }


}
