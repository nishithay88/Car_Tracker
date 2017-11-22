package io.Service;

import io.Entity.Readings;
import io.Repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ReadingServiceImpl implements ReadingService{
    @Autowired
    ReadingsRepository repository;



    @Transactional
    public Readings createReadings(Readings readings) {

        return repository.createReadings(readings);
    }


}
