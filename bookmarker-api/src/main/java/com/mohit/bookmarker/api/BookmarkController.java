package com.mohit.bookmarker.api;

import com.mohit.bookmarker.domain.BookmarksDTO;
import com.mohit.bookmarker.domain.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") int page,
                                     @RequestParam(name = "query", defaultValue = "") String query) {
        if(!query.isEmpty()) {
            return bookmarkService.searchBookmarks(query, page);
        }
        return bookmarkService.getBookmarks(page);
    }

}
