package org.belon.booktracker.books.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class BtBookSeriesOrder implements Serializable {

	private static final long serialVersionUID = -121340344346838183L;

	private BtBooks book;
	
	private BtSeries serie;
	
	private int order;
}
