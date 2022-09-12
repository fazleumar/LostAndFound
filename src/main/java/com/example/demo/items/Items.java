package com.example.demo.items;

import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "item_id")
    private Integer item_id;

    @NonNull
    @Column(name = "report_type")
    private String report_type;

    @NotNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "reported_by")
    private String reported_by;

    @NonNull
    @Column(name = "latitude")
    private double latitude;

    @NonNull
    @Column(name = "longitude")
    private double longitude;

    @NonNull
    @Column(name = "product_image")
    private String image;

    @Transient
    public String getPhotosImagePath() {
        if (image == null || item_id == null) return null;
        String imagePath = "/item-photos/" + item_id + "/" + image;
        System.out.println(imagePath);
        return imagePath;
    }
}