package main.java.com.bigcousin.chatroom.sever.authentication;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomRandomAccountGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String SUFFIX_OPTIONS = "sabc";
    private static final int ACCOUNT_LENGTH = 8; // 生成账号的长度

    public static String generateRandomAccount() {
        SecureRandom random = new SecureRandom();
        StringBuilder accountBuilder = new StringBuilder();

        // 添加时间信息
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateInfo = dateFormat.format(new Date());
        accountBuilder.append(shuffleString(dateInfo, random));

        // 添加随机字符
        for (int i = 0; i < ACCOUNT_LENGTH - 4; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            accountBuilder.append(randomChar);
        }

        // 添加后缀
        String suffix = shuffleString(SUFFIX_OPTIONS, random);
        accountBuilder.append(suffix);

        return accountBuilder.toString();
    }

    // 打乱字符串中的字符顺序
    private static String shuffleString(String input, SecureRandom random) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[index];
            characters[index] = temp;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        // 生成随机账号并输出
        for (int i = 0; i < 10; i++) {
            String randomAccount = generateRandomAccount();
            System.out.println("Random Account: " + randomAccount);
        }

    }
}
