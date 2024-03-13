package com.example.demo.examen.dragonball;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/dragonball/")
public class Examen2Contoller {
    List<DragonBall> bolasQueYoTengo = new ArrayList<>();
    List<DragonBall> dragonBallsAll = new ArrayList<>();

	@PostConstruct
	public void initDragonBalls() {
		// Agregar las bolas del dragón a dragonBallsAll
		dragonBallsAll.add(new DragonBall("Fuego", 1));
		dragonBallsAll.add(new DragonBall("Agua", 2));
		dragonBallsAll.add(new DragonBall("Aire", 3));
		dragonBallsAll.add(new DragonBall("Tierra", 4));
		dragonBallsAll.add(new DragonBall("Espíritu", 5));
		dragonBallsAll.add(new DragonBall("Tiempo", 6));
		dragonBallsAll.add(new DragonBall("Espacio", 7));
	}

    @GetMapping
    @RequestMapping(value = "/radar")
    public ResponseEntity<List<DragonBall>> getAllDragonBalls() {
		List<DragonBall> dragonBalls = new ArrayList<>(dragonBallsAll);
		dragonBalls.removeAll(bolasQueYoTengo);
        return ResponseEntity.ok(dragonBalls);
    }

    @GetMapping
    @RequestMapping(value = "/owned")
    public ResponseEntity<List<DragonBall>> getMyDragonBalls() {
        return ResponseEntity.ok(bolasQueYoTengo);
    }

    @GetMapping
    @RequestMapping(value = "/get")
	public ResponseEntity<Object> getABall(@RequestParam("ball") int numEstrellas) {
		DragonBall ball = null;
		for (DragonBall db : dragonBallsAll) {
			if (db.getNumEstrellas() == numEstrellas) {
				ball = db;
				break;
			}
		}

		if (ball != null && !bolasQueYoTengo.contains(ball)) {
			bolasQueYoTengo.add(ball);
			dragonBallsAll.remove(ball);
			return ResponseEntity.ok(new FoundResult(ball.getNumEstrellas()));
		} else {
			return ResponseEntity.ok(new NotFoundResult());
		}
	}
}

class FoundResult {
	private int stardots = 0;
	private boolean found = false;

	public FoundResult(int stardots) {
		this.stardots = stardots;
		this.found = true;
	}

	public int getStardots() {
		return stardots;
	}

	public void setStardots(int stardots) {
		this.stardots = stardots;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}
}

class NotFoundResult {
	private int stardots = 0;
	private boolean found = false;

	public NotFoundResult() {
	}

	public int getStardots() {
		return stardots;
	}

	public void setStardots(int stardots) {
		this.stardots = stardots;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}
}



