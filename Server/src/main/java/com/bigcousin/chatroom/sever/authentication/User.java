package main.java.com.bigcousin.chatroom.sever.authentication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用户类，表示聊天室中的一个用户。
 * 包括昵称、账号、密码和用户身份信息。
 */
public class User {
    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户身份，可以是管理员或普通用户
     */
    private String role;

    /**
     * 构造方法，用于创建用户对象。
     *
     * @param nickname 用户昵称
     * @param account  用户账号
     * @param password 用户密码
     * @param role     用户身份，可以是管理员或用户
     */
    public User(String nickname, String account, String password, String role) {
        this.nickname = nickname;
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public User(String nickname, String role, String account) {
        this.account = account;
        this.nickname = nickname;
        this.role = role;
    }

    /**
     * 获取用户昵称。
     *
     * @return 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 获取用户账号。
     *
     * @return 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 获取用户密码。
     *
     * @return 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 获取用户身份。
     *
     * @return 用户身份
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置用户昵称。
     *
     * @param nickname 新的用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 设置用户密码。
     *
     * @param password 新的用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置用户身份。
     *
     * @param role 新的用户身份
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 自定义 toString 方法，用于输出用户信息。
     *
     * @return 包含用户信息的字符串表示
     */
    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    /**
     * 检查用户是否是管理员。
     *
     * @return 如果用户是管理员，返回 true；否则返回 false
     */
    public boolean isAdmin() {
        return "管理员".equals(role);
    }

    /**
     * 将用户信息保存到文件。
     * 用户信息以制表符分隔，保存在 "User.txt" 文件中。
     * 如果文件不存在，会创建新文件；如果存在，则在文件末尾追加用户信息。
     */
    public void saveToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/UserDatas.txt", true))) {
            // 格式化用户信息，以制表符分隔
            String userInfo = role + "\t" + nickname + "\t" + account + "\t" + password;
            // 写入文件并换行
            writer.write(userInfo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
