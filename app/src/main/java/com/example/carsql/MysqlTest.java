package com.example.carsql;

import java.sql.*;

public class MysqlTest {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static void select(String[] out, int[] count, String DB_URL1, String USER, String PASS,
                              String DB_URL2, String TABLENAME) {
        Connection conn = null;
        Statement stmt = null;

        String DB_URL = "jdbc:mysql://"+DB_URL1+":3306/"+DB_URL2;

        // 数据库的用户名与密码，需要根据自己的设置
//        USER = "python";
//        PASS = "Python12345@";
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM "+ TABLENAME;
            ResultSet rs = stmt.executeQuery(sql);

            //String[] out = new String[1000];
            int i = 0;

            // 展开结果集数据库
            while(rs.next()){
                System.out.println(rs);
                // 通过字段检索
                String TIME  = rs.getString("TIME");
                String COLOR1 = rs.getString("COLOR1");
                String TEXT1 = rs.getString("TEXT1");
                String TEXT2 = rs.getString("TEXT2");
                String API = rs.getString("API");
                String SOURCE = rs.getString("SOURCE");
                String output = " " + TIME + "\n " + COLOR1 + " " + TEXT1 +
                        " " + TEXT2 + " " + API + " \n" + SOURCE;
                // 输出数据
                out[i] = output + "\n";
                count[0] = i;
                i++;
            }
            //System.out.println(out);
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
    public static void select2(String[] out, int[] count, String DB_URL1, String USER, String PASS,
                              String DB_URL2, String TABLENAME,String CARPLA) {
        Connection conn = null;
        Statement stmt = null;

        String DB_URL = "jdbc:mysql://"+DB_URL1+":3306/"+DB_URL2;

        // 数据库的用户名与密码，需要根据自己的设置
//        USER = "python";
//        PASS = "Python12345@";
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from "+ TABLENAME + " where TEXT1 like '%"+ CARPLA +"%' "+
                    "or TEXT2 like '%"+ CARPLA +"%' or COLOR1 like '%"+ CARPLA +"%'"+
                    "or COLOR2 like '%"+ CARPLA +"%' or API like '%"+ CARPLA +"%'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            //String[] out = new String[1000];
            int i = 0;

            // 展开结果集数据库
            while(rs.next()){
                System.out.println(rs);
                // 通过字段检索
                String TIME  = rs.getString("TIME");
                String COLOR1 = rs.getString("COLOR1");
                String TEXT1 = rs.getString("TEXT1");
                String TEXT2 = rs.getString("TEXT2");
                String API = rs.getString("API");
                String SOURCE = rs.getString("SOURCE");
                String output = " " + TIME + "\n " + COLOR1 + " " + TEXT1 +
                        " " + TEXT2 + " " + API + " \n" + SOURCE;
                // 输出数据
                out[i] = output + "\n";
                count[0] = i;
                i++;
            }
            //System.out.println(out);
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
