package com.tbl.faq.utils;

public class Validate {
    public static void isTrue(boolean isTrue, String msg){
        if(!isTrue){
            throw new RuntimeException(msg);
        }
    }
//    public static void imagesValidation(@NonNull ArrayList<MultipartFile> images){
//    }
}
