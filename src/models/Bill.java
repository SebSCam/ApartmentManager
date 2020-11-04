package models;

import java.io.Serializable;
import java.time.LocalDate;
import views.Concept;

public class Bill implements Serializable {

    private static final long serialVersionUID = 7566437190185049076L;

    private LocalDate dateBill;
    private Concept concept;
    private String name;
    private String type;
    private boolean isPayment;
    private double valueFinal;

    public Bill(LocalDate date, Concept object, String name, String type) {
        this.dateBill = date;
        this.concept = object;
        this.name = name;
        this.type = type;
    }

    public boolean getIsPayment() {
        return isPayment;
    }

    public void payment() {
        this.isPayment = true;
    }

    public double getValueFinal() {
        return valueFinal;
    }

    public Concept getConcept() {
        return concept;
    }

    @Override
    public String toString() {
        return "Fecha: " + dateBill + "Concepto: " + concept + ", Propietario: " + name + "# Apartamento: " + type
                + "Valor" + valueFinal;
    }

    public Object[] toObjectVector() {
        return new Object[] { concept, name, dateBill, valueFinal, type };
    }

    public void setAmount(double d) {
        this.valueFinal = d;
    }
}