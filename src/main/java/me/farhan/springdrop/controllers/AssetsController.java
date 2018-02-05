package me.farhan.springdrop.controllers;

import me.farhan.springdrop.domain.entities.Asset;
import me.farhan.springdrop.domain.user.CurrentUser;
import me.farhan.springdrop.services.AssetService;
import me.farhan.springdrop.services.StorageService;
import me.farhan.springdrop.services.users.AuthenticationFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "assets")
public class AssetsController {
    private final static Log logger = LogFactory.getLog(AssetsController.class);

    @Autowired
    private AssetService assetService;

    @GetMapping
    public String index(Model model) {
        List<Asset> assets = assetService.getAssets();
        model.addAttribute("assets",assets);
        return "assets/index";
    }

    @GetMapping("/new")
    public String newAsset(Model model) {
        return "assets/form";
    }

    @PostMapping("/create")
    public String createAsset(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
        logger.debug("From Create");
        assetService.saveFile(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/assets";
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws Exception {

        Resource file = assetService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

}
