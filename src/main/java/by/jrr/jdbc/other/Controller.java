package by.jrr.jdbc.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private BelarusbankService belarusbankService;

    @GetMapping(value = "/")
    public void getKusr(){
        belarusbankService.getKursInCity("Минск");
    }
}
