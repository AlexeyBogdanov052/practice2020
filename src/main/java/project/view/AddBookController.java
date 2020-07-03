package project.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.dao.ListRep;
import project.domain.ListEntity;

@Controller
public class AddBookController {
    @Autowired
    private ListRep listRep;

    @RequestMapping(value={"/addlist"}, method=RequestMethod.GET)
    public String listForm(Model model) {
        model.addAttribute("addlist", new ListEntity());
        return "addlist";
    }

    @RequestMapping(value={"/addlist"}, method=RequestMethod.POST)
    public String listSubmit(@ModelAttribute ListEntity addlist, Model model) {
        if (StringUtils.hasText(addlist.getName())){
           listRep.save(new ListEntity(addlist.getName()));
        }    

        return "redirect:/";
    }

}
