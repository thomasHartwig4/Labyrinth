package de.fida.Labyrinth.controller;

import de.fida.Labyrinth.service.MapService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/move")
    private ResponseEntity move(@PathParam("direction") String direction){
        String text = mapService.move(direction);
        return ResponseEntity.ok(text);
    }

    @GetMapping("/refresh")
    private ResponseEntity refresh(@PathParam("mapId") Long mapId){
        mapService.refresh();
        return ResponseEntity.ok("The map has been refreshed");
    }
}
