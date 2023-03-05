package com.mag.studycase.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteSubscriberRequest {

    @NotBlank
    private String id;

    @Override
    public String toString() {
        return "id = " + this.getId();
    }

}
