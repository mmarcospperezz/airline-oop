package org.ies.airline;

import org.ies.airline.components.AirlineApp1;
import org.ies.airline.components.AirlineReader;
import org.ies.airline.components.FlightReader;
import org.ies.airline.components.PassengerReader;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            PassengerReader passengerReader = new PassengerReader(scanner);
            FlightReader flightReader = new FlightReader(scanner, passengerReader);
            AirlineReader airlineReader = new AirlineReader(scanner, flightReader);
            AirlineApp1 airlineApp1 = new AirlineApp1(scanner, airlineReader);

            airlineApp1.run();
        }
}

