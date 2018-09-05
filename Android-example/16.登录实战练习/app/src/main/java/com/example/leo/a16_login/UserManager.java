package com.example.leo.a16_login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dingdongqianbaofuyin on 2018/9/4.
 */

public class UserManager {

    ArrayList<User> userList = new ArrayList();

    File file; //保存文件

    public UserManager(File file) {
        this.file = file;
    }

    //添加用户
    public void add(User u) {
        userList.add(u);
    }

    //查找一个用户
    public User find(String name) {
        for (User u: userList) {
            if (u.username.equals(name)) {
                return u;
            }
        }

        return null;
    }


    //保存到文件
    public void save() throws Exception {
        FileOutputStream fs = new FileOutputStream(file);
        try {
            for (User u: userList) {
                //每行存储一个用户的信息，每行格式为  "用户名,密码\n"
                String line = u.username + "," + u.password + "\n";


                fs.write(line.getBytes("UTF-8"));
            }
        } finally {
            fs.close();
        }

    }

    //从文件取出到链表
    public void load() throws Exception {
        InputStreamReader m = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader reader = new BufferedReader(m);
        userList.clear(); //先清空链表

        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            String[] cols = line.split(",");
            if (cols.length < 2) continue;

            User u = new User();
            u.username = cols[0].trim();
            u.password = cols[1].trim();

            userList.add(u);
        }

        reader.close();
    }

}
