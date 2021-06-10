package by.logistics.controller;

import by.logistics.bean.City;
import by.logistics.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Access;

@Controller
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "/addCity")
    public ModelAndView addCity(){
        ModelAndView modelAndView = new ModelAndView("addcity");
        return modelAndView;
    }

    @PostMapping(value = "/addCity")
    public ModelAndView addCityPost(@RequestParam(value = "name") String name){
        ModelAndView modelAndView = new ModelAndView("addcity");
        cityRepository.save(new City(name));
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }
}
