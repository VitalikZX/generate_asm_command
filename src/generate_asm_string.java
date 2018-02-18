import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vital on 18.02.2018.
 */
public class generate_asm_string {
    public static void main(String[] args) throws IOException{
        try(FileWriter writer = new FileWriter("function.txt", false)) {


            writer.write("void function(void){\n");
            writer.write("    data_counter  = 2000;\n");
            writer.write("    coeff_counter = 8000;\n\n");
            writer.write("    for(int i = 1750; i < 4000; i++){\n");
            writer.write("      asm volatile (\"mov (_data_counter + i*2), w8 \");\n");
            writer.write("      asm volatile (\"mov _coeff_counter,       w10\");\n\n");
            //text = "        for(int j = 0; j < 1751+1; j++){\n";
            //writer.write(text);
            //text = "            asm volatile (\"mac w4*w5, A, [w8]-=2, w4, [w10]+=2, w5\");\n";
            //writer.write(text);
            //text = "        }\n\n";
            for (int j = 0; j < 1751+1; j++) {

                writer.write(String.format("            asm volatile (\"mac w4*w5, A, %d, w4, %d, w5\");\n",4000+1751-j,j));
            }
            writer.write("        filtred_data[i-1751] = ACCAH;\n");
            writer.write("    }\n");
            writer.write("}\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        for (int i = 4000; i < 1751; i++) {

        }
    }
}
