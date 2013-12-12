package no.bouvet.cert.gau.chapter5.DOA;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(10,10,20);
        System.out.println(circle);
        CircleTransfer circleTransfer = circle.getCircleTransferObject();
        CircleDAO circleDAO = DAOFactory.getCircleDAO("RDBMS");
        circleDAO.insertCircle(circleTransfer);

    }
}
