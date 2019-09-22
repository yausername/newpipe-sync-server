package org.yausername.npsync.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchHistoryPayload {

    @NotBlank
    @Size(max = 512)
    protected String creationDate;
    
    @NotBlank
    @Size(max = 64)
    protected String serviceId;

    @NotBlank
    @Size(max = 512)
    protected String search;

}
