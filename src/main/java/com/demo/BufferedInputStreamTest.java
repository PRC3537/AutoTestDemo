package com.demo;import java.io.*;/** * @program: AutoTestDemo * @description: BufferedInputStreamTest测试程序 * @author: gonghuihui * @create: 2018-10-10 11:00 **/public class BufferedInputStreamTest {    private static final int LEN = 5;    public static void main(String[] args) {        testBufferedInputStream();    }    private static void testBufferedInputStream() {        // 创建BufferedInputStream字节流，内容是ArrayLetters数组        try {            File file = new File("bufferedinputstream.txt");            InputStream in = new BufferedInputStream(new FileInputStream(file), 512);            // 从字节流中读取5个字节。 "abcde",a对应0x61,b对应0x62,依次类推...            for (int i = 0; i < LEN; i++) {                // 若能继续读取下一个字节，则读取下一个字节                if (in.available() >= 0) {                    // 读取"字节流的下一个字节"                    int tmp = in.read();                    System.out.printf("%d:0x%s\n", i, Integer.toHexString(tmp));                }            }            // 若"该字节流"不支持标记功能，则直接退出            if (!in.markSupported()) {                System.out.println("make not Supported!");                return;            }            // 标记"当前索引位置"，即标记第6个位置的元素--"f"            // 1024对应marklimit            in.mark(1024);            // 跳过22个字节            in.skip(22);            // 读取第5个字节            byte[] buf = new byte[5];            in.read(buf, 0, LEN);            // 将Buf转化为String字符串            String str1 = new String(buf);            System.out.printf("Str1=%s\n", str1);            // 重置"输入流的索引"为mark()所标志的位置，即重置到"f"处            in.reset();            // 从"重置后的字节流"中读取5个字节到buf中。即读取"fghij"            in.read(buf, 0, LEN);            // 将buf转化为String字符串            String str2 = new String(buf);            System.out.printf("Str2=%s\n", str2);            in.close();        } catch (FileNotFoundException e) {            e.printStackTrace();        } catch (IOException e) {            e.printStackTrace();        }    }}