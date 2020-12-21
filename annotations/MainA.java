package annotations;

import java.lang.annotation.Annotation;

public class MainA {
    public static void main(String[] args) {
        MainA obj = new MainA();
        obj.getCardFace();
        
    }


    @CardPlayer(Name ="hi", CardFace = "s ")
    public void getCardFace() {
        System.out.println("cardplayer annotation");

    }
}