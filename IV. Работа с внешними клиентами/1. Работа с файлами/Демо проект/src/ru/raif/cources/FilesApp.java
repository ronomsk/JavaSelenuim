package ru.raif.cources;

/**
 * Created by a.pervushov on 21.11.2017.
 */

import java.io.ByteArrayInputStream;

public class FilesApp {

    public static void main(String[] args) {

        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
        int b;
        while((b=byteStream1.read())!=-1){

            System.out.println(b);
        }

        String text = "Hello world!";
        byte[] array2 = text.getBytes();
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
        int c;
        while((c=byteStream2.read())!=-1){

            System.out.println((char)c);
        }
    }
}

