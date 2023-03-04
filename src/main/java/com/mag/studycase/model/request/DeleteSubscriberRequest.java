package com.mag.studycase.model.request;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class DeleteSubscriberRequest {

    @NotNull
    private String id;

    @Override
    public String toString() {
        return "id = " + this.getId();
    }

}
