package com.stepyen.demo.java.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * date：6/3/21
 * author：stepyen
 * description：java 序列化
 */
public class TestSerialize {

    public static void main(String[] args) {

        User user = new User();

        user.name = "stepyen";
        user.age = 27;
//        user.height = 178;
        user.weight = 63;
        user.skinColor = "black";

//        user.serialization();
        user.deserialization();

    }


    static class User implements Serializable {

        public String name;
        public int age;
        public static int height;
        public transient int weight;    // transient 修饰的字段不被序列化
        public String skinColor = "";

        /**
         * 序列化
         * <p>
         * 将对象写入流中
         */
        public void serialization() {
            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("user.ser"));
                output.writeObject(this);
                output.close();

                System.out.println("序列化");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 反序列化
         * <p>
         * 从流中读取对象
         */
        public void deserialization() {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.ser"));
                User user = (User) inputStream.readObject();

                String info = "";
                if (user == null) {
                    info = "user is empty";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("{name:" + user.name);
                    sb.append(",age:" + user.age);
                    sb.append(",height:" + user.height);
                    sb.append(",weight:" + user.weight);
                    sb.append(",skinColor:" + user.skinColor);
                    sb.append("}");

                    info = sb.toString();
                }

                System.out.println("反序列化：" + info);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
