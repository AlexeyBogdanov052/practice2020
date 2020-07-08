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
    public String getIndex(Model model, @PathVariable Long id){
        Map<Long, ListEntity> lists = getLists();
        Map<Long, TaskEntity> tasks = getTasks(id);
        //List<TaskEntity> tasks = taskRep.findByParent(id);

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(id));
        model.addAttribute("tasks", tasks.values());

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

    private Map<Long, TaskEntity> getTasks(Long id){
        Map<Long, TaskEntity> result = new HashMap<>();
        Iterable<TaskEntity> tasks = taskRep.findAll();

        for (TaskEntity entity: tasks) {
            if (entity.getParentId() == id)
                result.put(entity.getId(), entity);
        }
        return result;
    }

    @RequestMapping(value = {"/list/{id}/delete"})
    public String removeList(@PathVariable Long id) {
        listRep.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/list/addtask", method = RequestMethod.GET)
    public String taskForm(Model model) {
        model.addAttribute("addtask", new TaskEntity());
        return "addtask";
    }

    @RequestMapping(value = {"/list/addtask"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute TaskEntity addtask, Model model){
        System.out.println(addtask.getParentId());
        System.out.println(addtask.getTitle());
        taskRep.save(new TaskEntity(addtask.getParentId(), addtask.getTitle()));
        return "redirect:/list";
    }
}