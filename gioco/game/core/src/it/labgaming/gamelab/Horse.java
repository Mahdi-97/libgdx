package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Horse extends BaseActor{

    private int speed=5;
    private int direction;

    String[] top = {"horse-up-1.png", "horse-up-2.png", "horse-up-3.png"};;
    String[] left = {"horse-left-1.png", "horse-left-2.png", "horse-left-3.png"};;
    String[] right = {"horse-right-1.png", "horse-right-2.png", "horse-right-3.png"};
    String[] bottom = {"horse-bottom-1.png", "horse-bottom-2.png", "horse-bottom-3.png"};;

    Animation<TextureRegion> animTop;
    Animation<TextureRegion> animLeft;
    Animation<TextureRegion> animRight;
    Animation<TextureRegion> animBottom;

    public Horse(float x, float y, Stage s) {
        super(x, y, s);

        animTop =  loadAnimationFromFiles(top, 0.1f, true);
        animBottom =  loadAnimationFromFiles(bottom, 0.1f, true);
        animRight =  loadAnimationFromFiles(right, 0.1f, true);
        animLeft =  loadAnimationFromFiles(left, 0.1f, true);

        setAnimation(animRight);
        this.setDirection(0);
    }
    public void setDirection(int d)
    {
        this.direction=d;
    }

    public int getDirection()
    {
        return this.direction;
    }

    public void act(float dt) {
        super.act(dt);

        if(direction == Horse.RIGHT) {
            //anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(animRight);
            this.moveBy(speed,0);
        }

        if(direction == Horse.BOTTOM) {
            //anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(animBottom);
            this.moveBy(0,-speed);

        }
        if(direction == Horse.LEFT) {
            //anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(animLeft);
            this.moveBy(-speed,0);

        }

        if(direction == Horse.TOP) {
            //anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(animTop);
            this.moveBy(0,speed);
        }
    }

    public void setSquarePath(float offSetX1,float offSetX2,float offSetY){
        if(this.getX() >= this.getSpawnX() + offSetX1 && this.getY() == this.getSpawnY()) {
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Horse.BOTTOM);
        }
        else if(this.getX() == this.getWaypointX() && this.getY() <= this.getWaypointY() - offSetY){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Horse.LEFT);
        }
        else if(this.getX() <= this.getWaypointX() - offSetX2 && this.getY() == this.getWaypointY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Horse.TOP);
        }
        else if( this.getY() >= this.getSpawnY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Horse.RIGHT);
        }
    }
}
