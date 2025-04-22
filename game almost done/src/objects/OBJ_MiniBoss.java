package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_MiniBoss extends SuperObject{
    public OBJ_MiniBoss(){
        name = "MiniBoss";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/miniboss.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
