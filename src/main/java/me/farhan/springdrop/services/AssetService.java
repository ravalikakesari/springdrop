package me.farhan.springdrop.services;

import me.farhan.springdrop.domain.entities.Asset;
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
        String fileName = storageService.store(file);
        saveFile(fileName);
      }catch (Exception e){

      }
    }

    private void saveFile(final String fileName){
      Asset asset = new Asset();
      asset.setFileName(fileName);
      assetRepository.save(asset);
    }


}
