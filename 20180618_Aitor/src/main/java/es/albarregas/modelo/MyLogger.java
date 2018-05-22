package es.albarregas.modelo;

public class MyLogger {

    /**
     * This method allows de user to create a log without the ugly code in the middle
     * of the main code, a log4j.properties file is necesary.
     * @param e this is the exception thrown
     * @param c this value is the current class where doLog is being called from.
     * @param level the values can be fatal, warn or error, default is info.     
     */
    public void doLog(Exception e, Class c, String level) {

        System.setProperty("logPath", c.getSimpleName());
        System.setProperty("projectName", "ObjetosDAOv4");
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(c);

        
        
        String out = "Linea: " + e.getStackTrace()[0].getLineNumber() + " Causa: " + e;
        switch (level) {

            case "fatal":
                logger.fatal(out);
                break;
            case "warn":
                logger.warn(out);
                break;
            case "error":
                logger.error(out);
                break;
            default:
                logger.info(out);
                break;
        }
    }
}