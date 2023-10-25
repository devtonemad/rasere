package de.gnubis.rasere;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/rasere")
@Slf4j
public class RasereMessageController {

    @Autowired
    RasereMessageSender messageSender;
    @PostMapping(value="/message/{times}")
    void postMessage( @PathVariable("times") int times, @RequestBody String message){
        log.debug("message send via controller : "  + message + "for " + times + " times ");
        for (int i = 0; i < times ; i++) {
            messageSender.sendMessage(message);
        }
    }
}
