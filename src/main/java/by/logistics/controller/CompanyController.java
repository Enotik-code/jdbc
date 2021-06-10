package by.logistics.controller;

import by.logistics.bean.City;
import by.logistics.bean.Company;
import by.logistics.repository.CargoRepository;
import by.logistics.repository.CityRepository;
import by.logistics.repository.CompanyRepository;
import by.logistics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "/")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping(value = "list")
    public ModelAndView listPage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCompany", companyRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "addCompany")
    public ModelAndView addCompany(){
        ModelAndView modelAndView = new ModelAndView("addCompany");
        modelAndView.addObject("cityList", cityRepository.findAll());
        modelAndView.addObject("statusList", statusRepository.findAll());
        modelAndView.addObject("cargoList", cargoRepository.findAll());
        return modelAndView;
    }


    @PostMapping(value = "addCompany")
    public ModelAndView addCompanyPost(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "cargo", required = false) String cargo,
                                       @RequestParam(value = "status", required = false) String status,
                                       @RequestParam(value = "city", required = false) String city){
        ModelAndView modelAndView = new ModelAndView("addCompany");
        Company company = Company.builder()
                .city(cityRepository.findByName(city))
                .name(name)
                .status(statusRepository.findByName(status))
                .cargo(cargoRepository.findByName(cargo))
                .build();
        companyRepository.save(company);
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }

    @GetMapping(value = "delete" + "/{id}")
    public ModelAndView deleteCompany(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        companyRepository.deleteCompanyById(id);
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }

    @GetMapping(value = "searchName")
    public ModelAndView searchName(@ModelAttribute(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCompany", companyRepository.searchCompanyByName(name));
        return modelAndView;
    }

    @GetMapping(value = "searchId")
    public ModelAndView searchId(@ModelAttribute(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCompany", companyRepository.searchCompanyById(id));
        return modelAndView;
    }

    @GetMapping(value = "update" + "/{id}")
    public ModelAndView updateCompany(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("updateCompany");
        Company company = companyRepository.getById(id);
        modelAndView.addObject("myCompany", company);
        modelAndView.addObject("cityList", cityRepository.findAll());
        modelAndView.addObject("statusList", statusRepository.findAll());
        modelAndView.addObject("cargoList", cargoRepository.findAll());
        return modelAndView;
    }


    @PostMapping(value = "/update" + "/{id}")
    public ModelAndView addCompanyPagePost(@PathVariable(name = "id") int id,
                                           @RequestParam(value = "name", required = false) String name,
                                           @RequestParam(value = "city", required = false) String city,
                                           @RequestParam(value = "cargo", required = false) String cargo,
                                           @RequestParam(value = "status", required = false) String status) {
        ModelAndView modelAndView = new ModelAndView("/updateCompany");
        companyRepository.setNewData(id, cargoRepository.findByName(cargo), cityRepository.findByName(city), statusRepository.findByName(status), name);
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }
}
