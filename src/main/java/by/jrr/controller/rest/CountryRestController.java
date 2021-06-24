package by.jrr.controller.rest;

import by.jrr.api.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestController {

    @Autowired
    private DataService dataService;

    @GetMapping("api/country/{name}")
    public ResponseEntity getCountryByName(@PathVariable String name){
        return ResponseEntity.ok(dataService.getCountryByName(name));
    }

    @GetMapping("api/countries")
    public ResponseEntity getAllCountries(){
        return ResponseEntity.ok(dataService.getAllCountries());
    }
}
