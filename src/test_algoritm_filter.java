import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Vital on 20.02.2018.
 */
public class test_algoritm_filter {
    public static void main(String[] args) throws IOException{
        String[] _STR;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("new_1.txt"), Charset.forName("UTF-8")));
        String str;
        str = reader.readLine();
        _STR = str.split(", ");

        int[] coeff_H = new int[_STR.length];

        for(int i=0; i<_STR.length; i++){
            coeff_H[i] = Integer.parseInt(_STR[i]);
        }

        reader = new BufferedReader(new InputStreamReader(new FileInputStream("TEST_1000_50HZ.txt"), Charset.forName("UTF-8")));
        str = reader.readLine();
        _STR = str.split(", ");

        int[] signal  = new int[_STR.length];

        for(int i=0; i<_STR.length; i++){
            signal[i] = Integer.parseInt(_STR[i]);
        }

        int[] y = new int[1000];
        for(int z=0; z<y.length; z++){
            y[z] = 0;
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < coeff_H.length; j++) {
                y[i] = y[i] + signal[i+j+1]*coeff_H[j];

            }
            y[i] /= 65536;
        }

        for(int itog: y){
            System.out.println(itog);
        }
    }
}
