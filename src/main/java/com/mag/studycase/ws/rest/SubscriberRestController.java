package com.mag.studycase.ws.rest;

import com.mag.studycase.model.request.DeleteSubscriberRequest;
import com.mag.studycase.model.request.AddSubscriberRequest;
import com.mag.studycase.model.request.UpdateSubscriberRequest;
import com.mag.studycase.model.response.AddSubscriberResponse;
import com.mag.studycase.model.response.UpdateSubscriberResponse;
import com.mag.studycase.services.SubscriberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriber")
public class SubscriberRestController {

    private final SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity<AddSubscriberResponse> addSubscriber(@RequestBody @Valid AddSubscriberRequest request) throws IOException {

        final AddSubscriberResponse addSubscriberResponse = subscriberService.addSubscriber(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addSubscriberResponse);

    }

    @PutMapping
    public ResponseEntity<UpdateSubscriberResponse> updateSubscriber(@RequestBody @Valid UpdateSubscriberRequest request) {

        final UpdateSubscriberResponse updateSubscriberResponse = subscriberService.updateSubscriber(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateSubscriberResponse);

    }

    @DeleteMapping
    public void deleteSubscriber(@RequestBody @Valid DeleteSubscriberRequest request) {

        subscriberService.deleteSubscriber(request);

    }

}
