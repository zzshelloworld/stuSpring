package org.zzdev.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new ClassNotFoundException(name);
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        // 从自定义路径中加载指定类
        byte[] classbyte;
        // 路径的分割符采用 / 斜线 进行文件的分割。
        File file = new File("D:/stuSpring/target/classes/org/zzdev/jvm/BootstrapShow.class");
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            FileChannel fc = fis.getChannel();
            ByteBuffer dst = ByteBuffer.allocate(1024 * 1024 * 5);
            int length = fc.read(dst, 0);
            System.out.println(length);
            classbyte = dst.array();
//            System.out.println(Arrays.toString(classbyte));
            dst.flip();
            fc.close();
            fis.close();
            return classbyte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("BootstrapShow", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
