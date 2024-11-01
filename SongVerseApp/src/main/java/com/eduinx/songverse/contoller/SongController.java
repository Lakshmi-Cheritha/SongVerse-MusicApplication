package com.eduinx.songverse.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eduinx.songverse.entity.Song;
import com.eduinx.songverse.service.SongService;

@Controller
public class SongController 
{
	//Add Song
	@Autowired
	SongService songService;
	//Duplicate entries will be checked based on the name
	//of the song
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song )
	{
		boolean songStatus=songService.songExists(song.getName());
		if(songStatus==false)
		{
			songService.addSong(song);
			System.out.println("Song Added Successfully");
		}else {
			System.out.println("Song Already Exists");
		}

		return"adminhome";
	}
	@GetMapping("/viewsongs")
	public String viewsongs(Model model)
	{
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return"displaysongs";
	}
	@GetMapping("/playsongs")
	public String playsongs(Model model)
	{
		boolean premium =false;
		if(premium)
		{
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return"displaysongs";
		}else {
		return"subscriptionform";
		}
	}
}



















