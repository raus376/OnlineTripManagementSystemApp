package app.trip.controller;

import app.trip.exceptions.AccessDeniedException;
import app.trip.exceptions.InvalidRouteException;
import app.trip.models.Route;
import app.trip.services.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/routes")
@CrossOrigin(origins = "*")
public class RouteController {

	@Autowired
	RouteService routeService;

	@GetMapping("/searchRoute")
	public ResponseEntity<Route> searchRoute(@RequestParam Integer routeId) throws InvalidRouteException {
		Route route = routeService.searchRoute(routeId);

		return new ResponseEntity<Route>(route, HttpStatus.FOUND);
	}

	@GetMapping("/seeAllRoutes")
	public ResponseEntity<List<Route>> viewRouteList() throws InvalidRouteException {
		List<Route> routes = routeService.viewRouteList();

		return new ResponseEntity<List<Route>>(routes, HttpStatus.FOUND);
	}

	/* ADMIN ONLY ACCESS */
	@PostMapping("/addRoute")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route, @RequestParam String authKey) throws AccessDeniedException, InvalidRouteException {
		Route addedRoute = null;

		addedRoute = routeService.addRoute(route, authKey);

		return new ResponseEntity<Route>(addedRoute, HttpStatus.CREATED);
	}

	/* ADMIN ONLY ACCESS */
	@PutMapping("/updateRoute")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route, @RequestParam String authKey) throws InvalidRouteException, AccessDeniedException {
		Route updatedRoute = routeService.updateRoute(route, authKey);

		return new ResponseEntity<Route>(updatedRoute, HttpStatus.OK);
	}

	/* ADMIN ONLY ACCESS */
	@DeleteMapping("/deleteRoute")
	public ResponseEntity<Route> removeRoute(@RequestParam Integer routeId, @RequestParam String authKey) throws InvalidRouteException, AccessDeniedException {
		Route deletedRoute = routeService.removeRoute(routeId, authKey);

		return new ResponseEntity<Route>(deletedRoute, HttpStatus.OK);
	}


}
