package org.belon.booktracker.userdata.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationDto;
import org.belon.booktracker.userdata.entities.BtUserBookAssociation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtUserBookAssociations and BtUserBookAssociationsDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtUserBookAssociationMapper {

	public BtUserBookAssociation btUserBookAssociationDtoToBtUserBookAssociations(BtUserBookAssociationDto userBookAssociationDto);
	
	public BtUserBookAssociationDto btUserBookAssociationDtoFromBtUserBookAssociations(BtUserBookAssociation userBookAssociation);
	
	public List<BtUserBookAssociation> btUserBookAssociationDtoToBtUserBookAssociations(List<BtUserBookAssociationDto> userBookAssociationDtos);
	
	public List<BtUserBookAssociationDto> btUserBookAssociationDtoFromBtUserBookAssociations(List<BtUserBookAssociation> userBookAssociations);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtUserBookAssociation updateBtUserBookAssociations(BtUserBookAssociationDto userBookAssociationDto, @MappingTarget BtUserBookAssociation userBookAssociation);
	
}
