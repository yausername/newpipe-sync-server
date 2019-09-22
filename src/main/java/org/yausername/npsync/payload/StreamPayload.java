package org.yausername.npsync.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreamPayload {

    @NotBlank
    @Size(max = 64)
    protected String serviceId;

    @NotBlank
    @Size(max = 512)
    protected String url;

    @NotBlank
    @Size(max = 512)
    protected String title;
    
    @NotBlank
    @Size(max = 512)
    protected String streamType;
    
    @NotBlank
    @Size(max = 512)
    protected String duration;
    
    @NotBlank
    @Size(max = 512)
    protected String uploader;

    @NotBlank
    @Size(max = 512)
    protected String thumbnailUrl;

}
