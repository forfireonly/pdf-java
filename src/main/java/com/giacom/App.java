package com.giacom;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class App {
    static String[] servicesTylerReading = new String[]{"Tyler was assisted with reading books from Epic",
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

    static String[] servicesTylerMath = new String[]{"Tyler was assisted with addition problems",
            "Tyler was assisted with substraction problems",
            "Tyler worked on counting by 2,5,10 and multiplicaion by 0 and 1",
            "Tyler worked on using thermometer to tell the temperature",
            "Tyler worked on addition and substraction problems with money",
            "Tyler used pennies to do addition and substraction problems",
            "Tyler counted money using pennies, dimes and nickels",
            "Tyles worked on telling time",
            "Tyler worked on more, less, and equal amounts",
            "Tyler on addition and substraction problems"
    };

    static String[] servicesTylerWriting = new String[]{"Tyler was assisted with writing CVC words",
            "Tyler was assisted with writing multisyllabic words",
            "Tyler was helped with writing sight words in sentences",
            "Tyler worked on using punctuation in sentences",
            "Tyler worked on starting sentences with the capital letter",
            "Tyler wrote CVC words in complete sentences",
            "Tyler wrote multisyllabic words in sentences",
            "Tyler worked on writing complete sentences",
            "Tyler worked on correct punctuation in sentences",
            "Tyler worked on using exclamation point, question mark, and period in sentences"
    };

    static String[] servicesForrestReading = new String[]{"Forrest listen to the stories from Epic",
            "Forrest listen to the stories from StoryJumper",
            "Forrest listen to the stories from Tarheel reader",
            "Forrest listen to the CNN news",
            "Forrest was helped to identify parts of the book",
            "Forrest was working on letters of his name, letters of the days, and letters of the months",
            "Forrestwas listen to books on coming holidays",
            "Forrest listen to the stories about native americans",
            "Forrest listen to the stories from Achive",
            "Forrest listen to the stories from ReadWorks"
    };

    static String[] servicesForrestMath = new String[]{"Forrest was assisted with counting days of the month",
            "Forrest was assisted in counting days of the week",
            "Forrest was assisted with identifying pennies, dimes, nickels, and quarters",
            "Forrest was assisted in counting from the begining of the month to the current day",
            "Forrest worked on concepts of whole, half, quarter",
            "Forrest worked on reading thermometer",
            "Forrest worked on single digit addition",
            "Forrest worked on reading time",
            "Forrest worked on single digit subtraction",
            "Forrest worked measuring with ruler"
    };

    static String[] servicesForrestWriting = new String[] {"Forrest was assisted on tracing his name",
            "Forrest was assisted on spelling his first name",
            "Forrest worked on tracing name of the month",
            "Forrest was assisted with tracing day of the week",
            "Forrest worked on tracing current date",
            "Forrest worked on spelling his last name",
            "Forrest worked on spelling his full name",
            "Forrest was assisted on tracing his full name",
            "Forrest was assisted on tracing numbers from 1 to10",
            "Forrest worked on tracing numbers from 11 to 20"

    };

    static String[] servicesCraig = new String[] {"Craig practiced phonics and work on stories from Achive",
            "Craig practiced phonics and read stories from ReadWorks",
            "Craig worked on stories from Achive",
            "Craig worked on stories from Readworks",
            "Craig read stories and worked on activities from Achive",
            "Craig read stories and worked on activities from ReadWorks",
            "Craig worked on stories from Achive and ReadWorks",
            "Craig completed  activities from Achive",
            "Craig completed activities from ReadWorks",
            "Craig worked on phonics test"

    };

    static String absent = "Student was absent";
    static String holiday = "No school";

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Enter date");
        Scanner scn = new Scanner(System.in);
        int date = scn.nextInt();
        System.out.println("Enter month");
        int month = scn.nextInt();
        scn.nextLine();

        //Tyler
        System.out.println("Enter absenses for Tyler as TU W TH F separated by space");
        String studentDays = scn.nextLine();
        String[] studentDaysArray = studentDays.split(" ");
        List<String> absensesTyler = Arrays.asList(studentDaysArray);

        System.out.println("Enter the day that is off like Tu Wed Th Fr");
        String daysOffString = scn.nextLine();
        String[] daysOffArray = daysOffString.split(" ");
        List<String> daysOff = Arrays.asList(daysOffArray);

        int dateBefore = date - 1;
        int dateTwoDaysBefore = date - 2;
        int dateThreeDaysBefore = date - 3;

        //Tyler reading
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/TylerMorganReadingCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesTyler.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesTyler.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesTyler.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesTyler.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }
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
        File file1 = new File("/Users/annascott/Downloads/TylerMorganReading.pdf");
        File file2 = new File("/Users/annascott/Downloads/TylerMorganReadingCurrent2.pdf");

        //Instantiating PDFMergerUtility class
        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/TylerMorganReadingUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();
        File oldName = new File("/Users/annascott/Downloads/TylerMorganReadingUpdated.pdf");
        File newName = new File("/Users/annascott/Downloads/TylerMorganReading.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();

     //Tyler math
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/TylerMorganMathCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesTyler.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesTyler.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesTyler.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesTyler.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }
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
            pDDocument.save("/Users/annascott/Downloads/TylerMorganMathCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1 = new File("/Users/annascott/Downloads/TylerMorganMath.pdf");
        file2 = new File("/Users/annascott/Downloads/TylerMorganMathCurrent2.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/TylerMorganMathUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();

        file2.deleteOnExit();
        oldName = new File("/Users/annascott/Downloads/TylerMorganMathUpdated.pdf");
        newName = new File("/Users/annascott/Downloads/TylerMorganMath.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();

        //Tyler writing
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/TylerMorganWritingCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesTyler.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesTyler.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesTyler.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesTyler.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }
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
            pDDocument.save("/Users/annascott/Downloads/TylerMorganWritingCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1 = new File("/Users/annascott/Downloads/TylerMorganWriting.pdf");
        file2 = new File("/Users/annascott/Downloads/TylerMorganReadingWriting2.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/TylerMorganWritingUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();
        oldName = new File("/Users/annascott/Downloads/TylerMorganWritingUpdated.pdf");
        newName = new File("/Users/annascott/Downloads/TylerMorganWriting.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();

        //Forrest
        System.out.println("Enter days when Forrest was absent as TU W TH F separated by space");
        studentDays = scn.nextLine();
        studentDaysArray = studentDays.split(" ");
        List<String> absensesForrest = Arrays.asList(studentDaysArray);

        //Forrest reading
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/ForrestCochiseReadingCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesForrest.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesForrest.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesForrest.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesForrest.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }
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
            pDDocument.save("/Users/annascott/Downloads/ForrestCochiseReadingCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1 = new File("/Users/annascott/Downloads/ForrestCochiseReading.pdf");
        file2 = new File("/Users/annascott/Downloads/ForrestCochiseReadingCurrent2.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/ForrestCochiseReadingUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();
        oldName = new File("/Users/annascott/Downloads/ForrestCochiseReadingUpdated.pdf");
        newName = new File("/Users/annascott/Downloads/ForrestCochiseReading.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();

        //Forrest math
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/ForrestCochiseMathCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesForrest.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesForrest.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesForrest.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesForrest.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }
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
            pDDocument.save("/Users/annascott/Downloads/ForrestCochiseMathCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1 = new File("/Users/annascott/Downloads/ForrestCochiseMath.pdf");
        file2 = new File("/Users/annascott/Downloads/ForrestCochiseMathCurrent2.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/ForrestCochiseMathUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();

        file2.deleteOnExit();
        oldName = new File("/Users/annascott/Downloads/ForrestCochiseMathUpdated.pdf");
        newName = new File("/Users/annascott/Downloads/ForrestCochiseMath.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();

        //Forrest writing
        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/ForrestCochiseWritingCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesForrest.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesForrest.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesForrest.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesForrest.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }
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
            pDDocument.save("/Users/annascott/Downloads/ForrestCochiseWritingCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1 = new File("/Users/annascott/Downloads/ForrestCochiseWriting.pdf");
        file2 = new File("/Users/annascott/Downloads/ForrestCochiseReadingWriting2.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/ForrestCochiseWritingUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();
        oldName = new File("/Users/annascott/Downloads/ForrestCochiseWritingUpdated.pdf");
        newName = new File("/Users/annascott/Downloads/ForrestCochiseWriting.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();

        //Craig

        System.out.println("Enter absenses for Craig as TU W TH F separated by space");
        studentDays = scn.nextLine();
        studentDaysArray = studentDays.split(" ");
        List<String> absensesCraig = Arrays.asList(studentDaysArray);

        try {
            PDDocument pDDocument = PDDocument.load(new File("/Users/annascott/Downloads/CraigNotsinnehReadingCurrent.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_5");
            if (absensesCraig.contains("TU")) {
                field.setValue(absent);
            } else if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesCraig));
            }
            field = pDAcroForm.getField("txt_6");
            if (absensesCraig.contains("W")) {
                field.setValue(absent);
            } else if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesCraig));
            }
            field = pDAcroForm.getField("txt_7");
            if (absensesCraig.contains("TH")) {
                field.setValue(absent);
            } else if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesCraig));
            }
            field = pDAcroForm.getField("txt_8");
            if (absensesCraig.contains("F")) {
                field.setValue(absent);
            } else if (daysOff.contains("Fr")) {
                field.setValue(holiday);
            } else {
                field.setValue(getRandom(servicesCraig));
            }
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
            pDDocument.save("/Users/annascott/Downloads/CraigNotsinnehReadingCurrent2.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1 = new File("/Users/annascott/Downloads/CraigNotsinnehReading.pdf");
        file2 = new File("/Users/annascott/Downloads/CraigNotsinnehReadingCurrent2.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("/Users/annascott/Downloads/CraigNotsinnehReadingUpdated.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();
        oldName = new File("/Users/annascott/Downloads/CraigNotsinnehReadingUpdated.pdf");
        newName = new File("/Users/annascott/Downloads/CraigNotsinnehReading.pdf");
        oldName.renameTo(newName);
        oldName.deleteOnExit();



    }
}
