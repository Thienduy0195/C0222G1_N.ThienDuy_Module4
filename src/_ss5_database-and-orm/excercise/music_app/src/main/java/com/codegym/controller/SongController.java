package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping
    public String showList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("song", new Song());
        model.addAttribute("songList", songList);
        return "song";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findOne(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateSong(Song song, RedirectAttributes redirect) {
        songService.update(song);
        redirect.addFlashAttribute("success", "Updating song successfully!");
        return "redirect:/song";
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("info");
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
        List<Song> songList = songService.findAll();
        model.addAttribute("song", new Song());
        model.addAttribute("songList", songList);
        redirect.addFlashAttribute("success", "Removed song successfully!");
        return "redirect:/song";
    }

    @GetMapping("/search")
    public String searchByName(Song song, Model model) {
        List<Song> songList = songService.search(song.getSongName());
        model.addAttribute("songList", songList);
        return "song";
    }
}
