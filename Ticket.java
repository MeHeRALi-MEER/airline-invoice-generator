import java.util.Scanner;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.Desktop;

public class Ticket{
    static int array_lenght;
    static int index;

    public static void readFile(){
        try {
            Scanner read = new Scanner(new File("files/index.txt"));
            if (read.hasNextInt()) {
                array_lenght = read.nextInt();
                read.nextLine();
            }
            read.close();
            index = array_lenght-1;
            //System.out.println("Reading index.txt successful.");
            //System.out.println("Array Length is:" + array_lenght);
            //System.out.println("Index: "+ index);
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }
   
    public static void readValues(int[] array,int index, String file_name){
        try {
            Scanner read = new Scanner(new File(file_name));
            for (int i = 0; i < index; i++) {
                if (read.hasNextInt()) {
                    array[i] = read.nextInt();
                    read.nextLine();
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void readValues(long[] array,int index, String file_name){
        try {
            Scanner read = new Scanner(new File(file_name));
            for (int i = 0; i < index; i++) {
                if (read.hasNextLong()) {
                    array[i] = read.nextLong();
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void readValues(float[] array,int index, String file_name){
        try {
            Scanner read = new Scanner(new File(file_name));
            for (int i = 0; i < index; i++) {
                if (read.hasNextFloat()) {
                    array[i] = read.nextFloat();
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void readValues(String[] array,int index, String file_name){
        try {
            Scanner read = new Scanner(new File(file_name));
            for (int i = 0; i < index; i++) {
                if (read.hasNextLine()) {
                    array[i] = read.nextLine();
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }
    
    static int base_price;
    static float tax_percentage;
    static float discount_percentage = 0.05f;

    static Scanner scan = new Scanner(System.in);

    public static void selectGender(String[] gender,int index){
        String gen = null;
        while (true) {
            System.out.println("Select Gender:\n[M] Male\n[F] Female\n[O] Other");
            char g = scan.next().toLowerCase().charAt(0);
            scan.nextLine();
            if (g == 'm') {
                gen = "Male";
                break;
            } else if (g == 'f') {
                gen = "Female";
                break;
            } else if (g == 'o') {
                gen = "Other";
                break;
            } else {
                System.out.println("Invalid Input!");
                continue;
            }
        }
        gender[index] = gen;
    }

    public static void selectClass(String[] clas,int[] int_clas, int index){
        String cls = null;
        int cs;
        while (true) {
            System.out.println("Select Class:\n[B] Business\n[E] Economy");
            char c = scan.next().toLowerCase().charAt(0);
            scan.nextLine();
            if (c == 'b') {
                cls = "Business";
                cs = 0;
                break;
            } else if (c == 'e'){
                cls = "Economy";
                cs = 1;
                break;
            } else {
                System.out.println("Invalid Input!");
                continue;
            }
        }
        clas[index] = cls;
        int_clas[index] = cs;
    }

    public static void setPriceTax(int clas){
        if (clas == 0) {
            base_price = 120000;
            tax_percentage = 0.25f;
        } else if (clas == 1) {
            base_price = 80000;
            tax_percentage = 0.15f;
        }
    }

    public static float calculateTaxOrDiscount(int price,float multiplier){
       return price*multiplier;
    }

    public static float getTotal(float price, float tax, float discount,float extra){
        return (price+(price*tax)-(price*discount)+extra);
    }

    public static float calculateExtraWeightCharges(float weight){
        float extra_charges = 0;
        if (weight > 40) {
            extra_charges = (weight-40)*1000;
        }
        return extra_charges;
    }

    public static void getTicket(int index,int[] ticket_id,String[] flight_id,String[] name,long[] cnic,int[] age, String[] gender, String[] clas,int[] int_clas, int[] seat, String[] departure, String[] destination, float[] luggage, long[] phone, String[] date, String[] time){
        ticket_id[index] = (array_lenght);
        System.out.print("Enter Flight ID: ");
        flight_id[index] =scan.nextLine();
        System.out.print("Enter the passenger name: ");
        name[index] =scan.nextLine();
        System.out.print("Enter the CNIC: ");
        cnic[index] =scan.nextLong();
        System.out.print("Enter the passenger age: ");
        age[index] =scan.nextInt();
        scan.nextLine();
        selectGender(gender, index);
        selectClass(clas, int_clas, index);
        System.out.print("Enter the seat number: ");
        seat[index] =scan.nextInt();
        scan.nextLine();
        System.out.print("Enter the departure city: ");
        departure[index] =scan.nextLine();
        System.out.print("Enter the destination city: ");
        destination[index] =scan.nextLine();
        System.out.print("Enter luggage weight: ");
        luggage[index] =scan.nextFloat();
        System.out.print("Enter the phone number: ");
        phone[index] =scan.nextLong();
        //System.out.println("seat:"+seat[index]);
        //System.out.println("intclas:"+int_clas[index]);
        LocalDate now = LocalDate.now();
        date[index] = now.toString();
        LocalTime noow = LocalTime.now();
        time[index] = noow.toString();
    }

    public static void printTicket(int index,int[] ticket_id,String[] flight_id,String[] name,long[] cnic,int[] age, String[] gender, String[] clas,int[] int_clas, int[] seat, String[] departure, String[] destination, float[] luggage, long[] phone, String[] date, String[] time){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------PIA AIRLINES---------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Ticket ID \t Flight ID \t Name \t\t CNIC \t\t Age \t Gender    Date \t Departure \t Destination \t Class \t Time \t Phone Number \t Seat Number");
        System.out.println(ticket_id[index] + "\t\t " + flight_id[index] + "\t\t" + name[index] + "\t" + cnic[index] + "\t" + age[index] + "\t" + gender[index] + " \t " + date[index] + "\t" + departure[index] + "\t" + destination[index] + " \t " + clas[index] + "\t" + time[index] + "\t" + phone[index] + "\t" + seat[index]);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        setPriceTax(int_clas[index]);
        System.out.println("\t\t\t     Base Amount: " + base_price);
        System.out.println("\t\t\t      Tax Amount: " + calculateTaxOrDiscount(base_price, tax_percentage));
        System.out.println("\t\t\t Discount Amount: " + calculateTaxOrDiscount(base_price, discount_percentage));
        System.out.println("\t\t\t    Extra Charge: " + calculateExtraWeightCharges(luggage[index]));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t     Total Price: " + getTotal(base_price, tax_percentage, discount_percentage,calculateExtraWeightCharges(luggage[index])));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public static void writeFile(int index){
        try {
            FileWriter file = new FileWriter("files/index.txt");
            int toWrite = index+2;
            file.append(Integer.toString(toWrite));
            file.append("\n");
            file.close();
            //System.out.println("Successfully wrote "+toWrite+" to the index.txt");
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void writeValues(int[] array,int index, String file_name){
        try {
            FileWriter file = new FileWriter(file_name);
            for (int i = 0; i<= index; i++) {
                file.append(array[i] + "\n");
            }
            file.close();
            //System.out.println("wrote "+array[index]+" to "+file_name);
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void writeValues(long[] array,int index, String file_name){
        try {
            FileWriter file = new FileWriter(file_name);
            for (int i = 0; i<= index; i++) {
                file.append(Long.toString(array[i]) + "\n");
            }
            file.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void writeValues(float[] array,int index, String file_name){
        try {
            FileWriter file = new FileWriter(file_name);
            for (int i = 0; i<= index; i++) {
                file.append(Float.toString(array[i]) + "\n");
            }
            file.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    public static void writeValues(String[] array,int index, String file_name){
        try {
            FileWriter file = new FileWriter(file_name);
            for (int i = 0; i<= index; i++) {
                file.append(array[i] + "\n");
            }
            file.close();
        } catch (Exception e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }
    
    public static void readFromFiles(int[] ticket_id,String[] flight_id,String[] name,long[] cnic,int[] age, String[] gender, String[] clas,int[] int_clas, int[] seat, String[] departure, String[] destination, float[] luggage, long[] phone, String[] date, String[] time){
        readValues(ticket_id, index,"files/ticket_id.txt");
        readValues(age, index, "files/age.txt");
        readValues(seat, index, "files/seat.txt");
        readValues(cnic, index, "files/cnic.txt");
        readValues(phone, index, "files/phone.txt");
        readValues(luggage, index, "files/luggage.txt");
        readValues(flight_id, index, "files/flight_id.txt");
        readValues(name, index, "files/name.txt");
        readValues(gender, index, "files/gender.txt");
        readValues(clas, index, "files/clas.txt");
        readValues(int_clas, index, "files/int_clas.txt");
        readValues(departure, index, "files/departure.txt");
        readValues(destination, index, "files/destination.txt");
        readValues(date, index, "files/date.txt");
        readValues(time, index, "files/time.txt");
    }

    public static void writeToFiles(int[] ticket_id,String[] flight_id,String[] name,long[] cnic,int[] age, String[] gender, String[] clas,int[] int_clas, int[] seat, String[] departure, String[] destination, float[] luggage, long[] phone, String[] date, String[] time){
        writeValues(ticket_id, index,"files/ticket_id.txt");
        writeValues(age, index, "files/age.txt");
        writeValues(seat, index, "files/seat.txt");
        writeValues(cnic, index, "files/cnic.txt");
        writeValues(phone, index, "files/phone.txt");
        writeValues(luggage, index, "files/luggage.txt");
        writeValues(flight_id, index, "files/flight_id.txt");
        writeValues(name, index, "files/name.txt");
        writeValues(gender, index, "files/gender.txt");
        writeValues(clas, index, "files/clas.txt");
        writeValues(int_clas, index, "files/int_clas.txt");
        writeValues(departure, index, "files/departure.txt");
        writeValues(destination, index, "files/destination.txt");
        writeValues(date, index, "files/date.txt");
        writeValues(time, index, "files/time.txt");
    }

    public static void generatePdf(int index,int[] ticket_id,String[] flight_id,String[] name,long[] cnic,int[] age, String[] gender, String[] clas,int[] int_clas, int[] seat, String[] departure, String[] destination, float[] luggage, long[] phone, String[] date, String[] time) throws Exception {
        File file = new File("outputs/Template.pdf");
        PDDocument pdf = Loader.loadPDF(file);
        PDPage page = pdf.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(pdf, page, PDPageContentStream.AppendMode.APPEND, true);
        PDType1Font font = new PDType1Font(Standard14Fonts.FontName.COURIER);

        int[] linexx = {145,167,106,116,103,103,90,165,235,290,380,480,420,420,420,420,420,420,420};
        int[] lineyy = {692,645,620,595,570,545,430,430,430,430,430,430,333,306,278,250,222,196,168};
        float[] c1 = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
        float[] c2 = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
        float[] c3 = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
        setPriceTax(int_clas[index]);
        String taxp = Float.toString(tax_percentage*100);
        taxp = taxp +"%";
        String disp = Float.toString(discount_percentage*100);
        disp = disp + "%";
        String[] text = {Integer.toString(ticket_id[index]),name[index],Long.toString(cnic[index]),gender[index],date[index],time[index],flight_id[index],clas[index],Integer.toString(seat[index]),departure[index],destination[index],Float.toString(luggage[index]),Integer.toString(base_price),taxp,Float.toString(calculateTaxOrDiscount(base_price, tax_percentage)),Float.toString(getTotal(base_price, tax_percentage, 0.0f, 0.0f)),disp,Float.toString(calculateTaxOrDiscount(base_price, discount_percentage)),Float.toString(getTotal(base_price, tax_percentage, discount_percentage,0.05f))};
        for (int i = 0; i < text.length; i++) {
            writeToPdf(contentStream, 12.0f, linexx[i], lineyy[i], font, text[i], c1[i], c2[i], c3[i]);
            //System.out.println("write successful!"+text[i]);
        }
        
        contentStream.close();
        //String dname = " "+Integer.toString(ticket_id[index]) +" "+ date[index] + time[index]+".pdf";
        //File ofile = new File(dname);
        //ofile.createNewFile();
        pdf.save("Ivoice.pdf");
        pdf.close();
        Desktop.getDesktop().open(new File("Ivoice.pdf"));
    }

    public static void writeToPdf(PDPageContentStream contentStream,float font_size,int linex,int liney,PDType1Font font,String text, float c1, float c2, float c3) throws Exception {
        contentStream.beginText();  
        contentStream.setFont(font, font_size);
        contentStream.newLineAtOffset( linex, liney);  
        //contentStream.setNonStrokingColor(c1,c2,c3);
        contentStream.showText(text);  
        contentStream.endText();  
    }

    public static void main(String[] args) throws Exception {
        
        System.out.println("<--- Menu --->");
        while (true) {
            readFile();
            
            int[] ticket_id = new int[array_lenght];
            int[] age = new int[array_lenght];
            int[] seat = new int[array_lenght];
            long[] cnic = new long[array_lenght];
            long[] phone = new long[array_lenght];
            float[] luggage = new float[array_lenght];
            String[] flight_id = new String[array_lenght];
            String[] name = new String[array_lenght];
            String[] gender = new String[array_lenght];
            String[] clas = new String[array_lenght];
            int[] int_clas = new int[array_lenght];
            String[] departure = new String[array_lenght];
            String[] destination = new String[array_lenght];
            String[] date = new String[array_lenght];
            String[] time = new String[array_lenght];
            
            readFromFiles(ticket_id, flight_id, name, cnic, age, gender, clas,int_clas, seat, departure, destination, luggage, phone, date, time);
            System.out.println("[1]-Generate new ticket\n[2]-Show previously generated ticket \n[3]-Back to main menu\n[4]-Quit");
            int menu = scan.nextInt();
            scan.nextLine();
            switch(menu){
                case 1:
                    getTicket(index, ticket_id, flight_id, name, cnic, age, gender, clas,int_clas, seat, departure, destination, luggage, phone, date, time);
                    printTicket(index, ticket_id, flight_id, name, cnic, age, gender, clas,int_clas, seat, departure, destination, luggage, phone, date, time);
                    generatePdf(index, ticket_id, flight_id, name, cnic, age, gender, clas, int_clas, seat, departure, destination, luggage, phone, date, time);
                    writeToFiles(ticket_id, flight_id, name, cnic, age, gender, clas, int_clas,seat, departure, destination, luggage, phone, date, time);
                    writeFile(index);
                    System.out.println("What do you want now?");
                    continue;
                
                case 2:
                    while (true) {
                        System.out.println("Select one of following Tickets:");
                        for (int i = 0; i < index; i++) {
                            System.out.println("["+(i+1)+"]-Ticket No: "+ticket_id[i]+" generated on "+date[i]+" at "+time[i]);
                        }
                        int x = scan.nextInt();
                        scan.nextLine();
                        x -= 1;
                        if (x>=0 && x<index) {
                            printTicket(x, ticket_id, flight_id, name, cnic, age, gender, clas,int_clas, seat, departure, destination, luggage, phone, date, time);
                            generatePdf(x, ticket_id, flight_id, name, cnic, age, gender, clas, int_clas, seat, departure, destination, luggage, phone, date, time);
                        } else {
                            System.out.println("Invalid Input!");
                            continue;
                        }
                        break;
                    }
                    break;
                    

                case 3:
                    Assignment4.main(args);
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input!");
                    continue;
            }
        }
    }
}
