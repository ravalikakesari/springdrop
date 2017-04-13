package me.farhan.springdrop.services;

import me.farhan.springdrop.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private StorageService storageService;

    public void saveFile(MultipartFile file){
      try {
        storageService.store(file);
      }catch (Exception e){

      }
    }


}
