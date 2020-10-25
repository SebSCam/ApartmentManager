package test;

import java.time.LocalDate;
import java.time.Month;

import models.Administration;
import models.Bill;
import models.ExtraServices;
import models.IDType;

public class TestBill {

    public static void main(String[] args) {
        Administration administration = new Administration();
        administration.payment(new Bill(LocalDate.now(), Month.SEPTEMBER, "Casa 1", "2" ));
        System.out.println(administration.getTotalMoney());
        administration.payServices(ExtraServices.POOL_SERVICE, 20000);
        System.out.println(administration.getTotalMoney());
        administration.payServices(ExtraServices.SCYTHE_SERVICE, 30000);
        System.out.println(administration.getTotalMoney());
    
    }
}
