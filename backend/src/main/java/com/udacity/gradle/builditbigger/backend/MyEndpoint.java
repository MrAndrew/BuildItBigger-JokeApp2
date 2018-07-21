package com.udacity.gradle.builditbigger.backend;

import com.example.javadadjokes.DadJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import java.util.concurrent.ThreadLocalRandom;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    private int MIN = 0;
    private int MAX = 14;

    @ApiMethod(name = "tellDadJoke")
    public MyBean tellDadJoke() {
        int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        MyBean response = new MyBean();
        //create new class from library
        DadJokes myDadJoke = new DadJokes();
        String dadJoke = myDadJoke.getJoke(randomNum);
        response.setData(dadJoke);

        return response;
    }

}
