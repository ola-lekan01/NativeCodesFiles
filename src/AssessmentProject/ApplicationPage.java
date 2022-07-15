package Chapter7.AssessmentProject;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationPage {
    private static final Scanner input = new Scanner(System.in);

    private static int index;
    static double subTotal = 0;
    private static int fCount = 0;
    private static int pCount = 0;
    private static int eTotal = 0;
    private static int eAverage = 0;
    private static double total = 0;
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> englishGrades = new ArrayList<>();
    static ArrayList<Integer> mathGrades = new ArrayList<>();
    static ArrayList<Integer> economicsGrades = new ArrayList<>();

    public static int getScore() {
        return input.nextInt();
    }

    public static void takingStudentDetails() {
        System.out.println("How Many Students do you have: ");
        int name_length = input.nextInt();

        System.out.println("How Many Subjects do they Offer:");
        int subject_length = input.nextInt();

        for (index = 0; index < name_length; index++){
            System.out.printf("%s%n" , "Enter Student Name Here: ");
            String studentName = input.next();
            names.add(studentName);
        }

        for (index = 0; index < subject_length; index++) {
            System.out.printf("%s%n", "Enter Grade for English : ");
            englishGrades.add(getScore());

            System.out.printf("%s%n", "Enter Grade for Mathematics : ");
            mathGrades.add(getScore());

            System.out.printf("%s%n", "Enter Grade for Economics : ");
            economicsGrades.add(getScore());

        }
        resultPage();
    }

    public static void resultPage() {
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");
        System.out.printf("%-3s %20s %15s %15s %12s %12s %15s %n", "Student", "English", "Mathematics", "Economics ", "Total", "Average", "Position");
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        for (index = 0; index < names.size(); index++) {

            subTotal = englishGrades.get(index) + mathGrades.get(index) + economicsGrades.get(index);

            double average = subTotal / englishGrades.size();

            System.out.printf("%-3s %20d %12d %12d %18.2f %18.2f%n", names.get(index), englishGrades.get(index), mathGrades.get(index), economicsGrades.get(index), subTotal, average);

            total = subTotal + total;
        }
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        subjectSummary();
    }

    public static void subjectSummary() {
        System.out.println("SUBJECT SUMMARY");
        englishSummary();
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        mathSummary();
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        economicsSummary();
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        classSummary();
    }

    public static void englishSummary() {
        System.out.println("ENGLISH");
        for (index = 0; index < englishGrades.size(); index++) {
            eTotal = englishGrades.get(index) + eTotal;
            eAverage = eTotal / englishGrades.size();

            if (englishGrades.get(index) >= 50) {
                pCount++;
            } else {
                fCount++;
            }

        }
        System.out.println("The total Score is: " + eTotal);
        System.out.println("The Average Score is: " + eAverage);
        System.out.println("The Number of passes: " + pCount);
        System.out.println("The Number of fails: " + fCount);
    }

    public static void mathSummary() {
        int mPCount = 0;
        int mFCount = 0;
        System.out.println("Subject 2: Mathematics");

        for (index = 0; index < mathGrades.size(); index++) {
            eTotal = mathGrades.get(index) + eTotal;
            eAverage = eTotal / mathGrades.size();

            if (mathGrades.get(index) >= 50) {
                mPCount++;
            } else {
                mFCount++;
            }
        }
        System.out.println("The total Score is: " + eTotal);
        System.out.println("The Average Score is: " + eAverage);
        System.out.println("The Number of passes: " + mPCount);
        System.out.println("The Number of fails: " + mFCount);

    }


    public static void economicsSummary() {
        int ePCount = 0;
        int eFCount = 0;
        System.out.println("Subject 3: Economics");
        for (index = 0; index < economicsGrades.size(); index++) {
            eTotal = economicsGrades.get(index) + eTotal;
            eAverage = eTotal / economicsGrades.size();

            if (economicsGrades.get(index) >= 50) {
                ePCount++;
            } else {
                eFCount++;
            }
        }
        System.out.println("The total Score is: " + eTotal);
        System.out.println("The Average Score is: " + eAverage);
        System.out.println("The Number of passes: " + ePCount);
        System.out.println("The Number of fails: " + eFCount);
    }

    public static void classSummary() {
        System.out.println("CLASS SUMMARY");
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        System.out.printf("The Overall Best graduating Student is: %s Scoring %.2f%n" ,"Fane" , bestGraduatingStudent());

        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

        System.out.printf("The Overall Worst Graduating student is: %s Scoring %.2f%n " , "Lane" ,worstGraduatingStudent());

        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n%n");

        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");
        System.out.printf("The class total score is: %.2f%n ", total);
        System.out.printf("The Class Average Score is: %.2f%n ", total / names.size());
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n%n");
    }

    public static double worstGraduatingStudent() {
        int minResult = 10000;
        int minTotal;

        for (index = 0; index < englishGrades.size(); index++) {

            minTotal = englishGrades.get(index) + mathGrades.get(index) + economicsGrades.get(index);
            if (minTotal < minResult) {
                minResult = minTotal;
            }
        }
        return minResult;
    }
    public static double bestGraduatingStudent(){
        int maxResult = 0;
        int maxSubTotal;

        for (index = 0; index < englishGrades.size(); index++) {
            maxSubTotal = englishGrades.get(index) + mathGrades.get(index) + economicsGrades.get(index);

            if (maxSubTotal > maxResult) {
                maxResult = maxSubTotal;
            }
        }
        return maxResult;
    }
    public static void hardestSubject(){

    }

}