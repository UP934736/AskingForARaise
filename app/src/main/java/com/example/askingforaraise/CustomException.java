package com.example.askingforaraise;

import java.io.FileNotFoundException;

public class CustomException extends NullPointerException {
    public CustomException(String errorMessage){

        super(errorMessage);

    }
}
