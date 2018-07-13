package com.ibexsys.websvc.rest.toolkit.exception;

import java.util.Date;

public class ExceptionResponse {

    private final String message;
    private final Date timestamp;
    private final String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }

}
