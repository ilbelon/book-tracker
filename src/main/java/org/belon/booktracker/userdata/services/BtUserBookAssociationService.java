package org.belon.booktracker.userdata.services;

import java.util.List;

import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationDto;
import org.belon.booktracker.userdata.api.v1.dtos.BtUserBookAssociationIdDto;

/**
 * Service interface for BtUserBookAssociation
 * 
 * @author Andrea
 *
 */

public interface BtUserBookAssociationService {

	public BtUserBookAssociationDto createBtUserBookAssociation(BtUserBookAssociationDto userDto);
	
	public BtUserBookAssociationDto getBtUserBookAssociation(BtUserBookAssociationIdDto userBookAssociationIdDto);
	
	public List<BtUserBookAssociationDto> getBtUserBookAssociationList();
	
	public BtUserBookAssociationDto patchBtUserBookAssociation(BtUserBookAssociationDto userDto);
	
	public void deleteBtUserBookAssociation(BtUserBookAssociationIdDto userBookAssociationIdDto);
}
