package jdbc;

import java.sql.*;

public class jdbcTest02 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库的连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mp3?useSSL=false&serverTimezone=GMT", "root", "123");
            //3.定义sql语句
            String sql = "select * from users";
            //4.获取执行sql的对象Statement
            stmt = conn.createStatement();
            //5.执行sql语句
            rs =stmt.executeQuery(sql);
            //6处理结果集
            while(rs.next()){
                int id = rs.getInt(1) ;
                String name = rs.getString("name");
                String psw = rs.getString("password");
                System.out.println(id+"---"+name+"---"+psw);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
