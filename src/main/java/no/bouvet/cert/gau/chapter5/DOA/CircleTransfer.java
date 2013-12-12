package no.bouvet.cert.gau.chapter5.DOA;

import java.io.Serializable;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public class CircleTransfer implements Serializable {
    private int xPos;
    private int yPos;
    private int radius;

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
