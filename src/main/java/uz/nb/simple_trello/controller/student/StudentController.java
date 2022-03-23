package uz.nb.simple_trello.controller.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.dto.StudentCreateDto;
import uz.nb.simple_trello.dto.StudentUpdateDto;
import uz.nb.simple_trello.services.StudentService;

@Controller
@RequestMapping("/student/*")
@RequiredArgsConstructor
public class StudentController {

    private  final StudentService service;


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "student/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute StudentCreateDto dto) {
        service.create(dto);
        return "redirect:list";
    }



    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("student", service.get(id));
        return "student/list";
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("students", service.getAll());
        return "student/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("studentUpdate", service.get(id));
        return "student/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute StudentUpdateDto student) {
        service.update(student);
        return "redirect:/student/list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable Long id) {
        model.addAttribute("studentId", service.get(id));
        return "student/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete( @PathVariable Long id) {
        service.delete(id);
        return "redirect:/student/list";
    }
}
