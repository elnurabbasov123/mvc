package com.example.mvc.service;
import com.example.mvc.model.Sector;
import com.example.mvc.model.Student;
import com.example.mvc.repository.StudentRepository;
import com.example.mvc.repository.StudentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRepositoryJPA studentRepositoryJPA;


    private List<Student> studentList=new ArrayList<>();
    {
        studentList.add(new Student(1,"Cavid","Huseynov"));
        studentList.add(new Student(2,"Alim","Qasimov"));
        studentList.add(new Student(3,"Azer","Zeynalov"));
        studentList.add(new Student(4,"Mixail","Velizade"));
        studentList.add(new Student(5,"Azer","Basiyev"));
        studentList.add(new Student(6,"Alim","Ceferov"));
    }

    public void addStudent(Student student){
//        studentList.add(student);  add student to list
//        studentRepository.addStudentDb(student); // add student to db
        studentRepositoryJPA.save(student);
     }

    public List<Student> findAll(){
//        return studentRepository.findAll();
        List<Student> list=studentRepositoryJPA.findAll();
        for (Student st:list
             ) {
            if(st.getSector()==null){
                st.setSector(new Sector());
            }
        }
        return list;
    }

    public boolean deleteById(Integer id) {
//        studentRepository.deleteById(id);
     boolean studentExtists= studentRepositoryJPA.findById(id).isPresent();
     if(studentExtists){
         studentRepositoryJPA.deleteById(id);
         return true;
     }else{
         return false;
     }
    }

    public Student findById(Integer id){
//        return studentRepository.finById(id);
        return studentRepositoryJPA.findById(id).get();
    }

    public void editStudent(Student student) {
//        studentRepository.editStudent(student);
        studentRepositoryJPA.save(student);
    }
    public List<Student> findAllSearch(String surname){
//       return studentRepository.findAllSearch(name);
//        return studentRepositoryJPA.findAllByName(name);
        return studentRepositoryJPA.searchStudentsBySurname(surname);
    }
}
