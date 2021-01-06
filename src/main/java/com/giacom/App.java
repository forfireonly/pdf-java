package com.giacom;

import java.io.File;
import java.io.IOException;
import java.util.Random;

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
            pDDocument.save("/Users/annascott/Downloads/TylerMorganReadingCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
