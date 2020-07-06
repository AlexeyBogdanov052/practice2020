package project.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import project.dao.ListRep;
import project.dao.TaskRep;
import project.domain.ListEntity;
import project.domain.TaskEntity;

@Controller
public class IndexController {
    @Autowired
    private ListRep listRep;
    @Autowired
    private TaskRep taskRep;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, ListEntity> lists = getLists();
        Iterable<TaskEntity> tasks = taskRep.findAll();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @RequestMapping(value = {"/list/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long id){
        Map<Long, ListEntity> lists = getLists();
        List<TaskEntity> tasks = taskRep.findByParent(id);

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(id));
        model.addAttribute("tasks", tasks);

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

    @RequestMapping(value = {"/list/{id}/delete"})
    public String removeList(@PathVariable Long id) {
        listRep.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping(value={"/list/task"}, method=RequestMethod.POST)
    public String addTask(@ModelAttribute TaskEntity task, Model model) {
        taskRep.save(new TaskEntity(task.getParentId(), task.getTitle()));

        return "redirect:/list" + task.getParentId();
    }
}