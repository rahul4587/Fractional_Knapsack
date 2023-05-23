import java.util.Scanner;
public class FractionalKnapsack
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of items : ");
        int n = in.nextInt();
        double W[] = new double[n];
        double P[] = new double[n];
        System.out.println("Enter the capacity of the knapsack : ");
        double capacity = in.nextDouble();

        System.out.println("Enter the elements - ");
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Profit : ");
            P[i] = in.nextDouble();
            System.out.println("Enter Weight : ");
            W[i] = in.nextDouble();
        }
         double R[] = new double[n];
         for(int i=0;i<n;i++)
         {
            R[i] = P[i] / W[i];
         }

         for(int i=0;i<n;i++)
         {
            for(int j=i+1;j<n;j++)
            {
                if(R[i] < R[j])
                {
                    double t1 = R[i];
                    R[i] = R[j];
                    R[j] = t1;

                    double t2 = P[i];
                    P[i] = P[j];
                    P[j] = t2;

                    double t3 = W[i];
                    W[i] = W[j];
                    W[j] = t3;
                }
            }
         }
        double value = 0.0;
        int j=0;
        double totalCapacity = 0.0;
        
        for(j=0;j<n;j++)
                {
                    if(totalCapacity>=capacity)
                        break;
                    value = value + P[j];
                    totalCapacity = totalCapacity + W[j];
                    capacity=capacity-W[j];
                }
                
                
            value = value + P[j] * (capacity/W[j]);

            System.out.println("Cost = " + value);



    }
}
