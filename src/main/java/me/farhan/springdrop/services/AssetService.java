package me.farhan.springdrop.services;

import me.farhan.springdrop.domain.entities.Asset;
import me.farhan.springdrop.domain.entities.User;
import me.farhan.springdrop.repositories.AssetRepository;
import me.farhan.springdrop.services.users.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AssetService {

  @Autowired
  private AssetRepository assetRepository;

  @Autowired
  private StorageService storageService;

  @Autowired
  private AuthenticationFacade authentication;

  public void saveFile(MultipartFile file) {
    try {
      User user = currentUser();
      String fileName = storageService.store(file);
      saveFile(fileName);
    } catch (Exception e) {

    }
  }

  private void saveFile(final String fileName) {
    User user = currentUser();
    Asset asset = new Asset();
    asset.setFileName(fileName);
    asset.setUser(user);
    assetRepository.save(asset);
  }


  public List<Asset> getAssets() {
    return  assetRepository.findByUser(currentUser());
  }

  private User currentUser(){
   return authentication.currentUser().getUser();
  }

}
