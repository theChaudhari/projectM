package com.vap.projectM.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class ValidationException extends Exception{
    private static final long serialVersionUID = -9079454849611061074L;

    public ValidationException(final String message) {
        super(message);
    }
}
