package com.epam.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class PhoneResponse {

    private Long id;
    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    private String region;
    private String country;
    private Boolean active;
    @LastModifiedDate
    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;
    @JsonProperty(value = "created_by")
    private String createdBy;
    @LastModifiedDate
    @JsonProperty(value = "updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty(value = "updated_by")
    private String updatedBy;

}
