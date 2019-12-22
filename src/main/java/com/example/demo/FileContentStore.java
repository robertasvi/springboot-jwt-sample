package com.example.demo;

import com.example.demo.domain.File;
import org.springframework.content.commons.repository.ContentStore;

public interface FileContentStore extends ContentStore<File, String> {
}