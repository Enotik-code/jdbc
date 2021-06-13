package by.jrr.jdbc.other;

import com.google.gson.JsonObject;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;

@FeignClient(name = "belarusbank", url = "https://belarusbank.by/api/")
public interface BelarusbankApi {

    @RequestLine("GET /kursExchange/{city}")
    JsonObject findByCity(@ModelAttribute("city") String city);

}
