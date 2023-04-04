package com.granny.grannyService.granny;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {
    private Random random;
    private final int minAge = 60;
    private final int maxAge = 103;
    private final int maxScore = 5;
    private final int minPrice = 20;
    private final int maxPrice = 80;
    private final int maxPrepTime = 180;
    private final int minPrepTime = 9;
    private ArrayList<Integer> indexes = new ArrayList<>();
    private int nbGrannies;

    private final String[] names = {"Anita","Brigitte","Bernadette","Claude","Rémonde","Joséphine","Gertrude","Lucette",
            "Jinette","Martine","Nathalie","Françoise","Anne","Marie-France","Marie-Anne","Anne-Marie","Jeanne","Isabelle",
            "Martine","Nadine","Béatrice","Monique","Colette","Francine","Thérèse","Josianne","Gisèle","Murielle","Aline",
            "Paule","Albertine","Capucine","Chistiane","Christine","Catherine","Odile","Michelle","Noëlle","Natalia","Marinette",
            "Claudette", "Paulette","Georgette","Joëlle","Sylvianne","Lilianne","Lucienne","Constance","Cibille","Ginnette",
            "Jeanette","Marie-Pierre","Jinnette","Cunégonde","Rosemonde","Rémonde","Huguette","Josette","Lucette","Josianne",
            "André","Chantal","Hanriette","Rennée","Josie","Rose","Antoinette","Marie-Jeanne","Marise","Marie-Lousie","Louise",
            "Danielle","Marceline","Mauricette","Germaine","Giselle","Francine","Francette","Antonella","Jeannine","Ursule,",
            "Ursula","Lina","Leone","Leonnie,","Margot","Bernadette","Juliette","Nadège","Evelyne","Jacqueline","Jacquie"
    };
    private final String[] locations = {
            "Nice",
            "Allemagne-En-Provence",
            "Aubagne",
            "Toulon",
            "Montauroux",
            "Lorgues",
            "Sophia Antipolis",
            "Villefranche-sur-Mer",
            "Cagnes-sur-Mer",
            "Lorgues",
            "Èze",
            "Gattières",
            "Vence",
            "Biot",
            "Peille",
            "Saint Agnès",
            "Rustrel",
            "Mons",
            "Fayence",
            "Draguignan",
            "Aix-en-Provence"
    };
    private final String[] descriptions = {
            "Je vous parlerais de mon club de bridge.",
            "Je suis une grand-mère dynamique et active qui adore voyager et découvrir de nouvelles cultures. J'aime les promenades en plein air, les musées, les films et les bons restaurants.",
            "Je suis une grand-mère érudite et cultivée qui aime lire des livres et regarder des documentaires. J'aime les conversations intellectuelles et les débats animés.",
            "Je suis une grand-mère douce et aimante qui adore passer du temps avec ma famille et mes petits-enfants. J'aime cuisiner de bons plats traditionnels et écouter de la musique classique.",
            "Je suis une grand-mère passionnée de cuisine depuis plus de 50 ans, et je cherche quelqu'un pour partager mes recettes et mes astuces culinaires préférées !",
            "Si vous cherchez une grand-mère qui sait comment cuisiner un plat délicieux avec seulement quelques ingrédients, alors ne cherchez pas plus loin !",
            "Je suis une grand-mère qui adore cuisiner pour ma famille et mes amis. J'espère trouver quelqu'un avec qui je pourrais échanger des recettes et des histoires de cuisine.",
            "Je suis une grand-mère qui ne peut pas résister à l'envie de cuisiner pour ceux que j'aime. Si vous cherchez une cuisinière passionnée, ne cherchez plus !",
            "J'adore essayer de nouvelles recettes et expérimenter avec différents ingrédients. Si vous partagez cette passion pour la cuisine, alors nous sommes faits pour nous rencontrer !",
            "Je suis une grand-mère qui croit que la cuisine est une forme d'art. Si vous êtes un amoureux de la gastronomie, nous devrions nous entendre à merveille !",
            "J'aime préparer des plats qui réconfortent l'âme, comme des soupes chaudes et des ragoûts mijotés. Si vous êtes un amateur de plats réconfortants, alors nous devrions nous entendre comme lardons et petits pois !",
            "Je suis une grand-mère qui a grandi avec une cuisine traditionnelle et familiale, mais qui adore aussi expérimenter de nouvelles recettes et tendances. Si vous êtes curieux culinairement parlant, alors vous êtes au bon endroit !",
            "Je suis une grand-mère qui aime partager son amour de la cuisine avec les autres. Si vous êtes prêt à partager une délicieuse conversation culinaire avec moi, je serai ravie de vous rencontrer !",
            "Je suis une grand-mère qui croit que la cuisine est une façon d'exprimer son amour pour les autres. Si vous êtes à la recherche d'une femme aimante et passionnée, alors je suis là pour vous !",
            "Grand-mère croyant que la cuisine est un moyen de rassembler les gens autour de la table. Si vous êtes prêt à partager un repas chaleureux et convivial, alors je suis là pour vous !",
            "Je suis une grand-mère qui aime cuisiner pour les occasions spéciales et les fêtes de famille. Si vous cherchez quelqu'un pour vous aider à préparer votre prochain grand événement culinaire, alors vous êtes au bon endroit !",
            "Je suis une jeune femme qui aime cuisiner des plats sains et équilibrés pour ma famille et mes amis. Si vous êtes à la recherche de recettes santé, alors vous êtes à la bonne adresse !",
            "Je suis une vieille qui adore cuisiner des plats internationaux, de la cuisine italienne à la cuisine thaïlandaise en passant par la cuisine indienne. Si vous êtes un voyageur culinaire, alors je suis là pour vous !",
            "Je suis une grand-mère qui croit que la nourriture doit être savoureuse, mais aussi belle à regarder. Si vous êtes sensible à la présentation de vos plats, alors nous avons déjà un point en commun !",
            "La meilleure de toute la région.",
            "Je suis constamment dans les choux.",
            "J'ai beau être drôle et coquette, ne me prenez pas pour le dindon de la farce.",
            "Je vous passerais l'envie d'acheter des plats industriels",
            "La meilleure, en tout points. :)",
            "Comment ça marche deja, Amstramgrans?",
            "Mère au foyer depuis toujours, je vous concocterais de superbes plat",
            "De loin la moins chère de toute la plateforme.",
            "C'est sert à quoi ?"


    };

    private final String[] dishNames = {
            "Paëlla","Moules frites","Pizza","Hamburger","Fish and chips","Pâtes à la carbonara","Fondue vigneronne",
            "Dorade royale","Sushis","Makis","Tempuras","Lasagne","Poke bowl","Raclette","Méchoui","Dinde de Noêlle",
            "Cordon bleu","Crêpes","Hachis parmentier","Soupe à l'ail","Pissaladière","Fondue Savoyarde","Fondue Bourguignonne",
            "Pâtes bolognaise","Gaufres","Quatre-quarts","Café gourmand","Daube de boeuf carottes","Blanquette de veau",
            "Purée de pommes de terre","Blanc de dinde à la moutarde","Rôti de veau","Gratin dauphinois","Pot au feu",
            "Filet mignon de porc","Escalope à la milanaise"
    };

    private final String[] dishNotes = {
            "Oh zut, ça écrit ce que je dis. Hihi, c'est drôle comment on enlève cette connerie ?",
            "Tout simplement succulent",
            "Fantastiquement délicieux",
            "Exquis",
            "Fondant",
            "Réchauffe l'estomac et l'âme",
            "Succulent",
            "Pas mauvais",
            "Délicieux",
            "Je sais pas quoi dire",
            "Le plat réconfortant par excellence",
            "Ce que je fait de mieux !",
            "Je vous préviens, ça fait pas longtemps que j'en fait",
            "C'est meilleur chaud !",
            "Attendez de voir ce que je faire d'autre !",
            "De loin mon plat le plus réussit !",
            "Vaut le détour",
            "Fait avec amour !",
            "Beaucoup trop bon!"

    };

    public Generator(int nb){
        this.nbGrannies = nb;
        this.random = new Random();


        for (int i = 1; i <= nbGrannies; i++){
            indexes.add(i);
        }
        System.out.println("Indexes size:"+indexes.size());
        Collections.shuffle(indexes);


    }

    private String getRandomName(){
        return names[random.nextInt(names.length)];
    }

    public Granny getNewGranny(){
        Granny granny = new Granny();
        ArrayList<Dish> dishes = getRandomDishes(3,12);
        int age = getRandomAge();
        double avgDishesTime = getAvgDishesTime(dishes);
        double price = getRandomPrice( avgDishesTime,age);
        granny.setUrlPicture(getRandomUrlPicture());
        granny.setName(getRandomName());
        granny.setAge(age);
        granny.setLocation(getRandomLocation());
        granny.setDishes(dishes);
        granny.setPrice(price);
        granny.setScore(getRandomScore(price));
        granny.setDesc(getRandomDesc());
        return granny;
    }

    private double getAvgDishesTime(ArrayList<Dish> dishes) {
        double avg=0;
        for (Dish d:dishes){
            avg += (double) d.getPrepMinute();
        }
        return avg/dishes.size();
    }


    private double getRandomPrice(double avg,int age) {
        Math.sqrt(age);
        double variateur = 0.5;
        double i = random.nextDouble(variateur)+variateur;
        double val = ((avg/(age/2))*9)*i;
        return val;
        //return random.nextDouble(maxPrice-minPrice)+minPrice;
    }

    private String getRandomDesc() {
        return descriptions[random.nextInt(descriptions.length)];
    }

    private String getRandomUrlPicture() {
        return "granny_"+indexes.remove(0)+".png";
    }


    private double getRandomScore(double price) {
        //plus le prix est haut, par rapport a la moy, plus le score est bas;
        double variateur = random.nextDouble(maxScore-3)+0.5 ;
        double val = ((maxScore/price)*variateur);
        val =  (val%maxScore)*4;
        if (val>5){
            return 5.0;
        }
        return val;
    }

    private String getRandomLocation() {
        return locations[random.nextInt(locations.length)];
    }

    public Dish getNewDish(){
        Dish dish = new Dish();
        dish.setName(getRandomDishName());
        dish.setPrepTime(getRandomPrepTime(dish));
        dish.setNote(getRandomNote());
        return dish;
    }

    private String getRandomDishName() {
        return dishNames[random.nextInt(dishNames.length)];
    }

    private String getRandomNote() {
        return dishNotes[random.nextInt(dishNotes.length)];
    }

    private String getRandomPrepTime(Dish dish) {
        int min = minPrepTime;
        int max = maxPrepTime;
        int alea = random.nextInt(101);
        if (alea>99){
            min=240;
            max=300;
        }else if (alea>80){
            max=120;
        }else if (alea>50){
            max=90;
        }else {
            max =60;
        }
        //System.out.println("max:"+max+" min:"+min);
        int minute = random.nextInt(max-min)+min;
        dish.setPrepMinute(minute);
        int hour = 0;
        while (minute > 60 ){
            minute -=60;
            hour++;
        }
        if (hour>0){
            if (minute<10){
                return hour + "h0"+minute;
            }
            return hour + "h"+minute;
        }
        return minute +" minutes";
    }

    private int getRandomAge() {
        int alea = random.nextInt(101);
        int min=minAge;
        int max=maxAge;
        if (alea>99){
            min=100;
        }else if (alea>80){
            min=90;
            max=100;
        }else if (alea>50){
            min=80;
            max=90;
        }else{
            max=80;
        }
        return random.nextInt(max -min) + min;
    }

    private Granny getNewBorne(){
        Granny newBorne = new Granny();
        newBorne.setName("Babette");
        newBorne.setDishes(getRandomDishes(1,4));
        newBorne.setScore(4.93);
        newBorne.setAge(62);
        newBorne.setLocation(getRandomLocation());
        double avg = getAvgDishesTime(newBorne.getDishes());
        newBorne.setPrice(49.3);
        newBorne.setUrlPicture("granny_0.png");
        newBorne.setDesc("Réformer les retraites, c’est préserver des marges de manœuvre pour agir sur des politiques essentielles.");

        return newBorne;
    }

    private ArrayList<Dish> getRandomDishes(int min, int max) {
        ArrayList<Dish> dishes = new ArrayList<Dish>();
        int dishesNumber = random.nextInt(max -  min)+min;
        for (int i = 0; i < dishesNumber;i++ ){
            Dish dish =getNewDish();
            if (!dishes.contains(dish)){
                dishes.add(dish);
            }
        }
        return dishes;
    }

    public ArrayList<Granny> getNewGrannies(boolean borne){
        ArrayList<Granny> grannies = new ArrayList<>();
        System.out.println("Generating Grannies...");
        for(int i = 0; i < nbGrannies-1; i++){
            grannies.add(getNewGranny());
        }
        if (borne){
            grannies.add(getNewBorne());
        }

        System.out.println("Done...");
        return grannies;
    }





}
