package me.farhan.springdrop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "folders")
public class FoldersController {

  @GetMapping(value = "/new")
  public String newFolder(Model model){
    return "folders/new";
  }

  @PostMapping(value = "/create")
  public String createFolder(Model model){
    return "folders/new";
  }

  @GetMapping(value = "/edit/{id}")
  public String editFolder(@PathVariable("id") int id,Model model){
    return "folders/new";
  }

  @DeleteMapping(value = "/delete/{id}")
  public String deleteFolder(@PathVariable("id") int id,Model model){
    return "folders/new";
  }

}
