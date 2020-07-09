package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import project.dao.ListRep;
import project.domain.ListEntity;


@Controller
public class UpdateController {
    @Autowired
    private ListRep listRep;

    @GetMapping(value = {"/list/{id}/update"})
    public String upListForm(Model model, @PathVariable long id) {
        ListEntity list = listRep.findById(id);

        model.addAttribute("list", list);

        return "/update";
    }

    @RequestMapping(value = {"/list/{id}/update"}, method = {RequestMethod.POST})
    public String upListSubmit(Model model, @PathVariable long id,
                                    @ModelAttribute("list") ListEntity list) {
        ListEntity listToUpdate = listRep.findById(id);
        listToUpdate.setName(list.getName());
        listRep.save(listToUpdate);

        return "redirect:/list/" + id;
    }


}
