package com.tuto.service;

import java.util.ArrayList;
import java.util.List;

import com.tuto.dto.PetDTO;

public class PetServiceImpl implements PetService {
	private static List<PetDTO> petList = new ArrayList<>();

	static {
		petList.add(new PetDTO(1, "Max", 10, "Stupid Dog"));
		petList.add(new PetDTO(2, "Mike", 5, "Stupid Cat"));
		petList.add(new PetDTO(3, "Jeffrey", 2, "Stupid Monkey"));
		petList.add(new PetDTO(4, "Elvis", 10, "Stupid Donkey"));
	}
	
	@Override
	public List<PetDTO> getAll() {
		return petList;
	}

	@Override
	public PetDTO get(int id) {
		return getPet(id);
	}

	@Override
	public PetDTO edit(PetDTO pet) {
		remove(pet.getId());
		petList.add(pet);
		
		return pet;
	}

	@Override
	public PetDTO create(PetDTO pet) {
		pet.setId(getNewId());
		petList.add(pet);
		
		return pet;
	}

	@Override
	public void remove(int id) {
		PetDTO pet = getPet(id);
		
		if(pet !=null){
			petList.remove(pet);
		}
	}

	
	private PetDTO getPet(int id) {
		for (PetDTO petDTO : petList) {
			if (petDTO.getId() == id) {
				return petDTO;
			}
		}

		return null;
	}
	
	private int getNewId() {
		int maxId = -1;
		for (PetDTO petDTO : petList) {
			maxId = Math.max(maxId, petDTO.getId());
		}

		return maxId + 1;
	}
}
