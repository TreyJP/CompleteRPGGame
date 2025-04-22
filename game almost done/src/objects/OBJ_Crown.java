package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Crown extends SuperObject{
    public OBJ_Crown(){
        name = "Crown";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/crown.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
