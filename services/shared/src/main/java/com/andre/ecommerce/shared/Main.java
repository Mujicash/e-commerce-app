package com.andre.ecommerce.shared;

import com.andre.ecommerce.shared.domain.DateValueObject;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DateValueObject birthdate1 = new DateValueObject(LocalDate.of(1995, 6, 15));
        System.out.println("Desde LocalDate: " + birthdate1);

        // Creación desde un String en formato "dd/MM/yyyy"
        DateValueObject birthdate2 = new DateValueObject("15/06/1995");
        System.out.println("Desde String (DTO): " + birthdate2);

        // Acceso a LocalDate
        System.out.println("Birthdate1 value: " + birthdate1.getValue());

        // Conversión a Date (compatibilidad con APIs antiguas)
        System.out.println("Birthdate2 value: " + birthdate2.getValue());

        LocalDate localDate = LocalDate.of(2001, 1, 27);
        System.out.println(localDate);
    }
}