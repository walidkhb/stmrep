package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {

}
