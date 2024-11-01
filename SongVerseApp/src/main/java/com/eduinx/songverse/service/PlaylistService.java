package com.eduinx.songverse.service;


import java.util.List;

import com.eduinx.songverse.entity.Playlist;

public interface PlaylistService 
{

	public void addplaylsit(Playlist playlist);

	public List<Playlist> fetchAllPlaylist();
	
	

}
