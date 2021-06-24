package by.jrr.api.client;

import by.jrr.api.bean.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "DATA-CLIENT", url = "http://api.travelpayouts.com/data/ru/")
public interface DataClient {

    @RequestMapping(value = "countries.json", method = RequestMethod.GET)
    List<Country> getAllCountry();
}
