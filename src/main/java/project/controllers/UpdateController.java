package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.dao.ListRep;
import project.domain.ListEntity;

import java.util.Optional;

@Controller
public class UpdateController {
    @Autowired
    private ListRep listRep;

    @RequestMapping(value={"/list/{id}/update"}, method=RequestMethod.GET)
    public String uplistForm(Model model, @PathVariable long id) {
        ListEntity uplist = listRep.findById(id);

        model.addAttribute("uplist", uplist);
        return "uplist";
    }

    @RequestMapping(value={"/list/{id}/update"}, method=RequestMethod.POST)
    public String uplistSubmit(@ModelAttribute ListEntity uplist, Model model, @PathVariable Long id) {
        uplist.setId(id);
        uplist.setName(uplist.getName());
        System.out.println(uplist.getId());
        return "redirect:/";
    }

}
