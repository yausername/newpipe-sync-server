package org.yausername.npsync.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreamStatePayload {

    @NotNull
    protected Long streamId;

    @NotBlank
    @Size(max = 512)
    protected String progressTime;

}
