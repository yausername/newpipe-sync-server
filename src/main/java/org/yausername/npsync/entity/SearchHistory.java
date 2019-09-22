package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.SearchHistoryResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "search_history")
@Getter
@Setter
public class SearchHistory extends BaseEntity<SearchHistoryResponse> {

    @NotBlank
    @Size(max = 512)
    private String creationDate;
    
    @NotBlank
    @Size(max = 64)
    private String serviceId;

    @NotBlank
    @Size(max = 512)
    private String search;
    
    public SearchHistoryResponse toView() {
        SearchHistoryResponse response = new SearchHistoryResponse();
        response.setUid(uid);
        response.setCreationDate(creationDate);
        response.setServiceId(serviceId);
        response.setSearch(search);
        return response;
    }

}
