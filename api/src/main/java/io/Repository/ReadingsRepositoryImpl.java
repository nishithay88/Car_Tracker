package io.Repository;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Tires;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Readings createReadings(Readings readings) {

            entityManager.persist(readings);

        return readings;
    }


}
