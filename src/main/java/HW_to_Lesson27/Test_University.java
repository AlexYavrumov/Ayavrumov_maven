package HW_to_Lesson27;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test_University {

    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String pass = "T-114466";

    public static void main(String[] args) throws SQLException {

        List<Students> students = new ArrayList<>();

        readBD(students);
        System.out.println(students);

        // Task 1
        System.out.println("---------- Task1");
        int studId = 6;

        StudentService studentServ = new StudentService();
        System.out.println(studentServ.getStudentByID(studId));
        System.out.println(studentServ.getStudentByName("Лебедева Элеонора Михайловна"));


        System.out.println(getStudentById(students, studId).toString().replace("[", "").replace("]", ""));

        // Task 2
        System.out.println("---------- Task2");
        System.out.println(deleteStudentById(1));
        createNewStudent(5, "Бухарь Кирилл Васильевич", 750);
        readBD(students);

        // Task 3
        System.out.println("\n----------  Task3");
        getAllStudents();

        // Task 4
        System.out.println("\n---------- Task4");
        System.out.println(studentServ.getStudentByName("Алифировец Кирилл Дмитриевич"));
    }

    public static void readBD(List<Students> students) throws SQLException {
        students.clear();

        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int group_id = rs.getInt("group_id");

            Students studentN = new Students(id, name, group_id);
            students.add(studentN);
        }
        connection.close();
    }

    public static List<Students> getStudentById(List<Students> students, int id) {
        return students.stream()
                .filter(w -> w.getId() == id)
                .collect(Collectors.toList());
    }

    public static List<Students> getStudentListByName(List<Students> students, String name) {
        return students.stream()
                .filter(w -> Objects.equals(w.getName(), name))
                .collect(Collectors.toList());
    }

    public static void getAllStudents() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int group_id = rs.getInt("group_id");
            System.out.println("id: " + id + " \tname: " + name +" \tgroup_id: " + group_id);
        }
        connection.close();
    }

    public static boolean deleteStudentById(int id) throws SQLException {
        boolean val = false;
        StudentService studentServ = new StudentService();
        if (studentServ.getStudentByID(id) == null) {
            System.out.println("The record about student with id:" + id + " doesn't exist in BD");
            return false;
        } else {
            Connection connection = DriverManager.getConnection(URL, USER, pass);
            PreparedStatement st2 = connection.prepareStatement("DELETE FROM students WHERE id = " + id);
            st2.executeUpdate();
            connection.close();
            System.out.println("The record was deleted from DataBase successfully");
            val = true;
        }
        return val;
    }

    public static void createNewStudent(int id, String name, int group_id) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        PreparedStatement st = connection.prepareStatement("insert into students (id, name, group_id) value(" + id + "," + name + "," + group_id);
        st.executeUpdate();
        connection.close();
        System.out.println("New student was added to BD");
    }

}