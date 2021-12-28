package com.codegym.music_app.controller;

import com.codegym.music_app.dto.SongDTO;
import com.codegym.music_app.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showListSong(Model model) {
        model.addAttribute("songs", this.songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new SongDTO());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("song") SongDTO songDto,
                       BindingResult bindingResult, RedirectAttributes redirect) {
        new SongDTO().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            songService.save(songDto);
            redirect.addFlashAttribute("success", "Created new song complete !!");
            return "redirect:/";
        }
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("song") SongDTO songDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        new SongDTO().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("song",songDto);
            return "edit";
        } else {
            songService.save(songDto);
            redirect.addFlashAttribute("success", "Edit success");
            return "redirect:/";
        }
    }
}

