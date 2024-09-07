package com.mohit.bookmarker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookmarksDTO {
    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDTO(Page<BookmarkDTO> bookMarkPage) {
        this.data = bookMarkPage.getContent();
        this.totalElements = bookMarkPage.getTotalElements();
        this.totalPages = bookMarkPage.getTotalPages();
        this.currentPage = bookMarkPage.getNumber() + 1;
        this.isFirst = bookMarkPage.isFirst();
        this.isLast = bookMarkPage.isLast();
        this.hasNext = bookMarkPage.hasNext();
        this.hasPrevious = bookMarkPage.hasPrevious();
    }
}
