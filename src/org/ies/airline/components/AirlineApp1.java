package org.ies.airline.components;

import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;
import org.ies.airline.model.Passenger;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AirlineApp1 {

    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineApp1(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run(){
        Airline airline = airlineReader.read();

        System.out.println("Introduce el numero del vuelo que se desea buscar:");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        Flight flight = airline.findFlight(flightNumber);

        if (flight == null){
            System.out.println("Este vuelo no existe");
        } else {
            System.out.println("Introduce el NIF del pasajero");
            String nif = scanner.nextLine();
           Passenger passenger = flight.findPassenger(nif);
           if (passenger != null){
               passenger.showInfo();
               System.out.println("Introuduce un numero de asiento");
               int seatNumber = scanner.nextInt();
               scanner.nextLine();
               airline.updateSeatNumber(flightNumber, nif, seatNumber);
           } else {
               System.out.println("No existe el pasajero");
           }
        }


    }
}
