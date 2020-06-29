package project.view;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.dao.ListRep;
import project.domain.ListEntity;
import project.domain.TaskEntity;

@Controller
public class IndexView {
    @Autowired
    private ListRep listRep;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, ListEntity> lists = getLists();

        model.addAttribute("Lists", lists.values());
        model.addAttribute("currentList", lists.get(null));

        return "index";
    }

    private Map<Long, ListEntity> getLists(){
        Map<Long, ListEntity> result = new HashMap<>();
        Iterable<ListEntity> lists = listRep.findAll();

        result.put(null, new ListEntity("Все"));

        for (ListEntity entity: lists) {
            result.put(entity.getId(), entity);
        }
        return result;
    }
}