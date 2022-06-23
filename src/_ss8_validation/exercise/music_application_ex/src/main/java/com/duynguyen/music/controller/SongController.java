package com.duynguyen.music.controller;


import com.duynguyen.music.model.Song;
import com.duynguyen.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("song")
public class SongController {

    @Autowired
    private ISongService songService;

//    @GetMapping
//    public String showList(Model model) {
//        List<Song> songList = songService.findAll();
//        model.addAttribute("song", new Song());
//        model.addAttribute("songList", songList);
//        return "song";
//    }

    @GetMapping
    public String showSongList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("song_name").ascending();
        Page<Song> songList = songService.findAll(PageRequest.of(page, 3, sort));
        model.addAttribute("song", new Song());
        model.addAttribute("songList", songList);
        return "song";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

//    @PostMapping("/save")
//    public String save(Song song) {
//        songService.save(song);
//        return "redirect:/song";
//    }

    @PostMapping("/save")
    public String save(@Validated Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("success", "Create song successfully!");
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findOne(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateSong(@Validated Song song, BindingResult bindingResult, RedirectAttributes redirect) {
        if(bindingResult.hasErrors()){
            return "/update";
        }
        songService.update(song);
        redirect.addFlashAttribute("success", "Updating song successfully!");
        return "redirect:/song";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        Song song = songService.findOne(id);
        modelAndView.addObject("song", song);
        return modelAndView;
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findOne(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Song song, Model model, RedirectAttributes redirect) {
        songService.delete(song);
        List<Song> songList = songService.getSongList();
        model.addAttribute("song", new Song());
        model.addAttribute("songList", songList);
        redirect.addFlashAttribute("success", "Removed song successfully!");
        return "redirect:/song";
    }

//    @GetMapping("/search")
//    public String searchByName(Song song, Model model) {
//        List<Song> songList = songService.search(song.getSongName());
//        model.addAttribute("songList", songList);
//        return "song";
//    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page,
                               Song song, Model model) {
        Pageable pageable;
        Sort sort = Sort.by("song_name").ascending();
        pageable = PageRequest.of(page, 10, sort);
        Page<Song> songList = songService.search(song.getSongName(), pageable);
        model.addAttribute("songList", songList);
        return "song";
    }
}
