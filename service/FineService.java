package service;

public class FineService {

    public static int calculateFine(int days,int cost){

        if(days<=15)
            return 0;

        int extra=days-15;
        int fine=0;
        int rate=2;

        for(int i=0;i<extra;i++){
            fine+=rate;

            if((i+1)%10==0)
                rate*=2;
        }

        int max=(int)(0.8*cost);

        if(fine>max)
            fine=max;

        return fine;
    }
}