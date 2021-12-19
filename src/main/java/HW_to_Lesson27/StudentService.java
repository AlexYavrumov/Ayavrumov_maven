package HW_to_Lesson27;

import java.sql.*;

public class StudentService {

    Students getStudentByID(int id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        Students student = null;

        String sql = "select * from students where id=" + id;
        try{
            connection= Main.getConnection();
            statement= connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            student = getData(rs);   // going to DB
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return student;
    }

    Students getStudentByName(String name) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        Students student = null;

        String sql = "select * from students where name='" + name + "'";
        try{
            connection= Main.getConnection();
            statement= connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            student = getData(rs);   // going to DB
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return student;
    }

    private Students getData(ResultSet rs ) throws SQLException {
        Students stud = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int group_id = rs.getInt("group_id");
            stud = new Students(id, name, group_id);
        }
        return stud;
    }
}