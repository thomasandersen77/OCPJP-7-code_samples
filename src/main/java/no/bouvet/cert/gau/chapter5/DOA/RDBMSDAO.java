package no.bouvet.cert.gau.chapter5.DOA;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public class RDBMSDAO implements CircleDAO{
    @Override
    public void insertCircle(CircleTransfer circle) {
        // insertCircle implementation
        System.out.println("insertCircle implementation");
    }

    @Override
    public CircleTransfer findCircle(int id) {
        // findCircle implementation
        return null;
    }

    @Override
    public void deleteCircle(int id) {
        // deleteCircle implementation
    }
}
