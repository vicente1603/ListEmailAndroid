package com.santiago.listgmailjava.model;

import java.util.Arrays;
import java.util.List;

public class Emails {

    public static List<Email> fakeEmails() {

        return Arrays.asList(

                Email.EmailBuilder.builder()
                        .setUser("Facebook")
                        .setSubject("ddddd")
                        .setPreview("zzzzzzzzzzzzzzzzzzzzzzzzz")
                        .setDate("11 nov")
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Instagram")
                        .setSubject("aaaaaaaaa")
                        .setPreview("sssssssssssssssssssssssssssssssss")
                        .setDate("09 abr")
                        .build(),


                Email.EmailBuilder.builder()
                        .setUser("Facebook")
                        .setSubject("tttttttttttttt")
                        .setPreview("rrrrrrrrrrrr")
                        .setDate("8 out")
                        .setStared(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Whatsapp")
                        .setSubject("tttttttttttttt")
                        .setPreview("rrrrrrrrrrrr")
                        .setDate("8 out")
                        .setUnread(true)
                        .build()

        );

    }

}
