package de.fida.Labyrinth.service;

import de.fida.Labyrinth.entity.Map;
import de.fida.Labyrinth.repo.MapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    @Autowired
    private MapRepo mapRepo;

    public String move(String direction){
        Map ourMap = mapRepo.findById(13L).get();
        String[] positions = ourMap.getPositions();
        int currentPosition = ourMap.getCurrentPosition();
        if(positions[currentPosition].contains(direction)){
            if (direction.equals("east")){
                currentPosition++;
            }
            if (direction.equals("west")){
                currentPosition--;
            }
            if (direction.equals("north")){
                currentPosition= currentPosition+6;
            }
            if (direction.equals("south")){
                currentPosition= currentPosition+7;
            }
        }
        ourMap.setCurrentPosition(currentPosition);
        mapRepo.save(ourMap);
        return positions[currentPosition];
    }

    public void refresh(){
        Map ourMap;
        if (mapRepo.findById(13L).isPresent()){
            ourMap = mapRepo.findById(13L).get();
        } else {
            ourMap = new Map();
            ourMap.setMapId(13L);
        }

        String[] positions = ourMap.getPositions();
        positions[0] = "This is a start location, you can start your Journey from here, the only way leads east, into the mountains";
        positions[1] = "east, west, south";
        positions[2] = "east, west";
        positions[3] = "north, east, west";
        positions[4] = "east, west";
        positions[5] = "east, west, south";
        positions[6] = "east west";
        positions[7] = "north, west";

        positions[8] = "todo";
        positions[9] = "todo";

        positions[10] = "todo";

        positions[11] = "todo";
        positions[12] = "todo";

        positions [13] = "todo";

        ourMap.setCurrentPosition(0);

        ourMap.setTreasureFound(false);
        ourMap.setDangerDefeated(false);
        ourMap.setWeaponFound(false);
        ourMap.setKeyFound(false);
        ourMap.setDorOpened(false);
        ourMap.setTrapCodeSolved(false);

        ourMap.setPositions(positions);
        mapRepo.save(ourMap);
    }

    private String[] mixUp(){
        return null;
    }
}
