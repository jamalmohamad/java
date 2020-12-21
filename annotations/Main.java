package annotations;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.getCardFace();
        
    }


    @CardPlayer(Name ="hi", CardFace = "s ")
    public void getCardFace() {
        System.out.println("cardplayer annotation");

    }
}