package com.granny.grannyService.granny;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private Random random;
    private final int minAge = 60;
    private final int maxAge = 103;
    private final int maxScore = 5;
    private final int minPrice = 20;
    private final int maxPrice = 80;
    private final int maxPrepTime = 300;
    private final int minPrepTime = 5;

    private final String[] names = {"Anita","Brigitte","Bernadette","Claude","Rémonde","Joséphine","Gertrude","Lucette",
            "Jinette","Martine","Nathalie","Françoise","Anne","Marie-France","Marie-Anne","Anne-Marie","Jeanne","Isabelle",
            "Martine","Nadine","Béatrice","Monique","Colette","Francine","Thérèse","Josianne","Gisèle","Murielle","Aline",
            "Paule","Albertine","Capucine","Chistiane","Christine","Catherine","Odile","Michelle","Noëlle","Natalia"
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
            "Je vous parlerez de mes petits fils décédés.",
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
            "Je suis une grand-mère qui croit que la nourriture doit être savoureuse, mais aussi belle à regarder. Si vous êtes sensible à la présentation de vos plats, alors nous avons déjà un point en commun !"

    };

    private final String[] dishNames = {
            "Paëla","Moules frites","Pizza","Hamburger","Fish and chips","Pâtes à la carbonnara","Fondue vingnerone",
            "Dorade royale","Sushis","Makis","Tempuras","Lasagne","Poke bowl","Raclette","Méchoui","Dinde de Noêlle",
            "Cordon bleu","Crêpes","Hachis parmentier","Soupe à l'ail","Pissaladière","Fondue Savoyarde","Fondue Bourguignone",
            "Pâtes bolognaise","Gauffres","Quatre-quarts","Café gourmand","Daube de boeuf carottes","Blanquette de veau",
            "Purée de pommes de terre","Blanc de dinde à la moutarde","Rôti de veau","Gratin dauphinois","Pot au feu",
            "Filet mignon de porc"
    };

    private final String[] dishNotes = {
            "dishNoteVide",
            "Oh zut, ça écris ce que je dit. Hihi c'est drôle comment on enlève cette connerie ?",
            "Succulent",
            "Fantastiquement délicieux"
    };

    public Generator(){
        this.random = new Random();
    }

    private String getRandomName(){
        return names[random.nextInt(names.length)];
    }

    public Granny getNewGranny(){
        Granny granny = new Granny();
        granny.setName(getRandomName());
        granny.setAge(getRandomAge());
        granny.setLocation(getRandomLocation());
        granny.setDishes(getRandomDishes(3,12));
        granny.setScore(getRandomScore());
        granny.setDesc(getRandomDesc());
        granny.setPrice(getRandomPrice());
        granny.setUrlPicture(getRandomUrlPicture());
        return granny;
    }

    private double getRandomPrice() {
        return random.nextDouble(maxPrice-minPrice)+minPrice;
    }

    private String getRandomDesc() {
        return descriptions[random.nextInt(descriptions.length)];
    }

    private String getRandomUrlPicture() {
        return "./todo.png";
    }


    private double getRandomScore() {
        return random.nextDouble(maxScore);
    }

    private String getRandomLocation() {
        return locations[random.nextInt(locations.length)];
    }

    public Dish getNewDish(){
        Dish dish = new Dish();
        dish.setName(getRandomDishName());
        dish.setPrepTime(getRandomPrepTime());
        dish.setNote(getRandomNote());
        return dish;
    }

    private String getRandomDishName() {
        return dishNames[random.nextInt(dishNames.length)];
    }

    private String getRandomNote() {
        return dishNotes[random.nextInt(dishNotes.length)];
    }

    private String getRandomPrepTime() {
        int time = random.nextInt(maxPrepTime-minPrepTime)+minPrepTime;
        return time +" minutes";
    }

    private int getRandomAge() {
        return random.nextInt(maxAge -minAge) + minAge;
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

    public ArrayList<Granny> getNewGrannies(int number){
        ArrayList<Granny> grannies = new ArrayList<>();
        for(int i = 0; i < number; i++){
            grannies.add(getNewGranny());
        }
        return grannies;
    }


}
