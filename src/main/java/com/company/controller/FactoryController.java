package com.company.controller;

import com.company.dto.ActionDTO;
import com.company.dto.FactoryDTO;
import com.company.entity.FactoryEntity;
import com.company.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    /**
     * GO TO PAGE
     */

    @RequestMapping("/")
    public String goToPage(Model model) {

        List<FactoryDTO> list = factoryService.getAll();

        if (!list.isEmpty()) {
            model.addAttribute("factoryList", list);
        }

        return "factoryList";
    }


    @RequestMapping("/go-add")
    public String goAdd(Model model) {

        model.addAttribute("factory", new FactoryDTO());

        return "factory_add";
    }

    @RequestMapping("/go-update/{id}")
    public String goUpdate(@PathVariable("id") Long id, Model model) {

        FactoryDTO factoryDTO = factoryService.get(id);

        if (Optional.ofNullable(factoryDTO).isEmpty()) {
            model.addAttribute("factory", new FactoryDTO());
            return "factory_add";
        }

        model.addAttribute("factory", factoryDTO);

        return "factory_add";
    }

    /**
     * BUSINESS LOGIC
     */

    @RequestMapping("/add")
    public String add(@ModelAttribute FactoryDTO dto) {

        factoryService.create(dto);

        return "redirect:/factory/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        ActionDTO delete = factoryService.delete(id);

        if (delete.getIsError()) {
            return delete.getError();
        }

        return "redirect:/factory/";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Long id,@ModelAttribute FactoryDTO dto){

        ActionDTO update = factoryService.update(id, dto);

        if(update.getIsError()){
            return update.getError();
        }

        return "redirect:/factory/";
    }
}
