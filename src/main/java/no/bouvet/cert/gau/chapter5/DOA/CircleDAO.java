package no.bouvet.cert.gau.chapter5.DOA;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public interface CircleDAO {
    public void insertCircle(CircleTransfer circle);
    public CircleTransfer findCircle(int id);
    public void deleteCircle(int id);
}
