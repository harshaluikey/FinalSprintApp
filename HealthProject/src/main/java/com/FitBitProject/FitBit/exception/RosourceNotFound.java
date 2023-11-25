package com.FitBitProject.FitBit.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RosourceNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
	public RosourceNotFound(String message){
        super(message);
    }

	}

