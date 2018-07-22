package com.example.javadadjokes;

public final class DadJokes {

    private String dadJoke;

    public String getJoke(int num) {

        // Most jokes are from 'All Def Digital' and their 'Dad Jokes' series of videos
        // Much appreciation to them for a laugh needed in between coding sessions.
        // You can find them here: "https://www.youtube.com/channel/UC0vRcJh1-GQL_V4qm5F6xFw"
        // Also thank you to the team behind this project, it was nice to finish such an advanced
        // topic on a happy and funny note. You guys at Udacity are awesome! :D
        switch (num) {
            case 0: dadJoke = "Who do you call for help when there is a fire on Mars? \n" +
                    "\n A Fire Martian!";
                    break;
            case 1: dadJoke = "Which NBA game scares Frosty the Snowman? \n" +
                 "\n The Heat versus The Suns.";
                    break;
            case 2: dadJoke = "Which concert costs 45 cents? \n" +
                    "\n 50 cent featuring Nickleback.";
                    break;
            case 3: dadJoke = "I read a book in braille, but it was on sandpaper...\n" +
                    "\n it was a ROUGH read!";
                break;
            case 4: dadJoke = "How do you tie up two Martians? \n" +
                    "\n With an Astro-Knot";
                break;
            case 5: dadJoke = "What did the old lady say when she confused 'Rae Sremmurd' with 'Drake'? \n" +
                    "\n That's Ludacris!";
                break;
            case 6: dadJoke = "Why does Tony the Tiger eat Frosted Flakes? \n" +
                    "\n Because it's cold in Siberia.";
                break;
            case 7: dadJoke = "What's the difference between a piano, glue, and a tuna? \n" +
                    "\n You can tune a piano, but you can't piano a tuna... \n" +
                    "\n Don't get it? It must be the glue... I knew you'd get stuck on that. :)";
                break;
            //And of course a few nerdy, geeky Star Wars joke b/c it wouldn't feel right without it :)
            case 8: dadJoke = "Why didn't the princess enjoy the wookie's recipe? \n" +
                    "\n Because it was chewy!";
                break;
            case 9: dadJoke = "What did the Sith say when he was getting his photo taken? \n" +
                    "\n Make sure you get my dark side.";
                break;
            case 10: dadJoke = "What did Austin Powers say to Obi-Wan when they went to the club?\n" +
                    "\n Obi-Haaayyyvvve!";
                break;
            case 11: dadJoke = "Which program do Jedis use to save PDF files?\n" +
                    "\n Adobe Wan-Kenobi.";
                break;
            case 12: dadJoke = "Why did the storm troopers buy iPhones? \n" +
                    "\n Because they couldn't find the Droids they were looking for!";
                break;
            case 13: dadJoke = "What kind of cars do Jedi drive? \n" +
                    "\n A Toy-Yoda";
                break;
            //source: http://www.jokes4us.com/celebrityjokes/starwarsjokes.html
            case 14: dadJoke = "What do you call it when only one Star Wars character gives you a round of applause? \n" +
                    "\n A Hand Solo!";
                break;
        }

        return dadJoke;
    }
}
