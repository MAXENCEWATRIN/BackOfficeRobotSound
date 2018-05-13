/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.utils;

//import java.io.File;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;

/**
 *
 * @author maxence
 */
public class tools {
    
// public static void customFacesMessage(String message) {
//        FacesMessage facesMessage = new FacesMessage(message);
//        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
//    }
//
//    public static void addMessage(String detail) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, detail, null);
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//
//    public static void deleteImage(String imageName) {
//        ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
//        // image par defaut
//        String imageDefaut = external.getInitParameter("PATH_IMG_ROBOTSOUND");
//
//        if (imageName != null && !imageName.equalsIgnoreCase("") && !imageName.equals(imageDefaut)) {
//
//            String PATH_IMG_MUSICIEN = external.getInitParameter("PATH_IMG_MUSICIEN");
//
//            // url de stockage de la photo
//            String destinationPath = PATH_IMG_MUSICIEN + java.io.File.separator + imageName;
//
//            File oldFile = new File(destinationPath);
//            if (oldFile.exists()) {
//                oldFile.delete();
//                System.out.println("Image has deleted : " + destinationPath);
//            }
//        }
//    }

    
    public static String generatedRandomNameFile() {
        int i = (int) (Math.random() * 100000000);
        return String.valueOf(i) + ".png";
    }
    
    
}
