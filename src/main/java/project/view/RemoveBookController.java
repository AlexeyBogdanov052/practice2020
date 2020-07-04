package project.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.dao.ListRep;

import javax.rmi.CORBA.Util;

@Controller
public class RemoveBookController {
    @Autowired
    private ListRep listRep;

//    @RequestMapping(value = {"/list/{id}/delete"}, method = RequestMethod.DELETE)
//    public String removeList(@PathVariable Long id) {
//        listRep.deleteById(id);
//        return "redirect:/list/1";
//    }
}
