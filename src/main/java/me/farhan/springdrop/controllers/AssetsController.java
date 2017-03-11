package me.farhan.springdrop.controllers;

import me.farhan.springdrop.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "assets")
public class AssetsController {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public String index(Model model) {
        return "assets/index";
    }

}
