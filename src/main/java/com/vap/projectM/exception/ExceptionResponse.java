package com.vap.projectM.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;

    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }
}
