package com.example.myapplication;

import java.sql.*;

public class MysqlTest {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.43.99:3306/chepai";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "python";
    static final String PASS = "Python12345@";

    public static void select(String[] out, int[] count) {
        Connection conn = null;
        Statement stmt = null;
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
            sql = "SELECT * FROM CARINFO";
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
}
