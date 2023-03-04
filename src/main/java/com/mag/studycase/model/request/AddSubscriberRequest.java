package com.mag.studycase.model.request;

import com.mag.studycase.entity.SubscriberEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSubscriberRequest {

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String msisdn;

    @Override
    public String toString() {
        return "id = " + this.getId() +
                ", name = " + this.getName() +
                ", msisdn = " + this.getMsisdn();
    }

    public SubscriberEntity toEntity() {
        return new SubscriberEntity(this.id, this.name, this.msisdn);
    }


}
