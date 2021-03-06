package by.it.chetovich.JD03_02.CRUD_Realization;


import by.it.chetovich.JD03_02.DB_it_academy.CN;
import by.it.chetovich.JD03_02.DB_it_academy.Connect;


import java.sql.*;
import java.util.Calendar;

/**
 * CRUD operations
 */
public class CRUD_operations {

    public static void insertUsers
            (String name, String surname, String login, String password, String birth_date, String id_role, String email){

        String sql;
        if (email==null) {
            sql = "insert into users (name, surname, login, password, birth_date, id_role) " +
                    "values ('"+name+"','"+surname+"','"+login+"','"+password+"','"+birth_date+"',"+id_role+"');";
        }
        else {
            sql = "insert into users (name, surname, login, password, birth_date, id_role, email) " +
                    "values ('"+name+"','"+surname+"','"+login+"','"+password+"','"+birth_date+"',"+id_role+", '"+email+"');";
        }
        Connect.ConnectionExecuteUpdate(sql);

    }

    public static void insertRole(String role_type ){

        String sql = "insert into role (role_type) values ('"+role_type+"');";
        Connect.ConnectionExecuteUpdate(sql);

    }

    public static void insertCities(String city){

        String sql = "insert into cities (city) values ('"+city+"');";
        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void insertProfiles(String id_user, String id_city, String description){

        String sql = "insert into profiles (id_user,id_city,description) values ('"+id_user+"','"+id_city+"','"+description+"');" ;
        Connect.ConnectionExecuteUpdate(sql);

    }

    public static void insertFeedbacks(String id_feedback, String feedback_from, String feedback_to, String feedback_text){

        String sql = "insert into profiles (id_feedback, feedback_from, feedback_to, feedback_text) " +
                "values ('"+id_feedback+"','"+feedback_from+"','"+feedback_to+"','"+feedback_text+"');" ;
        Connect.ConnectionExecuteUpdate(sql);

    }

    public static void deleteUsers (String columnName, String id){

        String sql = "delete from users where "+columnName+" = '"+id+"';";
        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void deleteRole (String id_role){

        String sql = "delete from role where id_role="+id_role;
        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void deleteCities (String id_city){

        String sql = "delete from cities where id_city="+id_city;
        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void deleteProfiles (String id_user){

        String sql = "delete from profiles where id_user="+id_user;
        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void deleteFeedbacks (String id){

        String sql = "delete from feedbacks where id_feedback="+id;
        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void updateUsers
            (String id, String name, String surname, String login, String password,
             String birth_date, String id_role, String email){

        String sqlName = "";
        String sqlSurname = "";
        String sqlLogin = "";
        String sqlPassword = "";
        String sqlBirthdate = "";
        String sqlRole = "";
        String sqlEmail = "";

        if (name!=null) sqlName="name = '"+name+"'";
        if (surname!=null) sqlSurname="surname = '"+surname+"'";
        if (login!=null) sqlLogin="login = '"+login+"'";
        if (password!=null) sqlPassword="password = '"+password+"'";
        if (birth_date!=null) sqlBirthdate="birth_date = '"+birth_date+"'";
        if (id_role!=null) sqlRole="id_role = '"+id_role+"'";
        if (email!=null) sqlEmail="email = '"+email+"'";

        String sql = "update users set " + sqlName + (sqlSurname.isEmpty()?"":","+sqlSurname) +
                (sqlLogin.isEmpty()?"":","+sqlLogin) + (sqlPassword.isEmpty()?"":","+sqlPassword) +
                (sqlBirthdate.isEmpty()?"":","+sqlBirthdate) + (sqlRole.isEmpty()?"":","+sqlRole) +
                (sqlEmail.isEmpty()?"":","+sqlEmail) + " where id='"+id+"';";

        System.out.println(sql);

        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void updateRole
            (String id_role, String role_type){

        String sql = "update role set role_type = '"+role_type+"' where id_role = '"+id_role+"';";

        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void updateCities
            (String id_city, String city){

        String sql = "update cities set city = '"+city+"' where id_city = '"+id_city+"'";

        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void updateProfiles
            (String id_user, String id_city, String description){

        String sqlCity = "";
        String sqlDescription = "";

        if (id_city!=null) sqlCity="id_city = '"+id_city+"'";
        if (description!=null) sqlDescription="description = '"+description+"'";

        String sql = "update profiles set " + sqlCity + (sqlDescription.isEmpty()?"":","+sqlDescription)
                + " where id_user ='"+id_user+"'";

        System.out.println(sql);

        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void updateFeedbacks
            (String id_feedback, String feedback_text){

        String sql = "update feedbacks set feedback_text = '"+feedback_text+"' where id = '"+id_feedback+"'";

        Connect.ConnectionExecuteUpdate(sql);
    }

    public static void selectUsers (){

        Calendar today = Calendar.getInstance();

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users;");

            while (resultSet.next()){
                Calendar birthday = Calendar.getInstance();
                birthday.setTime(resultSet.getDate("birth_date"));
                int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
                String user = resultSet.getString("name")+" "+resultSet.getString("surname")+", "+age+"-year old, login: "+
                        resultSet.getString("login")+" password: "+resultSet.getString("password")+", email: "+
                        resultSet.getString("email")+" "+resultSet.getInt("id_role");
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void selectUsersWhere (String columnIdName, String id){

        String sql = "select * from users where "+columnIdName+" = '"+id+"';";
        Calendar today = Calendar.getInstance();

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Calendar birthday = Calendar.getInstance();
                birthday.setTime(resultSet.getDate("birth_date"));
                int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
                String user = resultSet.getString("name")+" "+resultSet.getString("surname")+", "+age+"-year old, login: "+
                        resultSet.getString("login")+" password: "+resultSet.getString("password")+", email: "+
                        resultSet.getString("email")+" "+resultSet.getInt("id_role");
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectRole (){

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from role;");

            while (resultSet.next()){

                String role = resultSet.getInt("id_role")+" - "+resultSet.getString("role_type");
                System.out.println(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectRoleWhere (String columnIdName, String id){

        String sql = "select * from role where "+columnIdName+" = '"+id+"';";
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                String role = resultSet.getInt("id_role")+" - "+resultSet.getString("role_type");
                System.out.println(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectCities (){

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from cities;");

            while (resultSet.next()){

                String role = resultSet.getInt("id_city")+" - "+resultSet.getString("city");
                System.out.println(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectCitiesWhere (String columnIdName, String id) {

        String sql = "select * from cities where "+columnIdName+" = '"+id+"';";
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                String city = resultSet.getInt("id_city")+" - "+resultSet.getString("city");
                System.out.println(city);
            }

        } catch (Exception e) {
            System.out.println("Нет такого поля");
        }
    }

}
