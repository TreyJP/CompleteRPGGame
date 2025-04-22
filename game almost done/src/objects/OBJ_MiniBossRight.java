package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_MiniBossRight extends SuperObject{
    public OBJ_MiniBossRight(){
        name = "MiniBossRight";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/minibossright.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
