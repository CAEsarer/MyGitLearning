
package jdbc;
import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //D:\PersonalFile\JDBC\resources\mysql-connector-java-8.0.29\mysql-connector-java-8.0.29.jar;
        try{
            //1.注册驱动，告诉JVM我现在使用哪个公司的数据库驱动产品
            com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();//com.Mysql.jdbc.Driver是Mysql数据库厂家写的
            DriverManager.registerDriver(driver);
            //第一步驱动注册完毕

            //2.建立数据库连接对象conn
            String url = "jdbc:mysql://localhost:3306/bjpowernode";
            String user = "root";
            String password = "0712";
            conn = DriverManager.getConnection(url, user, password);
            //输出连接对象的内存地址
            System.out.println(conn);
            //连接建立成功

            //3.获取数据库操作对象stmt,这一步决定resultset能不能前后灵活移动
            //创建对象Statement，stmt,stmt2
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt2 = conn.createStatement();
            System.out.println(stmt);
            System.out.println(stmt2);

            //4.执行SQL语句,stmt.execute();
//            String updateSql = "insert into dept (deptno, dname, loc) values (33, '人事部', '深圳')";
//            //stmt.execute(updateSql);
//            String deleteSql = "delete from dept where deptno = 33";
//            stmt.execute(deleteSql);
            //执行查询语句sql
            String sql = "select empno, ename, sal from emp";
            rs = stmt.executeQuery(sql);
//            rs.last();
//            int tmp = rs.getRow();
//            System.out.println(tmp);
            //5.处理查询结果
            while(rs.next()){
                String empno = rs.getString(1);
                String ename = rs.getString(2);
                int sal = rs.getInt(3);
                System.out.println(empno + "  " + ename + "  " + sal);
            }
        }catch(SQLException e) {
            e.printStackTrace ();
        } finally {
            //6.释放数据库连接，先释放statement再释放connetion
            //释放查询结果集
            if(rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }//关闭ResultSet
            //释放数据库操作对象
            if(stmt != null){
                try {
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }//关闭Statement
            //释放数据库连接对象
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }//关闭Connection
        }

    }
}
