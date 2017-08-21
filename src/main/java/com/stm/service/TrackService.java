package com.stm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Track;

public interface TrackService {


public abstract List<Track> getAll();
public abstract Track addTrack(Track track);
public abstract Track findOne(Long trackId);
Iterable<Track> listAlltracks();

   Track getTrackById(Long id);

  

   void deleteTrack(Long id);

   Page<Track> findAll(Pageable pageable);
}

