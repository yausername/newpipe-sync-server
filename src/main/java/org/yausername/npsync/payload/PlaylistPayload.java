package org.yausername.npsync.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistPayload {

    @NotBlank
    @Size(max = 512)
    protected String name;

    @NotBlank
    @Size(max = 512)
    protected String thumbnailUrl;

}
