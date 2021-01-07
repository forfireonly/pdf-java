package com.giacom;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class App {
    static String[] services = new String[]{"Tyler was assisted with reading books from Epic",
            "Tyler was helped with reading  books from Tarheel reader",
            "Tyler followed along with reading books from Storyjumper",
            "Tyler read along with online story",
            "Tyler read CVC words",
            "Reviewed with Tyler sight words",
            "Practiced with Tyler reading multisyllabic words",
            "Tyler worked on using picture clues to help with his reading",
            "Tyler worked on reading books of his choice",
            "Tyler worked on matching word to the picture"

    };

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void main(String[] args) {

        System.out.println("Enter date");
        Scanner scn = new Scanner(System.in);
        int date = scn.nextInt();
        System.out.println("Enter month");
        int month = scn.nextInt();

        System.out.println("Enter name of the students and dates that student was absent");


        int dateBefore = date - 1;
        int dateTwoDaysBefore = date - 2;
        int dateThreeDaysBefore = date - 3;
        /*need to finish calculation for the other options of the month starting
        int the middle of the week*/

       /* if (date < 4) {
            if (date == 3) {
                if (month == 12 || month == 5 || month == 7 || month == 10) {
                    month = month - 1;
                    dateThreeDaysBefore = 30;
                } else if (month == 3) {
                    month = month - 1;
                    date = 28;
                }
            }
            //the case for the spring 2021
            if (date == 2) {
                if (month == 12 || month == 5 || month == 7 || month == 10) {
                    month = month - 1;
                    dateThreeDaysBefore = 29;
                    dateTwoDaysBefore = 30;
                } else {
                    month = month - 1;
                    dateThreeDaysBefore = 30;
                    dateTwoDaysBefore = 31;
                }
            }

        }*/
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/TylerMorganReadingCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            field.setValue(getRandom(services));
            field = pDAcroForm.getField("txt_6");
            field.setValue(getRandom(services));
            field = pDAcroForm.getField("txt_7");
            field.setValue(getRandom(services));
            field = pDAcroForm.getField("txt_8");
            field.setValue(getRandom(services));
            field = pDAcroForm.getField("txt_4");
            field.setValue(month + "/" + date + "/" + 21);
            field = pDAcroForm.getField("txt_9");
            field.setValue(month + "/" + date + "/" + 21);
            field = pDAcroForm.getField("txt_3");
            field.setValue(month + "/" + dateBefore + "/" + 21);
            field = pDAcroForm.getField("txt_2");
            if (date == 2 && month == 4) {
                month = 3;
                dateTwoDaysBefore = 30;
                dateThreeDaysBefore = 29;
            }
            field.setValue(month + "/" + dateTwoDaysBefore + "/" + 21);
            field = pDAcroForm.getField("txt_1");
            field.setValue(month + "/" + dateThreeDaysBefore + "/" + 21);
            pDDocument.save("/Users/annascott/Downloads/TylerMorganReadingCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
