package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {
    public static void main(String[] args)  {
        Connection conn = null;
        Statement stmt =null;
        try {
            //1.导入驱动jar包
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取数据库的连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mp3?useSSL=false&serverTimezone=GMT", "root", "123");
            //4.定义sql语句
            String sql = "UPDATE users SET password=111 WHERE id = 2";
            //5.获取执行sql的对象Statement
            stmt = conn.createStatement();
            //6.执行sql语句
            int result = stmt.executeUpdate(sql);
            //7.处理结果
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //8.释放资源
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    }
