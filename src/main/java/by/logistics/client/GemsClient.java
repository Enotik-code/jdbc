package by.logistics.client;

import by.logistics.bean.api.Gems;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "GEMS-SERVICE", url = "https://belarusbank.by/api/getgems?city=Витебск")
public interface GemsClient {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<Gems> getAllUsers();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    Gems getUser(@PathVariable("id") int id);
}
