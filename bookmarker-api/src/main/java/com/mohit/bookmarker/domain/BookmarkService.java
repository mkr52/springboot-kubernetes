package com.mohit.bookmarker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
//    private final BookmarkMapper bookmarkMapper; // mapper removed after adding DTO projections

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(int page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookMarks = bookmarkRepository.findAllBookMarks(pageable);
        return new BookmarksDTO(bookMarks);
    }

    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(String query, int page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
//        Page<BookmarkDTO> bookmarks = bookmarkRepository.searchBookmarks(query, pageable);
        Page<BookmarkDTO> bookmarks = bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable);
        return new BookmarksDTO(bookmarks);
    }
}
