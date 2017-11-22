package io.Controller;

import com.sun.org.apache.regexp.internal.RE;
import io.Entity.Alerts;
import io.Entity.Readings;
import io.Entity.Vehicle;
import io.Service.ReadingService;
import io.Service.ReadingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReadingsController {

    @Autowired
    ReadingService service;


    @CrossOrigin // enabling cross-domain data transfers from mocker
    @RequestMapping(method = RequestMethod.POST,value = "/readings")
    public Readings createReadings(@RequestBody Readings readings){
        return service.createReadings(readings);
    }



}
