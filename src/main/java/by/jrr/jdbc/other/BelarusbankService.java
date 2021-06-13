package by.jrr.jdbc.other;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BelarusbankService {

    @Autowired
    BelarusbankApi belarusbankApi;

    public void getKursInCity(String name){
        System.out.println(belarusbankApi.findByCity(name));
    }
}
