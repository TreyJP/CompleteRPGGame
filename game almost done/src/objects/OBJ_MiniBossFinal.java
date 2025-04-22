package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_MiniBossFinal extends SuperObject{
    public OBJ_MiniBossFinal(){
        name = "MiniBossFinal";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/miniboss.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
