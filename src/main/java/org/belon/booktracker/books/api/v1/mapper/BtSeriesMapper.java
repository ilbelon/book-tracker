package org.belon.booktracker.books.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtSeriesDto;
import org.belon.booktracker.books.entities.BtSeries;
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
public interface BtSeriesMapper {

	public BtSeries BtSeriesDtoToBtSeries(BtSeriesDto userDto);
	
	public BtSeriesDto BtSeriesDtoFromBtSeries(BtSeries user);
	
	public List<BtSeries> BtSeriesDtoToBtSeries(List<BtSeriesDto> userDtos);
	
	public List<BtSeriesDto> BtSeriesDtoFromBtSeries(List<BtSeries> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtSeries updateBtSeries(BtSeriesDto userDto, @MappingTarget BtSeries user);
	
}
