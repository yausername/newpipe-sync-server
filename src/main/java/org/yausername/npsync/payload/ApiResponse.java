package org.yausername.npsync.payload;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    @NonNull
    private HttpStatus status;
    @NonNull
    private String message;
    @Nullable
    private List<String> errors;

    public ApiResponse(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiResponse(final HttpStatus status, final String message, final String error) {
        this(status, message, Arrays.asList(error));
    }
    
    public ApiResponse(final HttpStatus status, final String message) {
        this(status, message, (List<String>) null);
    }

    public void setError(final String error) {
        this.errors = Arrays.asList(error);
    }
    
    public static ApiResponse ok(final String message) {
        return new ApiResponse(HttpStatus.OK, message);
    }
    
    public static ApiResponse badRequest(final String message) {
        return new ApiResponse(HttpStatus.BAD_REQUEST, message);
    }
    
    public static ApiResponse created(final String message) {
        return new ApiResponse(HttpStatus.CREATED, message);
    }

}
