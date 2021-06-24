package by.jrr.api.service;

import by.jrr.api.bean.Country;
import by.jrr.api.client.DataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataClient dataClient;

    public List<Country> getAllCountries() {
        return dataClient.getAllCountry();
    }

    public Country getCountryByName(String name){
        return dataClient.getAllCountry().stream()
                .filter(country -> country.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
