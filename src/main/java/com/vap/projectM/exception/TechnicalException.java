package com.vap.projectM.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TechnicalException extends Exception{

    public TechnicalException (final String message){
        super(message);
    }
}
