package main;

import objects.*;

import java.awt.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject(){
        //gp.obj[0] = new OBJ_Key();
        //gp.obj[0].worldX = 23 * gp.tileSize;
        //gp.obj[0].worldY = 7 * gp.tileSize;



        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 7 * gp.tileSize;
        gp.obj[1].worldY = 39 * gp.tileSize;

        gp.obj[2] = new OBJ_Chest();
        gp.obj[2].worldX = 3* gp.tileSize;
        gp.obj[2].worldY = 33*gp.tileSize;
        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 8* gp.tileSize;
        gp.obj[3].worldY = 47*gp.tileSize;
        gp.obj[4] = new OBJ_HealPotion();
        gp.obj[4].worldX = 12*gp.tileSize;
        gp.obj[4].worldY = 47*gp.tileSize;
        gp.obj[5] = new OBJ_Shield();
        gp.obj[5].worldX = 9*gp.tileSize;
        gp.obj[5].worldY = 46*gp.tileSize;
        //gp.obj[6] = new OBJ_SpeedBoots();
        //gp.obj[6].worldX = 29*gp.tileSize;
        //gp.obj[6].worldY = 10*gp.tileSize;
        gp.obj[7] = new OBJ_Sword();
        gp.obj[7].worldX = 9*gp.tileSize;
        gp.obj[7].worldY = 48*gp.tileSize;
        gp.obj[8] = new OBJ_MiniBoss(); // make this a boss that requires speed to beat
        gp.obj[8].worldX = 14*gp.tileSize;
        gp.obj[8].worldY = 43*gp.tileSize;
        gp.obj[9] = new OBJ_Door();
        gp.obj[9].worldX = 13* gp.tileSize;
        gp.obj[9].worldY = 47*gp.tileSize;
        gp.obj[10] = new OBJ_Door();
        gp.obj[10].worldX = 14* gp.tileSize;
        gp.obj[10].worldY = 36*gp.tileSize;
        gp.obj[11] = new OBJ_Door();
        gp.obj[11].worldX = 20* gp.tileSize;
        gp.obj[11].worldY = 36*gp.tileSize;
        gp.obj[12] = new OBJ_Key();
        gp.obj[12].worldX = 17* gp.tileSize;
        gp.obj[12].worldY = 43*gp.tileSize;
        gp.obj[13] = new OBJ_Witch();
        gp.obj[13].worldX = 21* gp.tileSize;
        gp.obj[13].worldY = 39*gp.tileSize;
        gp.obj[14] = new OBJ_MiniBossTwo();
        gp.obj[14].worldX = 17*gp.tileSize;
        gp.obj[14].worldY = 31*gp.tileSize;

        gp.obj[15] = new OBJ_Chest();
        gp.obj[15].worldX = 22*gp.tileSize;
        gp.obj[15].worldY = 28*gp.tileSize;

        gp.obj[16] = new OBJ_SpeedBoots();
        gp.obj[16].worldX = 26*gp.tileSize;
        gp.obj[16].worldY = 32*gp.tileSize;

        gp.obj[17] = new OBJ_Door();
        gp.obj[17].worldX = 27*gp.tileSize;
        gp.obj[17].worldY = 32*gp.tileSize;

        gp.obj[18] = new OBJ_Door();
        gp.obj[18].worldX = 47*gp.tileSize;
        gp.obj[18].worldY = 48*gp.tileSize;

        gp.obj[19] = new OBJ_MiniBossFinal();
        gp.obj[19].worldX = 44*gp.tileSize;
        gp.obj[19].worldY = 47*gp.tileSize;

        gp.obj[20] = new OBJ_Door();
        gp.obj[20].worldX = 36*gp.tileSize;
        gp.obj[20].worldY = 45*gp.tileSize;

        gp.obj[21] = new OBJ_Key();
        gp.obj[21].worldX = 44*gp.tileSize;
        gp.obj[21].worldY = 40*gp.tileSize;

        gp.obj[22] = new OBJ_MiniBossRight(); // make right facing
        gp.obj[22].worldX = 24*gp.tileSize;
        gp.obj[22].worldY = 46*gp.tileSize;

        gp.obj[23] = new OBJ_HealPotion();
        gp.obj[23].worldX = 25*gp.tileSize;
        gp.obj[23].worldY = 40*gp.tileSize;

        gp.obj[24] = new OBJ_Door();
        gp.obj[24].worldX = 28*gp.tileSize;
        gp.obj[24].worldY = 37*gp.tileSize;

        gp.obj[25] = new OBJ_Chest();
        gp.obj[25].worldX = 28*gp.tileSize;
        gp.obj[25].worldY = 36*gp.tileSize;

        gp.obj[26] = new OBJ_Key();
        gp.obj[26].worldX = 32*gp.tileSize;
        gp.obj[26].worldY = 36*gp.tileSize;

        gp.obj[27] = new OBJ_SpeedBoots();
        gp.obj[27].worldX = 41*gp.tileSize;
        gp.obj[27].worldY = 27*gp.tileSize;

        gp.obj[28] = new OBJ_Key();
        gp.obj[28].worldX = 38*gp.tileSize;
        gp.obj[28].worldY = 23*gp.tileSize;

        gp.obj[29] = new OBJ_MiniBossRight(); // make right facing
        gp.obj[29].worldX = 30*gp.tileSize;
        gp.obj[29].worldY = 17*gp.tileSize;

        gp.obj[30] = new OBJ_Key();
        gp.obj[30].worldX = 43*gp.tileSize;
        gp.obj[30].worldY = 15*gp.tileSize;

        gp.obj[31] = new OBJ_Door();
        gp.obj[31].worldX = 34*gp.tileSize;
        gp.obj[31].worldY = 11*gp.tileSize;

        gp.obj[32] = new OBJ_Chest();
        gp.obj[32].worldX = 33*gp.tileSize;
        gp.obj[32].worldY = 11*gp.tileSize;

        gp.obj[33] = new OBJ_HealPotion();
        gp.obj[33].worldX = 36*gp.tileSize;
        gp.obj[33].worldY = 8*gp.tileSize;

        gp.obj[34] = new OBJ_MiniBoss();
        gp.obj[34].worldX = 34*gp.tileSize;
        gp.obj[34].worldY = 4*gp.tileSize;

        gp.obj[35] = new OBJ_Chest();
        gp.obj[35].worldX = 19*gp.tileSize;
        gp.obj[35].worldY = 1*gp.tileSize;

        gp.obj[36] = new OBJ_Key();
        gp.obj[36].worldX = 20*gp.tileSize;
        gp.obj[36].worldY = 11*gp.tileSize;

        gp.obj[37] = new OBJ_Chest();
        gp.obj[37].worldX = 13*gp.tileSize;
        gp.obj[37].worldY = 36*gp.tileSize;
//
        gp.obj[38] = new OBJ_Chest();
        gp.obj[38].worldX = 21*gp.tileSize;
        gp.obj[38].worldY = 36*gp.tileSize;
//
        gp.obj[39] = new OBJ_Key();
        gp.obj[39].worldX = 1*gp.tileSize;
        gp.obj[39].worldY = 22*gp.tileSize;
//
        gp.obj[40] = new OBJ_Key();
        gp.obj[40].worldX = 1*gp.tileSize;
        gp.obj[40].worldY = 16*gp.tileSize;

        gp.obj[41] = new OBJ_Door();
        gp.obj[41].worldX = 6*gp.tileSize;
        gp.obj[41].worldY = 10*gp.tileSize;

        gp.obj[42] = new OBJ_Key();
        gp.obj[42].worldX = 10*gp.tileSize;
        gp.obj[42].worldY = 15*gp.tileSize;

        gp.obj[43] = new OBJ_MiniBoss();
        gp.obj[43].worldX = 21*gp.tileSize;
        gp.obj[43].worldY = 15*gp.tileSize;

        gp.obj[44] = new OBJ_Door();
        gp.obj[44].worldX = 16*gp.tileSize;
        gp.obj[44].worldY = 19*gp.tileSize;

        gp.obj[45] = new OBJ_HealPotion();
        gp.obj[45].worldX = 13*gp.tileSize;
        gp.obj[45].worldY = 19*gp.tileSize;

        gp.obj[46] = new OBJ_MiniBoss(); // make right
        gp.obj[46].worldX = 29*gp.tileSize;
        gp.obj[46].worldY = 27*gp.tileSize;
//
        gp.obj[47] = new OBJ_Crown();
        gp.obj[47].worldX = 48*gp.tileSize;
        gp.obj[47].worldY = 48*gp.tileSize;
//
        gp.obj[48] = new OBJ_MiniBossRight();
        gp.obj[48].worldX = 2*gp.tileSize;
        gp.obj[48].worldY = 5*gp.tileSize;
//
        //gp.obj[] = new ();
        //gp.obj[].worldX = *gp.tileSize;
        //gp.obj[].worldY = *gp.tileSize;
//

    }
}