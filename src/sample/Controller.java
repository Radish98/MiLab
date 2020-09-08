package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Controller {

    private static final char  ACID_A ='A';
    private static final char  ACID_G ='G';
    private static final char  ACID_C ='C';
    private static final char  ACID_T ='T';


    @FXML
    private TextArea textArea;

    @FXML
    private Text text;

    public String inputString = "";
    public String outPutString ="";

    @FXML
    public void onClick(){
        try {
            inputString = textArea.getText();
            int countA = 0;
            int countC = 0;
            int countG = 0;
            int countT = 0;
            BigDecimal percentA = new BigDecimal(0);
            BigDecimal percentC = new BigDecimal(0);
            BigDecimal percentG = new BigDecimal(0);
            BigDecimal percentT = new BigDecimal(0);

            int size = 0;
            for (char acid : inputString.toCharArray()) {
                if (acid == ACID_A) countA++;
                else if (acid == ACID_C) countC++;
                else if (acid == ACID_G) countG++;
                else if (acid == ACID_T) countT++;
                else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            size = inputString.length();
            if (size != 0) {
                percentA = BigDecimal.valueOf(countA).divide(BigDecimal.valueOf(size),5,RoundingMode.CEILING).multiply((BigDecimal.valueOf(100)));
                percentC = BigDecimal.valueOf(countC).divide(BigDecimal.valueOf(size),5,RoundingMode.CEILING).multiply(BigDecimal.valueOf(100));
                percentG = BigDecimal.valueOf(countG).divide(BigDecimal.valueOf(size),5,RoundingMode.CEILING).multiply(BigDecimal.valueOf(100));
                percentT = BigDecimal.valueOf(countT).divide(BigDecimal.valueOf(size),5,RoundingMode.CEILING).multiply(BigDecimal.valueOf(100));
            } else {
                countA = 0;
                countC = 0;
                countG = 0;
                countT = 0;

            }

            outPutString = "A=" + countA + " (" + percentA
                    + "%)\nC=" + countC + " (" + percentC
                    + "%)\nG=" + countG + " (" + percentG
                    + "%)\nT=" + countT + " (" + percentT + "%)";
            text.setText(outPutString);
        }catch (ArrayIndexOutOfBoundsException ex){
            outPutString = "Error: Wrong Acid has been entered";
            text.setText(outPutString);
        }
    }
}
