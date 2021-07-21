package com.zensar.dto;

import com.zensar.model.Advertise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseDto {
    @NotEmpty(message = "required.title")
    private String title;
    @NotEmpty(message = "required.price")
    private String price;
    private Long categoryId;
    private String description;

    public Advertise buildAdvertiseModel () {
        return new Advertise(0L, this.getTitle(), this.getPrice(), this.getCategoryId(), this.getDescription());
    }
}
