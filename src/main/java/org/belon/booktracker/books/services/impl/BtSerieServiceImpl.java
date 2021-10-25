package org.belon.booktracker.books.services.impl;

import java.util.List;
import java.util.Optional;

import org.belon.booktracker.books.api.v1.dtos.BtSerieDto;
import org.belon.booktracker.books.api.v1.mappers.BtSerieMapper;
import org.belon.booktracker.books.entities.BtSerie;
import org.belon.booktracker.books.repositories.BtSerieRepository;
import org.belon.booktracker.books.services.BtSerieService;
import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtSeriesService
 * 
 * @author Andrea
 *
 */
@Service
public class BtSerieServiceImpl implements BtSerieService{

	@Autowired
	private BtSerieRepository serieRepository;
	@Autowired
	private BtSerieMapper serieMapper;
	
	private String serieNotFoundMessage="Serie with this id does not exists";
	private String authorAlreadyExistsMessage="This serie already exists.";
	
	@Transactional
	public BtSerieDto createBtSerie(BtSerieDto serieDto) {
		this.checkIfserieWithNameAlreadyPresent(serieDto);
		BtSerie serie = serieMapper.btSeriesDtoToBtSeries(serieDto);
		serie = serieRepository.save(serie);
		return serieMapper.btSeriesDtoFromBtSeries(serie);
	}

	@Transactional(readOnly = true)
	public BtSerieDto getBtSerie(Long id) {
		Optional<BtSerie> serie = serieRepository.findById(id);
		if(serie.isPresent()) {
			return serieMapper.btSeriesDtoFromBtSeries(serie.get());
		}
		else throw new ResourceNotFoundException(serieNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtSerieDto> getBtSeriesList() {
		return serieMapper.btSeriesDtoFromBtSeries(serieRepository.findAll());
	}

	@Transactional
	public BtSerieDto patchBtSerie(BtSerieDto serieDto) {
		this.checkIfserieWithNameAlreadyPresent(serieDto);
		Optional<BtSerie> serie = serieRepository.findById(serieDto.getId());
		if(serie.isPresent()) {
			BtSerie updatedserie = serieMapper.updateBtSeries(serieDto,serie.get());
			updatedserie = serieRepository.save(updatedserie);
			return serieMapper.btSeriesDtoFromBtSeries(updatedserie);
		}
		else throw new ResourceNotFoundException(serieNotFoundMessage);
	}

	@Transactional
	public void deleteBtSerie(Long id) {
		try {
			serieRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(serieNotFoundMessage);
		}
		
	}
	
	private void checkIfserieWithNameAlreadyPresent(BtSerieDto serieDto) {
		Optional<BtSerie> checkIfAlreadyPresent = serieRepository.findByName(serieDto.getName());
		if(checkIfAlreadyPresent.isPresent()&&!checkIfAlreadyPresent.get().getId().equals(serieDto.getId())
				) throw new PersistenceViolationException(authorAlreadyExistsMessage, serieMapper.btSeriesDtoFromBtSeries(checkIfAlreadyPresent.get())); 
	}

}
