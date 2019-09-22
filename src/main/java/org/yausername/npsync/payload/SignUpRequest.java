package org.yausername.npsync.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    
    @NotBlank
    @Size(min = 3, max = 128)
    private String username;

    @NotBlank
    @Size(min = 6, max = 128)
    private String password;
}
