package com.company.controller;

import com.company.dto.ActionDTO;
import com.company.dto.FactoryDTO;
import com.company.dto.ProfileDTO;
import com.company.service.FactoryService;
import com.company.service.ProfileService;
import com.company.type.ProfileRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private FactoryService factoryService;


    @GetMapping("/")
    public String getList(Model model) {
        List<ProfileDTO> profileDTOList = profileService.list();
        model.addAttribute("profileList", profileDTOList);
        return "profileList";
    }

    @PostMapping("/create-profile")
    public String create(@ModelAttribute ProfileDTO dto) {
        profileService.create(dto);
        return "redirect:/profile/";
    }
    @GetMapping("/add_profile")
    public String goToAddProfilePage(Model model) {

        model.addAttribute("roleList", ProfileRole.values());
        model.addAttribute("profile", new ProfileDTO());
        model.addAttribute("factoryList",factoryService.getAll());
        return "profile";
    }

    @GetMapping("/go-to-update/{id}")
    public String goToUpdate(@PathVariable("id") Long id, Model model){
        ProfileDTO dto = profileService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";

            model.addAttribute("profile", dto);
            model.addAttribute("factoryList", factoryService.getAll());
            model.addAttribute("roleList", ProfileRole.values());
            return "profile";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boolean b = profileService.delete(id);
        if (b){
            return "redirect:/profile/";
        } else return "notFound";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Long id,@ModelAttribute ProfileDTO dto){

        ActionDTO update = profileService.update(id, dto);

        if(update.getIsError()){
            return update.getError();
        }

        return "redirect:/profile/";
    }
}
