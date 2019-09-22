package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.StreamResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "streams")
@Getter
@Setter
public class Stream extends BaseEntity<StreamResponse>{

    @NotBlank
    @Size(max = 64)
    private String serviceId;

    @NotBlank
    @Size(max = 512)
    private String url;

    @NotBlank
    @Size(max = 512)
    private String title;
    
    @NotBlank
    @Size(max = 512)
    private String streamType;
    
    @NotBlank
    @Size(max = 512)
    private String duration;
    
    @NotBlank
    @Size(max = 512)
    private String uploader;

    @NotBlank
    @Size(max = 512)
    private String thumbnailUrl;
    
    public StreamResponse toView() {
        StreamResponse response = new StreamResponse();
        response.setUid(uid);
        response.setServiceId(serviceId);
        response.setUrl(url);
        response.setTitle(title);
        response.setStreamType(streamType);
        response.setDuration(duration);
        response.setUploader(uploader);
        response.setThumbnailUrl(thumbnailUrl);
        return response;
    }

}
