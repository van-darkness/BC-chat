package server.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String nickname;
    private String account;
    private String password;
    private String role; // 身份，可以是管理员或用户

    // 构造方法
    public User(String nickname, String account, String password, String role) {
        this.nickname = nickname;
        this.account = account;
        this.password = password;
        this.role = role;
    }

    // 获取昵称
    public String getNickname() {
        return nickname;
    }

    // 获取账号
    public String getAccount() {
        return account;
    }

    // 获取密码
    public String getPassword() {
        return password;
    }

    // 获取身份
    public String getRole() {
        return role;
    }

    // 设置昵称
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // 设置密码
    public void setPassword(String password) {
        this.password = password;
    }

    // 设置身份
    public void setRole(String role) {
        this.role = role;
    }

    // 自定义 toString 方法，用于输出用户信息
    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // 示例：检查用户是否是管理员
    public boolean isAdmin() {
        return "管理员".equals(role);
    }

    // 将用户信息保存到文件
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt", true))) {
            // 格式化用户信息，以制表符分隔
            String userInfo = role + "\t" + nickname + "\t" + account + "\t" + password;
            // 写入文件并换行
            writer.write(userInfo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
User bigcousin=new User("1","2","3","4");
bigcousin.saveToFile();
    }
}
