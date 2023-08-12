package com.example.demo.service;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Utilityclass {   
    public  byte[] compressImage( MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());

        // Compress the image
        BufferedImage compressedImage = compressToSize(originalImage, 4111);

        // Convert the compressed image to bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(compressedImage, "jpg", outputStream);

        return outputStream.toByteArray();
    }
    private BufferedImage compressToSize(BufferedImage image, int targetSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Calculate the aspect ratio
        double aspectRatio = (double) width / height;

        // Calculate the new width and height to achieve the target size
        int newWidth = (int) Math.sqrt((targetSize * aspectRatio));
        int newHeight = (int) (newWidth / aspectRatio);

        // Resize the image
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return resizedImage;
    }


    

}



