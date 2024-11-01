package com.eduinx.songverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduinx.songverse.entity.Playlist;

public interface PlaylistRepository
 extends JpaRepository<Playlist, Integer>
 {

}
