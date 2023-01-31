package com.example.mvc.repository;
import com.example.mvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    DataSource dataSource;

    public void addStudentDb(Student student){
        try{
            Connection con= dataSource.getConnection();
            PreparedStatement statement=con
                    .prepareStatement("insert into  students(name,surname,student_class,birthday,email,course_code,phone) values(?,?,?,?,?,?,?);");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setInt(3,student.getStudentClass());
            statement.setDate(4,student.getBirthday());
            statement.setString(5,student.getEmail());
            statement.setString(6,student.getCourseCode());
            statement.setString(7,student.getPhone());

            statement.executeUpdate();

            statement.close();
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Student> findAll(){
        List<Student> studentList=new ArrayList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENTS");
            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                Student s=new Student(
                        rs.getInt("id"),rs.getString("name"),rs.getString("surname")
                ,rs.getInt("student_class"));
                s.setBirthday(rs.getDate("birthday"));
                s.setEmail(rs.getString("email"));
                s.setCourseCode(rs.getString("course_code"));
                s.setPhone(rs.getString("phone"));

                studentList.add(s);
            }
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return studentList;
    }

    public void deleteById(Integer id) {
        try{
            Connection con=dataSource.getConnection();
            PreparedStatement stmt=con.prepareStatement("delete from students where id=?");
            stmt.setInt(1,id);

            stmt.executeUpdate();
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Student finById(Integer id) {
        Student s=null;
        try{
            Connection con=dataSource.getConnection();
            PreparedStatement stmt=con.prepareStatement("Select * from students where id=?");
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();

            if(rs.next()){
                s=new Student(
                        rs.getInt("id"),rs.getString("name"),rs.getString("surname")
                        ,rs.getInt("student_class")
                );
                s.setBirthday(rs.getDate("birthday"));
                s.setEmail(rs.getString("email"));
                s.setCourseCode(rs.getString("course_code"));
                s.setPhone(rs.getString("phone"));
            }

            con.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return s;

    }

    public void editStudent(Student student) {
        try{
            Connection con= dataSource.getConnection();
            PreparedStatement statement=con
                    .prepareStatement("update  students set name=?,surname=?,student_class=?,birthday=?,email=?,course_code=?,phone=? where id=?;");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setInt(3,student.getStudentClass());
            statement.setDate(4,student.getBirthday());
            statement.setString(5,student.getEmail());
            statement.setString(6,student.getCourseCode());
            statement.setString(7,student.getPhone());

            statement.setInt(8,student.getId());


            statement.executeUpdate();

            statement.close();
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public List<Student> findAllSearch(String name){
        List<Student> studentList=new ArrayList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENTS where name=?");
            stmt.setString(1,name);
            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                Student s=new Student(
                        rs.getInt("id"),rs.getString("name"),rs.getString("surname")
                        ,rs.getInt("student_class"));
                s.setBirthday(rs.getDate("birthday"));
                s.setEmail(rs.getString("email"));
                s.setCourseCode(rs.getString("course_code"));
                s.setPhone(rs.getString("phone"));

                studentList.add(s);
            }
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return studentList;
    }
}
