package com.granny.grannyService;


import com.granny.grannyService.granny.Generator;
import com.granny.grannyService.granny.Granny;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
;
import java.security.SecureRandom;
import java.util.*;

@RestController
public class GrannyRestController {

    SecureRandom rand = new SecureRandom();
    Generator generator = new Generator();

    @GetMapping("/getGrannies/{number}")
    public ArrayList<Granny> getGrannies(@PathVariable("number") int number) {
        if (number >= 1) {
            //generator.getNewGrannies(1);
            return generator.getNewGrannies(number);
        } else {
            System.out.println("number must be greater than 0");
            return null;
        }
    }

    @GetMapping("/ping")
    public String ping() {
        return "I'm alive";
    }

}

