package controller;

import java.awt.Desktop;
import java.net.URI;

public class BrowserController {
    private static final String FACEBOOK_URL = "https://www.facebook.com/SoftwareTechMX/";
    private static final String YOUTUBE_URL  = "https://www.youtube.com/@Soft-Tech-MX";
    private static final String TIKTOK_URL   = "https://www.tiktok.com/@soft.tech.mx";
    
    public BrowserController()
    {
        
    }
    
    public static void open_facebook()
    {
        openURL(FACEBOOK_URL);
    }
    
    public static void open_youtube()
    {
        openURL(YOUTUBE_URL);
    }
    
    public static void open_tiktok()
    {
        openURL(TIKTOK_URL);
    }
    
    public static void openURL(String url) {
        try {
            // Verificar si Desktop está soportado en el sistema actual
            if (Desktop.isDesktopSupported()) {
                // Obtener la instancia de Desktop
                Desktop desktop = Desktop.getDesktop();
                
                // Verificar si se permite la acción de abrir el navegador
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Abrir el navegador web por defecto con la URL especificada
                    desktop.browse(new URI(url));
                } else {
                    LogController.debug("No se puede abrir el navegador");
                }
            } else {
                LogController.debug("Desktop no está soportado.");
            }
        } catch (Exception e) {
            LogController.debug(e.getMessage());
        }
    }
}
