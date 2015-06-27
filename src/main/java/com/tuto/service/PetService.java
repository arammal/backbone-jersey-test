package com.tuto.service;

import java.util.List;

import com.tuto.dto.PetDTO;

public interface PetService {

	List<PetDTO> getAll();

	PetDTO get(int id);

	PetDTO edit(PetDTO pet);

	PetDTO create(PetDTO pet);

	void remove(int id);

}
