package by.logistics.controller;

import by.logistics.bean.City;
import by.logistics.bean.Status;
import by.logistics.repository.CityRepository;
import by.logistics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(value = "/addStatus")
    public ModelAndView addStatus(){
        ModelAndView modelAndView = new ModelAndView("addStatus");
        return modelAndView;
    }

    @PostMapping(value = "/addStatus")
    public ModelAndView addCityPost(@RequestParam(value = "name") String name){
        ModelAndView modelAndView = new ModelAndView("addStatus");
        statusRepository.save(new Status(name));
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }
}
