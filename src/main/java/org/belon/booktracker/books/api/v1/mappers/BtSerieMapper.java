package org.belon.booktracker.books.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtSerieDto;
import org.belon.booktracker.books.entities.BtSerie;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtSeries and BtSeriesDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtSerieMapper {

	public BtSerie btSeriesDtoToBtSeries(BtSerieDto userDto);
	
	public BtSerieDto btSeriesDtoFromBtSeries(BtSerie user);
	
	public List<BtSerie> btSeriesDtoToBtSeries(List<BtSerieDto> userDtos);
	
	public List<BtSerieDto> btSeriesDtoFromBtSeries(List<BtSerie> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtSerie updateBtSeries(BtSerieDto userDto, @MappingTarget BtSerie user);
	
}
