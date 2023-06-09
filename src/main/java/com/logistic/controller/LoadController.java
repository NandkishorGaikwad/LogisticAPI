package com.logistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.logistic.entity.Load;
import com.logistic.service.LoadService;

import java.util.List;

@RestController
public class LoadController {
	@Autowired
	private LoadService loadService;

	@PostMapping("/load")
	public ResponseEntity<String> addLoad(@RequestBody Load load) {
		loadService.addLoad(load);
		return ResponseEntity.status(HttpStatus.CREATED).body("Load details added successfully");
	}

	@GetMapping("/load")
	public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam("shipperId") String shipperId) {
		List<Load> loads = loadService.getLoadsByShipperId(shipperId);
		return ResponseEntity.ok(loads);
	}

	@GetMapping("/load/{loadId}")
	public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
		Load load = loadService.getLoadById(loadId);
		if (load != null) {
			return ResponseEntity.ok(load);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/load/{loadId}")
	public ResponseEntity<String> updateLoadById(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
		loadService.updateLoadById(loadId, updatedLoad);
		return ResponseEntity.ok("Load updated successfully");
	}

	@DeleteMapping("/load/{loadId}")
	public ResponseEntity<String> deleteLoadById(@PathVariable Long loadId) {
		loadService.deleteLoadById(loadId);
		return ResponseEntity.ok("Load deleted successfully");
	}
}
