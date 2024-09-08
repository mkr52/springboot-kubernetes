package com.mohit.bookmarker.api;

import com.mohit.bookmarker.domain.BookmarkDTO;
import com.mohit.bookmarker.domain.BookmarksDTO;
import com.mohit.bookmarker.domain.BookmarkService;
import com.mohit.bookmarker.domain.CreateBookmarkRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }

}
