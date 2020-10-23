package models;

import java.time.LocalDate;

public class Bill {

    public static final double PRICE = 75000;
    public static final double LATEPAYMENTAX = 5000;
    private LocalDate dateBill;
    private LocalDate concept;
    private String name;
    private String number;
    private double valueFinal;

    public Bill(LocalDate dateBill, LocalDate concept, String name, String number, double valueFinal) {
        this.dateBill = dateBill;
        this.concept = concept;
        this.name = name;
        this.number = number;
        this.valueFinal = valueFinal;
    }

    public double calculateValueBill(){
        if (LocalDate.now().isBefore(LocalDate.parse("2020-10-"))) {
            
        }

        return valueFinal;
    }

    @Override
    public String toString() {
        return "Bill [dateBill=" + dateBill + ", concept=" + concept + ", name=" + name + ", number=" + number
                + ", valueFinal=" + valueFinal + "]";
    }
}