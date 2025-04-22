package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Witch extends SuperObject{
    public OBJ_Witch(){
        name = "Witch";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/witch.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
