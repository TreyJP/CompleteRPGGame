package entity;

import main.GamePanel;
import main.KeyHandler;
import objects.OBJ_Shield;
import objects.OBJ_Sword;
import objects.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;


    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    int hasSword = 0;
    int hasStrengthPotion = 0;
    public int healthPoints = 10;
    public int damage = 15;
    int hasShield = 0;
    int hasSpeetBoots = 0;
    String playerMessage;
    int maxHealth = 10;
    public int bossDeath = 0;


    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(worldX+41, worldY+52, 12, 28);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImage();

    }
    public void setDefaultValues () {
        worldX = gp.tileSize * 1;
        worldY = gp.tileSize * 46;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/tile012.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/tile013.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/tile018.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/tile019.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/tile024.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/tile025.png"));


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if (healthPoints < 1) {
            gp.ui.healthPointsBelow = true;
        }
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed == true && keyH.rightPressed == true) {
                direction = "up-right";
            }
            else if (keyH.upPressed && keyH.leftPressed) {
                direction = "up-left";
            }
            else if (keyH.downPressed && keyH.leftPressed) {
                direction = "down-left";
            }
            else if (keyH.downPressed && keyH.rightPressed) {
                direction = "down-right";
            }
            else if (keyH.upPressed == true) {
                direction = "up";
                if(keyH.rightPressed) {
                    direction = "up-right";
                }

            }
            else if (keyH.downPressed == true) {
                direction = "down";


            }
            else if (keyH.leftPressed == true) {
                direction = "left";


            }
            else if (keyH.rightPressed == true) {
                direction = "right";

            }
            // check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);

            //check object collision

            int objIndex = gp.collisionChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // if collision is false player can move
            if (!collisionOn) {
                switch(direction) {
                    case "up-right":
                        worldY = worldY - speed;
                        worldX = worldX + speed;
                        break;
                    case "up-left":
                        worldY = worldY - speed;
                        worldX = worldX - speed;
                        break;
                    case "down-left":
                        worldY = worldY + speed;
                        worldX = worldX - speed;
                        break;
                    case "down-right":
                        worldY = worldY + speed;
                        worldX = worldX + speed;
                        break;
                    case "up":
                        worldY = worldY - speed;
                        break;
                    case "down":
                        worldY = worldY + speed;
                        break;
                    case "left":
                        worldX = worldX - speed;
                        break;
                    case "right":
                        worldX = worldX + speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }
    }

    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch(objectName) {
                case "Key":
                    hasKey = hasKey + 1;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Key Found");
                    break;
                case "Chest":
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                        if (speed == 2) {
                            gp.ui.showMessage("Speed Doubled");
                            speed = speed * 2;
                        }
                        else if (damage == 5) {
                            gp.ui.showMessage("Damage Increased");
                            damage = damage * 2;
                        }
                        else {
                            gp.ui.showMessage("Max health Increased");
                            healthPoints = 20;
                            maxHealth = 20;
                        }


                    }
                    else {
                        gp.ui.showMessage("Missing Key");
                    }
                    break;
                case "Door":
                    if(hasKey > 0) {
                        gp.obj[i]=null;
                        hasKey--;
                        gp.ui.showMessage("Door Opened");
                    }
                    else {
                        gp.ui.showMessage("Missing Key");
                    }
                    break;
                case "HealPotion":
                    if (healthPoints < maxHealth) {
                        gp.ui.showMessage("Health Restored");
                        gp.obj[i]=null;
                        healthPoints = maxHealth;
                    } else {
                        System.out.println(healthPoints);
                        System.out.println(maxHealth);
                        gp.ui.showMessage("Health Full");
                    }
                    break;
                case "Shield":
                    if (hasSword == 0) {
                        gp.ui.showMessage("Shield Equipped");
                        hasShield++;
                        gp.obj[i] = null;
                        break;
                    } else {
                        if (hasSword == 1) {
                            gp.ui.showMessage("Shield Equipped, Sword Dropped");
                            hasShield++;
                            hasSword--;
                            gp.obj[i] = null;
                            gp.obj[7] = new OBJ_Sword();
                            gp.obj[7].worldX = 9 * gp.tileSize;
                            gp.obj[7].worldY = 48 * gp.tileSize;
                            break;
                        }
                    }
                case "SpeedBoots":
                    if (hasSpeetBoots == 0) {
                        gp.obj[i]=null;
                        gp.ui.showMessage("Speed Increase");
                        speed = speed * 2;
                        break;
                    }
                    //gp.ui.gameFinished = true;
                    break;
                case "Sword":
                    if (hasShield == 1) {
                        gp.ui.showMessage("Sword Equipped, Shield Dropped");
                        gp.obj[i]=null;
                        gp.obj[5] = new OBJ_Shield();
                        gp.obj[5].worldX = 9*gp.tileSize;
                        gp.obj[5].worldY = 46*gp.tileSize;
                        hasSword++;
                        hasShield--;

                    }
                    else {
                        gp.ui.showMessage("Sword Equipped");
                        gp.obj[i]=null;
                        hasSword++;

                    }
                    for (SuperObject z : gp.obj) {
                        System.out.println(z);
                    }
                    break;
                case "MiniBoss":
                    if (speed == 2 && hasShield == 0 ) {
                        gp.ui.firstBossDeath = true;
                    }
                    if (healthPoints < 9){
                        gp.ui.tooLowOfHP = true;
                    }
                    else {
                        gp.ui.showMessage("Boss Defeated");
                        gp.obj[i] = null;
                        healthPoints = healthPoints - 8;
                        bossDeath = bossDeath + 1;
                    }
                    break;
                case "Witch":
                    if (gp.ui.playTime < 35) {
                        gp.ui.showMessage("Take Some Health");
                        healthPoints = 15;
                    }
                    else if (gp.ui.playTime > 55) {
                        gp.ui.tookTooLongWitchEnding = true;
                    }
                    else {
                        gp.ui.showMessage("I Can Not Help You");
                    }
                    break;
                case "MiniBossTwo":
                    if (healthPoints < 14) {
                        gp.ui.healthTwoLowToDefeat = true;
                    }
                    if (damage != 10 && hasSword == 0) {
                        gp.ui.notEnoughStrength = true;
                    }
                    else {
                        gp.obj[i] = null;
                        healthPoints = healthPoints - 10;
                        gp.ui.showMessage("You won this time, be careful");
                        bossDeath = bossDeath + 1;
                    }
                    break;
                case "Crown":
                    gp.ui.gameFinished = true;
                    break;
                case "MiniBossRight":
                    if (speed == 2 && hasShield == 0 ) {
                        gp.ui.firstBossDeath = true;
                    }
                    if (healthPoints < 9){
                        gp.ui.tooLowOfHP = true;
                    }
                    else {
                        gp.ui.showMessage("Boss Defeated");
                        gp.obj[i] = null;
                        healthPoints = healthPoints - 8;
                        bossDeath = bossDeath + 1;
                    }
                    break;
                case "MiniBossFinal":
                    if (healthPoints < 20) {
                        gp.ui.tooLowOfHP = true;
                    }
                    else {
                        gp.obj[i] = null;
                        healthPoints = 1;
                        bossDeath = bossDeath + 1;
                        gp.ui.showMessage("Final Boss Defeated");
                    }
                    break;






            }
        }

    }

    public void draw(Graphics2D g2){


        BufferedImage image = null;

        switch(direction){
            case "up-right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "up-left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "down-right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "down-left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;

        }
        //g2.fillRect(10,10,8,8);
        //g2.drawRect(screenX,screenY,gp.tileSize,gp.tileSize);
        g2.drawImage(image,screenX,screenY,gp.tileSize*2,gp.tileSize*2, null);
        //g2.setColor(Color.YELLOW);
        //g2.drawRect(screenX+41, screenY+52, 12, 28);

    }
}