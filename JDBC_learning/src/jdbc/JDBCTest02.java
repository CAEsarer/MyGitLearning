package jdbc;
/*
实现功能：
    1.需求，模拟用户登录功能的实现
    2.业务描述：
        程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
        用户输入用户名和密码之后，提交信息，java程序收集到用户信息
        java程序连接数据库验证用户名和密码是否合法
        合法：显示登录成功
        不合法：显示登录失败
     3.数据的准备：
        在实际开发中，表的设计会使用专业的建模工具，我们这里安装一个建模工具：PowerDesigner
        使用PD工具来进行数据库表的设计
*/
public class JDBCTest02 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
