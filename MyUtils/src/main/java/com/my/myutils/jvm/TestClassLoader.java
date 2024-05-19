package com.my.myutils.jvm;

import java.io.FileInputStream;

/**
 * 自定义类加载器
 */

public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("/User/qyz");
        myClassLoader.loadClass("com.my.myutils.jvm.TestClassLoader");
    }

    static class MyClassLoader extends ClassLoader {

        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte (String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis =
                    new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}


