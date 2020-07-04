package project.view;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import project.dao.ListRep;
import project.domain.ListEntity;
import project.domain.TaskEntity;

@Controller
public class IndexController {
    @Autowired
    private ListRep listRep;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, ListEntity> lists = getLists();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));

        return "index";
    }

    @RequestMapping(value = {"/list/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long id){
        Map<Long, ListEntity> lists = getLists();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(id));

        return "index";
    }

    private Map<Long, ListEntity> getLists(){
        Map<Long, ListEntity> result = new HashMap<>();
        Iterable<ListEntity> lists = listRep.findAll();

        for (ListEntity entity: lists) {
            result.put(entity.getId(), entity);
        }
        return result;
    }

    @RequestMapping(value = {"/list/{id}/delete"})
    public String removeList(@PathVariable Long id) {
        listRep.deleteById(id);
        return "redirect:/list/1";
    }
}