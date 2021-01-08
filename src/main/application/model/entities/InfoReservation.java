package model.entities;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InfoReservation {
    Scanner scanner;
    SimpleDateFormat sdf;

    public InfoReservation() {
        this.scanner = new Scanner(System.in);
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void closeScanner(){
        this.scanner.close();
    }
}
