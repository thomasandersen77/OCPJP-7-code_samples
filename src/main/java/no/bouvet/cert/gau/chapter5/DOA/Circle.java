package no.bouvet.cert.gau.chapter5.DOA;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public class Circle {
    private int xPos, yPos;
    private int radius;
    public Circle(int x, int y, int r){
        xPos = x;
        yPos = y;
        radius = r;
    }

    public CircleTransfer getCircleTransferObject(){
        CircleTransfer circleTransfer = new CircleTransfer();
        circleTransfer.setRadius(radius);
        circleTransfer.setxPos(xPos);
        circleTransfer.setyPos(yPos);
        return circleTransfer;
    }

    @Override
    public String toString() {
        return "center = ("+ xPos + ","+ yPos + ") and radius = " + radius;
    }
}
