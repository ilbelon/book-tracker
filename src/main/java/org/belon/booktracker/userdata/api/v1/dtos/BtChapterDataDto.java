package org.belon.booktracker.userdata.api.v1.dtos;

import java.io.Serializable;

import lombok.Data;

/**
 * Dto for BtChapterData
 * 
 * @author andrea
 *
 */
@Data
public class BtChapterDataDto implements Serializable{

	private static final long serialVersionUID = 6303301681752389150L;

	private Long id;
	
	private String notes;
	
}
