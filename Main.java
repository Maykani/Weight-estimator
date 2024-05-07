import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main{
    static double sheep_weight(double HG, double LG){
        double weight = ((HG*0.393701f*HG*0.393701f*LG)/300)*0.4536f;
        return weight;}
    static double goat_weight(double HG, double LG){
        double weight = ((HG*0.393701f*HG*0.393701f*LG)/300)*0.4536f;
        return weight;}
    static double cattle_Shae_weight(double HG, double LG){
        double weight = ((HG*0.393701f*HG*0.393701f*LG)/300)*0.4536f;
        return weight;}
    static double cattle_Agar_weight(double HG, double LG){
        double girth = HG*0.393701f;
        if(girth <65){
            double weight = ((HG*0.393701f*LG)/9.0f)*0.4536f;
            return weight;}
        else if (girth>= 65 && girth <=80){
            double weight =  ((HG*0.393701f*LG)/8.5f)*0.4536f;
            return weight;}
        else if(girth > 80){
            double weight =  ((HG*0.393701f*LG)/8.0f)*0.4536f;
            return weight;}
        else{
            double weight = 0;
            return weight;}
    }
    static double horse_Hap_weight(double HG, double WH, double LG){
        double weight = 0.4536f*(Math.pow(HG*0.393701f, 1.64f)*Math.pow(0.393701f*WH, 0.95f)*Math.pow(0.393701f*LG,0.40f))/278;
        return weight;}
    static double horse_Hunt_weight(double HG, double LG){
        double weight = (HG*HG*LG)/11877f;
        return weight;}
    static double donkey_Pear_weight(double HG, double LG){
        double weight = (Math.pow(HG,2.12f)*Math.pow(LG,0.688f))/3801;
        return weight;}
    static double donkey_Nini_weight(double HG){
        double weight = (Math.pow(HG,2.68f))/2312.44f;
        return weight;}
    

    public static void main(String args []){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the species name:");
        String species = myObj.nextLine();
        System.out.println("Enter animal Chest girth in cm:");
        double HG = myObj.nextDouble();
        System.out.println("Enter animal body length in cm: ");
        double LG = myObj.nextDouble();
        Pattern pattern_sheep = Pattern.compile("sheep", Pattern.CASE_INSENSITIVE);
        Matcher matcher_sheep = pattern_sheep.matcher(species);
        boolean matchfound_sheep = matcher_sheep.find();
        
        Pattern pattern_goat = Pattern.compile("goat", Pattern.CASE_INSENSITIVE);
        Matcher matcher_goat = pattern_goat.matcher(species);
        boolean matchfound_goat = matcher_goat.find();
        
        Pattern pattern_cattle = Pattern.compile("cattle", Pattern.CASE_INSENSITIVE);
        Matcher matcher_cattle = pattern_cattle.matcher(species);
        boolean matchfound_cattle = matcher_cattle.find();
        
        Pattern pattern_horse = Pattern.compile("horse", Pattern.CASE_INSENSITIVE);
        Matcher matcher_horse = pattern_horse.matcher(species);
        boolean matchfound_horse = matcher_horse.find();
        
        Pattern pattern_donkey = Pattern.compile("donkey", Pattern.CASE_INSENSITIVE);
        Matcher matcher_donkey = pattern_donkey.matcher(species);
        boolean matchfound_donkey = matcher_donkey.find();
        
        if(matchfound_sheep){
            System.out.println("Animal weight is: " + Math.round(sheep_weight(HG,LG))+ " kg");}
        else if(matchfound_goat) {
            System.out.println("Animal weight is: " + Math.round(goat_weight(HG,LG))+ " kg");}
        else if (matchfound_cattle){
            System.out.print("Choose a method for weight estimation: 1 for Schaeffer/2 for Agarwal: ");
            int est_method_cattle = myObj.nextInt();
            if(est_method_cattle == 1){
            System.out.println("Animal weight is: " + Math.round(cattle_Shae_weight(HG,LG))+ " kg");}
            else if(est_method_cattle ==2){
                System.out.println("Animal weight is: " + Math.round(cattle_Agar_weight(HG,LG))+ " kg");}
            else{
                System.out.println("Method unavailable");}}
        else if(matchfound_horse){
            System.out.println("Enter a method for weight estimation: 1 for Hapgood/2 for Caroll and Huntington");
            int est_method_horse = myObj.nextInt();
            if(est_method_horse == 1){
                System.out.println("Enter Highest point of the withers in cm: ");
                double WH = myObj.nextDouble();
               
                System.out.println("Animal weight is : " + Math.round(horse_Hap_weight(HG,WH,LG)) + " kg");}
            else if(est_method_horse == 2){
                System.out.println("Animal weight is : " + Math.round(horse_Hunt_weight(HG,LG)) + " kg");}
            else{
                System.out.println("Unavailable method");}}
        
        else if(matchfound_donkey){
            System.out.println("Choose a method of estimation:1 for Pearson et al/2 for Nininahazwe et al");
            int est_method_donkey = myObj.nextInt();
            if(est_method_donkey == 1){
                System.out.println("Animal weight is: " + Math.round(donkey_Pear_weight(HG,LG)) + " kg");
            }
            else if (est_method_donkey == 2){
               System.out.println("Animal weight is : " + Math.round(donkey_Nini_weight(HG)) + " kg");}
            else{
                System.out.println("Unavailable method");}
            }
        else{
            System.out.println("Something went wrong in input values!");}
    
          }
    }
       