package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/15:38
 * @description: TODO
 */


import com.briup.tools.Sort;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("src/com/briup/io/a.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        /*if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println(file.isDirectory());
        File f = new File("src/com/briup/io");
        File[] names = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains(".txt")&&new File(name).canRead();
            }
        });
        for (File name:names){
            System.out.println(name);
        }
        File[] files = File.listRoots();
        for (File file1:files){
            System.out.println(file1);
        }

    }
}
