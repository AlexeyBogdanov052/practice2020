package project.controllers;

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
public class UpdateController {
    @Autowired
    private ListRep listRep;
    @Autowired
    private TaskRep taskRep;

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

    @GetMapping(value = {"/task/{taskId}/update"})
    public String upTaskForm(Model model, @PathVariable long taskId) {
        TaskEntity task = taskRep.findById(taskId);

        model.addAttribute("task", task);

        return "/updateTask";
    }

    @RequestMapping(value = {"/task/{taskId}/update"}, method = {RequestMethod.POST})
    public String upTaskSubmit(Model model, @PathVariable long taskId,
                               @ModelAttribute("task") TaskEntity task) {
        TaskEntity taskToUpdate = taskRep.findById(taskId);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDiscription(task.getDiscription());
        taskToUpdate.setDone(task.getDone());
        taskRep.save(taskToUpdate);

        Long id = taskToUpdate.getParent();

        return "redirect:/list/" + id;
    }

}
