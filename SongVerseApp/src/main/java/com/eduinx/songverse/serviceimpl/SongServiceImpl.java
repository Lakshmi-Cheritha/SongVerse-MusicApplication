package com.eduinx.songverse.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduinx.songverse.entity.Song;
import com.eduinx.songverse.repository.SongRepository;
import com.eduinx.songverse.service.SongService;
@Service
public class SongServiceImpl  implements SongService
{
	@Autowired
	 SongRepository songRepo;

	@Override
	public String addSong(Song song) 
	{
		songRepo.save(song);
		return "Song Added Successfully";
		
		
	}
	@Override
	public boolean songExists(String name)
	{
		Song song=songRepo.findByName(name);
		if(song==null)
		{
			return false;
		}else
		{
		return true;
		}
	}
	public List<Song> fetchAllSongs()
	{
		List<Song> songs=songRepo.findAll();
		return songs;
		
	}
	@Override
	public void updateSong(Song s)
	{
		songRepo.save(s);
		
		
	}
}
	












