package com.example.mvc.controller;

import com.example.mvc.model.Student;
import com.example.mvc.repository.LanguageRepositoryJPA;
import com.example.mvc.repository.SectoryRepositoryJPA;
import com.example.mvc.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SectoryRepositoryJPA sectoryRepository;

    @Autowired
    private LanguageRepositoryJPA languageRepository;


    @PreAuthorize(value = "hasAuthority('read:all:students')")
    @GetMapping(path = "/list")
    public String showStudents(Model model){
        model.addAttribute("students",studentService.findAll());
        return "students";
    }

    @GetMapping(path = "/param")
    public String showStudentsParam(Model model,
                                    @RequestParam(name = "student-name") String studentName,
                                    @RequestParam(name = "student-surname" ,required = false,defaultValue = "Abbasli")
                                                String studentSurname ){
        List<Student> studentList=studentService.findAll();
        List<Student> filteredList=new ArrayList<>();
        for (Student s : studentList) {
            if(s.getName().equals(studentName)){
                filteredList.add(s);
            }
        }
        model.addAttribute("students",filteredList);
        return "students";
    }

    @GetMapping(path = "/new")
    @PreAuthorize(value = "hasAuthority('open:new:student:page')")
    public String showAddStudent(Model model){
        Student s =new Student();
        s.setId(0);
        s.setName("Ayxan");
        s.setSurname("Abbasli");
        s.setBirthday(Date.valueOf(LocalDate.of(2000, Month.FEBRUARY,12)));
        s.setStudentClass(5);


        model.addAttribute("student",s);
        model.addAttribute("header","Telebe qeydiyati");
        model.addAttribute("sectors",sectoryRepository.findAll());
        model.addAttribute("languages",languageRepository.findAll());
        return "save-student";
    }


    @PostMapping(path = "/save")
    @PreAuthorize(value = "hasAuthority('save:student')")
    public String saveStudent(@Valid @ModelAttribute(name = "student") Student student, BindingResult result,Model model){
        if(result.hasErrors()){
            if(student.getId()==0){
                model.addAttribute("header","Telebe qeydiyati");
            }else{
                model.addAttribute("header","Telebe redaktesi");
            }
            return "save-student";
        }
        if(student.getId()==0){
            studentService.addStudent(student);
        }else if(student.getId()>0){
            studentService.editStudent(student);
        }

        return "redirect:/students/list";
    }

    @GetMapping(path = "/delete/{id}")
    @PreAuthorize(value = "hasAuthority('delete:student')")
    public String deleteById(@PathVariable(name = "id")Integer id,Model model){
        boolean res=studentService.deleteById(id);
        if(!res){
            model.addAttribute("errorMessage","Tələbə tapılmadı ! ID="+id);
            return "error";
        }

        return "redirect:/students/list";
    }

    @GetMapping(path = "/edit/{id}")
    @PreAuthorize(value = "hasAuthority('open:edit:student:page')")
    public String showEditStudent(@PathVariable(name = "id") Integer id,Model model){
        Student s =studentService.findById(id);

        model.addAttribute("student",s);
        model.addAttribute("header","Telebe redaktesi");
        model.addAttribute("sectors",sectoryRepository.findAll());
        model.addAttribute("languages",languageRepository.findAll());

        return "save-student";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor trimmer=new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,trimmer);
    }

    @GetMapping(path = "/list/search")
    @PreAuthorize(value = "hasAuthority('search:student')")
    public String searchStudents(@RequestParam(name = "studentName") String studentName, Model model){
        model.addAttribute("students",studentService.findAllSearch(studentName));
        return "students";
    }
}
