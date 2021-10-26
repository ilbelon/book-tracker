package org.belon.booktracker.userdata.api.v1.mappers;

import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationIdDto;
import org.belon.booktracker.userdata.entities.BtUserBookAssociationId;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtUserBookAssociations and BtUserBookAssociationsDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtUserBookAssociationIdMapper {

	public BtUserBookAssociationId btUserBookAssociationIdDtoToBtUserBookAssociationId(BtUserBookAssociationIdDto userBookAssociationDto);
	
	public BtUserBookAssociationIdDto btUserBookAssociationIdDtoFromBtUserBookAssociationId(BtUserBookAssociationId userBookAssociation);
	
}
