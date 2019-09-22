package org.yausername.npsync.payload;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistStreamJoinPayload {

    @NotNull
    protected Long playlistId;

    @NotNull
    protected Long streamId;
    
    protected Integer joinIndex;
    
}
