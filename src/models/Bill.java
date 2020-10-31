package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

public class Bill implements Serializable{

    private static final long serialVersionUID = 7566437190185049076L;
    
    private LocalDate dateBill;
    private Month concept;
    private String name;
    private String number;
    private boolean isPayment;
    private double valueFinal;

    public Bill(LocalDate dateBill, Month concept, String name, String number) {
        this.dateBill = dateBill;
        this.concept = concept;
        this.name = name;
        this.number = number;
    }
   
    public boolean getIsPayment(){
        return isPayment;
    }

    public void payment() {
        this.isPayment = true;
    }

    public double getValueFinal(){
        return valueFinal;
    }

    public Month getConcept(){
        return concept;
    }

     @Override
    public String toString() {
        return "Fecha: " + dateBill + "Concepto: " + concept + ", Propietario: " + name + "# Apartamento: " + number
                + "Valor" + valueFinal;
    }
}