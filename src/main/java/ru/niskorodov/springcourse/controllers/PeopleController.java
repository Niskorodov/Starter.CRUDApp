package ru.niskorodov.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.niskorodov.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDao;
    @Autowired
    public PeopleController(PersonDAO personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people",personDao.index());
        // Получим всех людей из DAO и передадим на отображение в представление
        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id));
         // Получим одного человека по id из DAO и передадим на отображение в представление
        return "/people/show";
    }
}
