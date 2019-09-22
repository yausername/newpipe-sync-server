package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.PlaylistResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "playlists")
@Getter
@Setter
public class Playlist extends BaseEntity<PlaylistResponse> {

    @NotBlank
    @Size(max = 512)
    private String name;

    @NotBlank
    @Size(max = 512)
    private String thumbnailUrl;

    public PlaylistResponse toView() {
        PlaylistResponse response = new PlaylistResponse();
        response.setUid(uid);
        response.setName(name);
        response.setThumbnailUrl(thumbnailUrl);
        return response;
    }
}
