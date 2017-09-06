package test;

import java.lang.reflect.Method;
import java.util.Map;

import com.parkinglot.domain.Car;
import com.parkinglot.service.ParkingServiceImplementation;

import java.util.HashMap;

public class Commands {
    public Map<String, Method> commandsMap;

    public Commands() {
        commandsMap = new HashMap<String, Method>();
        try {
            populateCommandsHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void populateCommandsHashMap() throws NoSuchMethodException {
        commandsMap.put("create_parking_lot", ParkingServiceImplementation.class.getMethod("createParkingLot", Integer.TYPE));
        commandsMap.put("park", ParkingServiceImplementation.class.getMethod("park", Car.class));
        commandsMap.put("leave", ParkingServiceImplementation.class.getMethod("leave", Integer.TYPE));
        commandsMap.put("status", ParkingServiceImplementation.class.getMethod("status"));
        commandsMap.put("registration_numbers_for_cars_with_colour", ParkingServiceImplementation.class.getMethod("getRegNumWithColor", String.class));
        commandsMap.put("slot_numbers_for_cars_with_colour", ParkingServiceImplementation.class.getMethod("getSlotNumsWithColor", String.class));
        commandsMap.put("slot_number_for_registration_number", ParkingServiceImplementation.class.getMethod("getSlotNumWithRegNum", String.class));
    }
}
