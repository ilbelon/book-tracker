package org.belon.booktracker.userdata.api.v1.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(notes = "Unique identifier of the ChapterData", example = "23", required = false, position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Number of Chapter", required = true, position = 1)
	@NotNull
	private Long chapterNumber;
	
	@ApiModelProperty(notes = "Title of Chapter", required = true, position = 2)
	@NotBlank
	private String title;
	
	@ApiModelProperty(notes = "Notes of ChapterData", required = false, position = 3)
	private String notes;
	
	@ApiModelProperty(notes = "Insert date of ChapterData", required = false, position = 4)
	private LocalDateTime insertDate;
	
	@ApiModelProperty(notes = "Last update date ChapterData", required = false, position = 5)
	private LocalDateTime updateDate;
	
	@ApiModelProperty(notes = "UserBookAssociation of ChapterData", required = false, position = 6)
	@NotNull
	private BtUserBookAssociationDto userBookAssociation;
	
}
