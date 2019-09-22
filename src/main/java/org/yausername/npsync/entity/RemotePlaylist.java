package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.RemotePlaylistResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "remote_playlists")
@Getter
@Setter
public class RemotePlaylist extends BaseEntity<RemotePlaylistResponse> {

    @NotBlank
    @Size(max = 64)
    private String serviceId;

    @NotBlank
    @Size(max = 512)
    private String name;
    
    @NotBlank
    @Size(max = 512)
    private String url;
    
    @NotBlank
    @Size(max = 512)
    private String thumbnailUrl;
    
    @NotBlank
    @Size(max = 512)
    private String uploader;
    
    @NotBlank
    @Size(max = 512)
    private String streamCount;
    
    public RemotePlaylistResponse toView() {
        RemotePlaylistResponse response = new RemotePlaylistResponse();
        response.setUid(uid);
        response.setServiceId(serviceId);
        response.setName(name);
        response.setUrl(url);
        response.setThumbnailUrl(thumbnailUrl);
        response.setUploader(uploader);
        response.setStreamCount(streamCount);
        return response;
    }

}
