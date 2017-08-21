package com.stm.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stm.data.entity.Track;
import com.stm.data.entity.Track;
import com.stm.data.rep.TrackRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TrackServiceImpl implements TrackService {

	private final Log log = LogFactory.getLog(TrackServiceImpl.class);
	private TrackRepository trackRepository;

	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository) {

		this.setTrackRepository(trackRepository);
	}

	public TrackRepository getTrackRepository() {
		return trackRepository;
	}

	public void setTrackRepository(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}

	@Override
	public List<Track> getAll() {
		trackRepository.findAll();
		return trackRepository.findAll();
	}

	@Override
	public Track addTrack(Track track) {
		// TODO Auto-generated method track
		return trackRepository.save(track);
	}

	@Override
	public Track findOne(Long trackId) {
		// TODO Auto-generated method stub
		return trackRepository.findOne(trackId);
	}



	@Override
	public Track getTrackById(Long id) {
		// TODO Auto-generated method stub
		
		return trackRepository.findOne(id);
	}

	@Override
	public void deleteTrack(Long id) {
		trackRepository.delete(id);		
	}

	@Override
	public Page<Track> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return trackRepository.findAll(pageable);
	}

	@Override
	public Iterable<Track> listAlltracks() {
		// TODO Auto-generated method stub
		 return trackRepository.findAll();
	}

}
