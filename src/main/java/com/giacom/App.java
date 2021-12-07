package com.giacom;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class App {


    static String[] servicesTylerReading = new String[]{"Tyler was assisted with reading books from Epic",
            "Tyler was helped with reading  books from Tarheel reader",
            "Tyler followed along with reading books from Storyjumper",
            "Tyler read along with online story",
            "Tyler read CVC words",
            "Reviewed with Tyler sight words",
            "Practiced with Tyler reading multi-syllabic words",
            "Tyler worked on using picture clues to help with his reading",
            "Tyler worked on reading books of his choice",
            "Tyler worked on matching word to the picture"

    };

    static String[] servicesTylerMath = new String[]{"Tyler was assisted with addition problems",
            "Tyler was assisted with subtraction problems",
            "Tyler worked on counting by 2,5,10 and multiplication by 0 and 1",
            "Tyler worked on using thermometer to tell the temperature",
            "Tyler worked on addition and subtraction problems with money",
            "Tyler used pennies to do addition and subtraction problems",
            "Tyler counted money using pennies, dimes and nickels",
            "Tyler worked on telling time",
            "Tyler worked on more, less, and equal amounts",
            "Tyler on addition and subtraction problems"
    };

    static String[] servicesTylerWriting = new String[]{"Tyler was assisted with writing CVC words",
            "Tyler was assisted with writing multi-syllabic words",
            "Tyler was helped with writing sight words in sentences",
            "Tyler worked on using punctuation in sentences",
            "Tyler worked on starting sentences with the capital letter",
            "Tyler wrote CVC words in complete sentences",
            "Tyler wrote multi-syllabic words in sentences",
            "Tyler worked on writing complete sentences",
            "Tyler worked on correct punctuation in sentences",
            "Tyler worked on using punctuation"
    };

    public static String br = System.getProperty("line.separator");

    static String modificationsTyler = br + "Test/Assignments modifications: extra time to complete, shorten the assignment/Test," + br + "frequent breaks, assist with reading, provide pictures for concepts," + br + "provide songs as concepts, repeating instructions";

    static String[] servicesForrestReading = new String[]{"Forrest listen to the stories from Epic",
            "Forrest listen to the stories from StoryJumper",
            "Forrest listen to the stories from Tarheel reader",
            "Forrest listen to the CNN news",
            "Forrest was helped to identify parts of the book",
            "Forrest worked on letters in his name",
            "Forrest was listen to books on coming holidays",
            "Forrest listen to the stories about native americans",
            "Forrest listen to the stories from Achieve",
            "Forrest listen to the stories from ReadWorks"
    };

    static String[] servicesForrestMath = new String[]{"Forrest counted days of the month",
            "Forrest was assisted in counting days of the week",
            "Forrest worked with  pennies, dimes, nickels, and quarters",
            "Forrest counted days to the current date",
            "Forrest worked on concepts of whole, half, quarter",
            "Forrest worked on reading thermometer",
            "Forrest worked on single digit addition",
            "Forrest worked on reading time",
            "Forrest worked on single digit subtraction",
            "Forrest worked measuring with ruler"
    };

    static String[] servicesForrestWriting = new String[]{"Forrest was assisted on tracing his name",
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

    static String modificationsForrest = br + "Test/assignment modifications: Extra time, frequent repetition of instruction, modulating the voice while delivering instructions," + br + "using music while delivering instructions";

    static String absent = "Student was absent";
    static String holiday = "No school";

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Enter date like this 2021 12 3");
        Scanner scn = new Scanner(System.in);

        String dateString = scn.nextLine();

        String[] dateArray = dateString.split(" ");

        LocalDate dateFriday = LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));

        LocalDate dateThursday = dateFriday.minusDays(1);
        LocalDate dateWednesday = dateFriday.minusDays(2);
        LocalDate dateTuesday = dateFriday.minusDays(3);
        LocalDate dateMonday = dateFriday.minusDays(4);

        System.out.println("Enter absenses for Tyler as TU W TH M separated by space");
        String studentDays = scn.nextLine();
        String[] studentDaysArray = studentDays.split(" ");
        List<String> absensesTyler = Arrays.asList(studentDaysArray);

        System.out.println("Enter absenses for Forrest as TU W TH M separated by space");
        studentDays = scn.nextLine();
        studentDaysArray = studentDays.split(" ");
        List<String> absensesForrest = Arrays.asList(studentDaysArray);

        System.out.println("Enter the day that is off like Tu Wed Th Mon");
        String daysOffString = scn.nextLine();
        String[] daysOffArray = daysOffString.split(" ");
        List<String> daysOff = Arrays.asList(daysOffArray);


        System.out.println("Is this a new quarter? ANSWER IN CAPITALS YES/NO");
        String answer = scn.nextLine();


        //Tyler reading
        try {
            PDDocument pDDocument = PDDocument.load(new File("C:/Users/workw/SpedLogs/TylerMorganReadingCurrent2.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("date_Mon");
            field.setValue(dateMonday.toString());

            field = pDAcroForm.getField("date_Tue");
            field.setValue(dateTuesday.toString());

            field = pDAcroForm.getField("date_Wed");
            field.setValue(dateWednesday.toString());

            field = pDAcroForm.getField("date_Th");
            field.setValue(dateThursday.toString());

            field = pDAcroForm.getField("date_Fr");
            field.setValue(dateFriday.toString());

            field = pDAcroForm.getField("log_Mon");

            if (daysOff.contains("Mon")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("MON")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }

            field = pDAcroForm.getField("log_Tue");
            if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("TU")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }

            field = pDAcroForm.getField("log_Wed");
            if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("W")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }

            field = pDAcroForm.getField("log_Th");
            if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("TH")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerReading));
            }

            pDDocument.save("C:/Users/workw/SpedLogs/TylerMorganReadingCurrent3.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String quarter = "";
        //New Quarter
        if (answer.equals("YES")) {

            PDDocument document = new PDDocument();

            //Saving the document
            document.save("C:/Users/workw/SpedLogs/Current/TylerMorganReading.pdf");
            document.close();


        }
        File file1 = new File("C:/Users/workw/SpedLogs/Current/TylerMorganReading.pdf");
        File file2 = new File("C:/Users/workw/SpedLogs/TylerMorganReadingCurrent3.pdf");

        //Instantiating PDFMergerUtility class
        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:/Users/workw/SpedLogs/Current/TylerMorganReading.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();


        //Tyler math
        try {
            PDDocument pDDocument = PDDocument.load(new File("C:/Users/workw/SpedLogs/TylerMorganMathCurrent2.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("date_Mon");
            field.setValue(dateMonday.toString());

            field = pDAcroForm.getField("date_Tue");
            field.setValue(dateTuesday.toString());

            field = pDAcroForm.getField("date_Wed");
            field.setValue(dateWednesday.toString());

            field = pDAcroForm.getField("date_Th");
            field.setValue(dateThursday.toString());

            field = pDAcroForm.getField("date_Fr");
            field.setValue(dateFriday.toString());

            field = pDAcroForm.getField("log_Mon");

            if (daysOff.contains("Mon")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("MON")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }

            field = pDAcroForm.getField("log_Tue");
            if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("TU")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }

            field = pDAcroForm.getField("log_Wed");
            if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("W")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }

            field = pDAcroForm.getField("log_Th");
            if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("TH")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerMath));
            }

            pDDocument.save("C:/Users/workw/SpedLogs/TylerMorganMathCurrent3.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //New Quarter
        if (answer.equals("YES")) {

            PDDocument document = new PDDocument();

            //Saving the document
            document.save("C:/Users/workw/SpedLogs/Current/TylerMorganMath.pdf");
            document.close();


        }
        file1 = new File("C:/Users/workw/SpedLogs/Current/TylerMorganMath.pdf");
        file2 = new File("C:/Users/workw/SpedLogs/TylerMorganMathCurrent3.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:/Users/workw/SpedLogs/Current/TylerMorganMath.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();

        //Tyler writing
        try {
            PDDocument pDDocument = PDDocument.load(new File("C:/Users/workw/SpedLogs/TylerMorganWritingCurrent2.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("date_Mon");
            field.setValue(dateMonday.toString());

            field = pDAcroForm.getField("date_Tue");
            field.setValue(dateTuesday.toString());

            field = pDAcroForm.getField("date_Wed");
            field.setValue(dateWednesday.toString());

            field = pDAcroForm.getField("date_Th");
            field.setValue(dateThursday.toString());

            field = pDAcroForm.getField("date_Fr");
            field.setValue(dateFriday.toString());

            field = pDAcroForm.getField("log_Mon");

            if (daysOff.contains("Mon")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("MON")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }

            field = pDAcroForm.getField("log_Tue");
            if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("TU")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }

            field = pDAcroForm.getField("log_Wed");
            if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("W")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }

            field = pDAcroForm.getField("log_Th");
            if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else if (absensesTyler.contains("TH")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesTylerWriting));
            }

            pDDocument.save("C:/Users/workw/SpedLogs/TylerMorganWritingCurrent3.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //New Quarter
        if (answer.equals("YES")) {

            PDDocument document = new PDDocument();

            //Saving the document
            document.save("C:/Users/workw/SpedLogs/Current/TylerMorganWriting.pdf");
            document.close();


        }
        file1 = new File("C:/Users/workw/SpedLogs/Current/TylerMorganWriting.pdf");
        file2 = new File("C:/Users/workw/SpedLogs/TylerMorganWritingCurrent3.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:/Users/workw/SpedLogs/Current/TylerMorganWriting.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();

        //Forrest reading
        try {
            PDDocument pDDocument = PDDocument.load(new File("C:/Users/workw/SpedLogs/ForrestCochiseReadingCurrent2.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("date_Mon");
            field.setValue(dateMonday.toString());

            field = pDAcroForm.getField("date_Tue");
            field.setValue(dateTuesday.toString());

            field = pDAcroForm.getField("date_Wed");
            field.setValue(dateWednesday.toString());

            field = pDAcroForm.getField("date_Th");
            field.setValue(dateThursday.toString());

            field = pDAcroForm.getField("date_Fr");
            field.setValue(dateFriday.toString());

            field = pDAcroForm.getField("log_Mon");

            if (daysOff.contains("Mon")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("MON")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }

            field = pDAcroForm.getField("log_Tue");
            if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("TU")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }

            field = pDAcroForm.getField("log_Wed");
            if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("W")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }

            field = pDAcroForm.getField("log_Th");
            if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("TH")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestReading));
            }

            pDDocument.save("C:/Users/workw/SpedLogs/ForrestCochiseReadingCurrent3.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //New Quarter
        if (answer.equals("YES")) {

            PDDocument document = new PDDocument();

            //Saving the document
            document.save("C:/Users/workw/SpedLogs/Current/ForrestCochiseReading.pdf");
            document.close();


        }
        file1 = new File("C:/Users/workw/SpedLogs/Current/ForrestCochiseReading.pdf");
        file2 = new File("C:/Users/workw/SpedLogs/ForrestCochiseReadingCurrent3.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:/Users/workw/SpedLogs/Current/ForrestCochiseReading.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();

        //Forrest math

        try {
            PDDocument pDDocument = PDDocument.load(new File("C:/Users/workw/SpedLogs/ForrestCochiseMathCurrent2.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("date_Mon");
            field.setValue(dateMonday.toString());

            field = pDAcroForm.getField("date_Tue");
            field.setValue(dateTuesday.toString());

            field = pDAcroForm.getField("date_Wed");
            field.setValue(dateWednesday.toString());

            field = pDAcroForm.getField("date_Th");
            field.setValue(dateThursday.toString());

            field = pDAcroForm.getField("date_Fr");
            field.setValue(dateFriday.toString());

            field = pDAcroForm.getField("log_Mon");

            if (daysOff.contains("Mon")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("MON")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }

            field = pDAcroForm.getField("log_Tue");
            if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("TU")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }

            field = pDAcroForm.getField("log_Wed");
            if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("W")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }

            field = pDAcroForm.getField("log_Th");
            if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("TH")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestMath));
            }

            pDDocument.save("C:/Users/workw/SpedLogs/ForrestCochiseMathCurrent3.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //New Quarter
        if (answer.equals("YES")) {

            PDDocument document = new PDDocument();

            //Saving the document
            document.save("C:/Users/workw/SpedLogs/Current/ForrestCochiseMath.pdf");
            document.close();


        }
        file1 = new File("C:/Users/workw/SpedLogs/Current/ForrestCochiseMath.pdf");
        file2 = new File("C:/Users/workw/SpedLogs/ForrestCochiseMathCurrent3.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:/Users/workw/SpedLogs/Current/ForrestCochiseMath.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();

        //Forrest writing

        try {
            PDDocument pDDocument = PDDocument.load(new File("C:/Users/workw/SpedLogs/ForrestCochiseWritingCurrent2.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("date_Mon");
            field.setValue(dateMonday.toString());

            field = pDAcroForm.getField("date_Tue");
            field.setValue(dateTuesday.toString());

            field = pDAcroForm.getField("date_Wed");
            field.setValue(dateWednesday.toString());

            field = pDAcroForm.getField("date_Th");
            field.setValue(dateThursday.toString());

            field = pDAcroForm.getField("date_Fr");
            field.setValue(dateFriday.toString());

            field = pDAcroForm.getField("log_Mon");

            if (daysOff.contains("Mon")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("MON")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }

            field = pDAcroForm.getField("log_Tue");
            if (daysOff.contains("Tu")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("TU")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }

            field = pDAcroForm.getField("log_Wed");
            if (daysOff.contains("Wed")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("W")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }

            field = pDAcroForm.getField("log_Th");
            if (daysOff.contains("Th")) {
                field.setValue(holiday);
            } else if (absensesForrest.contains("TH")) {
                field.setValue(absent);
            } else {
                field.setValue(getRandom(servicesForrestWriting));
            }

            pDDocument.save("C:/Users/workw/SpedLogs/ForrestCochiseWritingCurrent3.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //New Quarter
        if (answer.equals("YES")) {

            PDDocument document = new PDDocument();

            //Saving the document
            document.save("C:/Users/workw/SpedLogs/Current/ForrestCochiseWriting.pdf");
            document.close();


        }
        file1 = new File("C:/Users/workw/SpedLogs/Current/ForrestCochiseWriting.pdf");
        file2 = new File("C:/Users/workw/SpedLogs/ForrestCochiseWritingCurrent3.pdf");

        //Instantiating PDFMergerUtility class
        PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:/Users/workw/SpedLogs/Current/ForrestCochiseWriting.pdf");

        //adding the source files
        PDFmerger.addSource(file1);
        PDFmerger.addSource(file2);

        //Merging the two documents
        PDFmerger.mergeDocuments();
        file2.deleteOnExit();
    }
}