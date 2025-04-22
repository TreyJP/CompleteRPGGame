package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_MiniBossTwo extends SuperObject{
    public OBJ_MiniBossTwo(){
        name = "MiniBossTwo";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/minibosstwo.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
