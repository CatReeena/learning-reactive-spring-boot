package com.reactivespringboot.learningreactivespringboot;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@RestController
public class ImageController {

    public final String API_BASE_PATH = "app";

    @PostMapping(API_BASE_PATH + "/images")
    Mono<Void> create(@RequestBody Flux<Image> images) {
        return images
                .map(image -> {
                    log.info("We will save " + image +
                            " to a Reactive database soon!");
                    return image;
                })
                .then();
    }
}
