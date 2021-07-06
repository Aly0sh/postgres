package com.company;

import java.io.IOException;
import java.sql.*;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
        }

    public void insert(String sql){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void createTable(){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            String sql="create table product(\n" +
                    "id integer primary key,\n" +
                    "name_of_product varchar(50) not null unique,\n" +
                    "price integer not null,\n" +
                    "expiration_date date\n" +
                    ");";
            ResultSet rs=st.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getTable(){
        try (Connection co=connect();
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM product")){
            while (rs.next()) {
                System.out.println(rs.getInt(1)+"\t"+
                        rs.getString(2)+"\t"+
                        rs.getInt(3)+"\t"+
                        rs.getDate(4)
                        );
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void renameTo(String oldName ,String newName){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery("ALTER TABLE "+oldName+" RENAME TO "+newName);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteLine(String tableName, String idRowName, int id){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery("DELETE FROM "+tableName+" WHERE "+idRowName+" = "+id+";");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoProduct(){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            String sql="INSERT INTO product (id, name_of_product, price, expiration_date)\n" +
                    "values(4, 'Курица', 250, '2021-08-21');";
            ResultSet rs=st.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateIndex(){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            String sql="UPDATE product SET id = 5 WHERE id = 4;";
            ResultSet rs=st.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void dropTable(String tableName){
        try (Connection co=connect();){
            Statement st=co.createStatement();
            String sql="DROP TABLE "+tableName+";";
            ResultSet rs=st.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    }
