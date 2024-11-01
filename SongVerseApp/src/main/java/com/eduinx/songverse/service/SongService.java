package com.eduinx.songverse.service;



import java.util.List;

import com.eduinx.songverse.entity.Song;

public interface SongService
{

	public String addSong(Song song);

	public boolean songExists(String name);

	public List<Song> fetchAllSongs();

	public void updateSong(Song s);


	

}
