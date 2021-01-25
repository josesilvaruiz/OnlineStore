package com.OnlineStore.OnlineStore.services;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {	

	public String copy(MultipartFile file) throws IOException;

	public boolean delete(String filename);
}
