package com.tuto.service;

import java.util.Arrays;
import java.util.List;

import com.tuto.dto.PetDTO;

public class PetServiceMock implements PetService {

	@Override
	public List<PetDTO> getAll() {
		return Arrays.asList(
				new PetDTO(1, "Mock1", 2, "Comments1"), 
				new PetDTO(2, "Mock2", 4, "Comments2"));
	}

	@Override
	public PetDTO get(int id) {
		return new PetDTO(id, "Mock" + id, id * 2, "Comments" + id);
	}

	@Override
	public PetDTO edit(PetDTO pet) {
		return pet;
	}

	@Override
	public PetDTO create(PetDTO pet) {
		pet.setId(55);

		return pet;
	}

	@Override
	public void remove(int id) {

	}

}
