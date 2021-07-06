package com.tbl.faq.util;

import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public class Validate {
    public static void isTrue(boolean isTrue, String msg){
        if(!isTrue){
            throw new RuntimeException(msg);
        }
    }
//    public static void imagesValidation(@NonNull ArrayList<MultipartFile> images){
//    }
}
