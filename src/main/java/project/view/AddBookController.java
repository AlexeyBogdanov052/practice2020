package project.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.domain.ListEntity;

@Controller
public class AddBookController {

    @RequestMapping(value={"/addlist"}, method=RequestMethod.GET)
    public String listForm(Model model) {
        model.addAttribute("addlist", new ListEntity());
        return "addlist";
    }

    @RequestMapping(value={"/addlist"}, method=RequestMethod.POST)
    public String listSubmit(@ModelAttribute ListEntity addlist, Model model) {
        model.addAttribute("addlist", addlist);
        return "result";
    }
}
