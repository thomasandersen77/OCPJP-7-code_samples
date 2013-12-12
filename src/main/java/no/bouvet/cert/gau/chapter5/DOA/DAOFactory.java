package no.bouvet.cert.gau.chapter5.DOA;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public class DAOFactory {
    public static CircleDAO getCircleDAO(String sourceType){
        // This is a simple example, so we have listed only "RDBMS" as the only source type
        // In a real-world application, you can provide more source types
        switch (sourceType){
            case "RDBMS":
                return new RDBMSDAO();
        }
        return null;
    }
}
