package com.granny.grannyService;


import com.granny.grannyService.granny.Generator;
import com.granny.grannyService.granny.Granny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
;
import java.security.SecureRandom;
import java.util.*;

@RestController
public class GrannyRestController {
    Generator generator = new Generator(40);
    ArrayList<Granny> grannies =  generator.getNewGrannies(true);//generator.getNewGrannies(40);






    @GetMapping("/getGrannies")
    public ArrayList<Granny> getGrannies() {
        return this.grannies;
    }

    @GetMapping("/areGranniesReady")
    public Boolean granniesReady() {
        return grannies.size()!=0 ;
    }

    @GetMapping("/ping")
    public String ping() {
        return "I'm alive";
    }

}

