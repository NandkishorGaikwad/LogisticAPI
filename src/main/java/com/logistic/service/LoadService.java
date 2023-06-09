package com.logistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.dao.LoadRepository;
import com.logistic.entity.Load;

import java.util.List;

@Service
public class LoadService {
	@Autowired
	private LoadRepository loadRepository;

	public void addLoad(Load load) {
		loadRepository.save(load);
	}

	public List<Load> getLoadsByShipperId(String shipperId) {
		return loadRepository.findByShipperId(shipperId);
	}

	public Load getLoadById(Long loadId) {
		return loadRepository.findById(loadId).orElse(null);
	}

	public void updateLoadById(Long loadId, Load updatedLoad) {
		Load load = loadRepository.findById(loadId).orElse(null);
		if (load != null) {
			load.setLoadingPoint(updatedLoad.getLoadingPoint());
			load.setUnloadingPoint(updatedLoad.getUnloadingPoint());
			load.setProductType(updatedLoad.getProductType());
			load.setTruckType(updatedLoad.getTruckType());
			load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
			load.setWeight(updatedLoad.getWeight());
			load.setComment(updatedLoad.getComment());
			load.setDate(updatedLoad.getDate());
			loadRepository.save(load);
		}
	}

	public void deleteLoadById(Long loadId) {
		loadRepository.deleteById(loadId);
	}
}
