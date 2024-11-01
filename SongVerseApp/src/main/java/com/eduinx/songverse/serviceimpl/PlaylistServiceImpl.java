package com.eduinx.songverse.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduinx.songverse.entity.Playlist;
import com.eduinx.songverse.repository.PlaylistRepository;
import com.eduinx.songverse.service.PlaylistService;
@Service
public class PlaylistServiceImpl implements PlaylistService 
{
	@Autowired
	PlaylistRepository playlistRepo;

@Override
	public void addplaylsit(Playlist playlist)
	{
		playlistRepo.save(playlist);
	}

@Override
	public List<Playlist> fetchAllPlaylist() 
	{
		List<Playlist> allplaylist =playlistRepo.findAll();
	
		return allplaylist ;
	}


	
}

