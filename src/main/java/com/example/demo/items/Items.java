package com.example.demo.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private Integer item_id;

    @Column(name = "report_type", nullable = false)
    private String report_type;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "reported_by", nullable = false)
    private String reported_by;
    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "longitude", nullable = false)
    private double longitude;
    @Column(name = "product_image", nullable = true)
    private String image;

    @Transient
    public String getPhotosImagePath() {
//        Image imageToReturn = null;
//        try {
//            URL url = new URL(image);
//            imageToReturn = ImageIO.read(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (image == null || item_id == null) return null;
        System.out.println(image);
        return image;
    }
}