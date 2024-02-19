import java.util.*;

public class studentmark
{
    public static void main(String args[])
    {
    	
        int marks[] = new int[6];
        int i;
        float total=0, avg;
        Scanner s = new Scanner(System.in);
		
        
        for(i=0; i<6; i++) { 
           System.out.print("Enter Marks of Subject"+(i+1)+":");
           marks[i] = s.nextInt();
           total = total + marks[i];
        }
        System.out.println("total = "+ total);
        avg = total/6;
        System.out.println("average ="+avg);
        System.out.print("The student Grade is: ");
        if(avg>=90)
        {
            System.out.print("A");
        }
        else if(avg>=60 && avg<80)
        {
           System.out.print("B");
        } 
        else if(avg>=40 && avg<60)
        {
            System.out.print("C");
        }
        else
        {
            System.out.print("D");
        }
    }
}
