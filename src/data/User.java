package src.data;

public class User {
    private String nickname;
    private String account;
    private String password;
    private String role;  // 身份，可以是管理员或用户

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

    public static void main(String[] args) {
        // 创建一个用户实例
        User user1 = new User("Alice", "alice123", "password123", "用户");

        // 输出用户信息
        System.out.println(user1);

        // 修改昵称和密码
        user1.setNickname("Alicia");
        user1.setPassword("newPassword456");

        // 输出修改后的用户信息
        System.out.println(user1);

        // 示例：检查用户是否是管理员
        System.out.println("Is admin? " + user1.isAdmin());
    }
}
