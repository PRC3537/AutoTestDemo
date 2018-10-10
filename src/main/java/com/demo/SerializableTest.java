package com.demo;import com.demo.classes.Worm;import java.io.*;/** * @program: AutoTestDemo * @description: Serializable测试 * @author: gonghuihui * @create: 2018-09-20 16:53 **/public class SerializableTest {    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        Worm w = new Worm(6, 'a');        System.out.println("序列化操纵之前");        System.out.println("w=" + w);        // 序列化操作1--FileOutputStream        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("worm.out"));        oos1.writeObject("Worm storege By FileOutputStream. ");        oos1.writeObject(w);        oos1.close();        // 反序列化操作1---FileInputStream        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("worm.out"));        String s1 = (String)ois1.readObject();        Worm w1 = (Worm)ois1.readObject();        ois1.close();        System.out.println("反序列化操作1之后");        System.out.println(s1);        System.out.println("w1: " + w1);                // 序列化操作2--ByteArrayInputStream        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();        ObjectOutputStream oos2 = new ObjectOutputStream(byteOutputStream);        oos2.writeObject("Worm storage By ByteOutStream");        oos2.writeObject(w);//        System.out.println("w.serialVersionUID : " + w.serialVersionUID);        oos2.flush();        // 反序列操作2--ByteArrayInputStream        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());        ObjectInputStream ois2 = new ObjectInputStream(byteInputStream);        String s2 = (String)ois2.readObject();        Worm w2 = (Worm)ois2.readObject();//        System.out.println("w2.serialVersionUID : " + w2.serialVersionUID);        ois2.close();        System.out.println("反序列化操作2之后");        System.out.println(s2);        System.out.println("w2: " + w2);    }}